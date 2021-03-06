package com.javarush.task.task23.task2312;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public static Room game;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;

        print();

    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            try {
                sleep();        //пауза между ходами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game Over!");
    }

    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] matrix = new int[height][width];

        //Рисуем все кусочки змеи
        ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>(snake.getSections());
        for (SnakeSection snakeSection : sections) {
            matrix[snakeSection.getY()][snakeSection.getX()] = 1;
        }

        //Рисуем голову змеи (4 - если змея мертвая)
        matrix[snake.getY()][snake.getX()] = snake.isAlive() ? 2 : 4;

        //Рисуем мышь
//        matrix[mouse.getY()][mouse.getX()] = 3;

        //Выводим все это на экран
        char[] symbols = {'.', 'x', 'X', '^', 'R'};
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(symbols[matrix[y][x]]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void eatMouse() {
        createMouse();
    }

    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public void sleep() throws InterruptedException {
        // делаем паузу, длинна которой зависит от длинны змеи
//        if (getSnake().getSections().size() > 15) {
//            Thread.sleep(200);
//        }
//
//        switch (getSnake().getSections().size()) {
//            case 1:
//                Thread.sleep(500);
//                break;
//            case 11:
//                Thread.sleep(300);
//                break;
//            case 16:
//                Thread.sleep(200);
//                break;
//        }

        int size = snake.getSections().size();
        if (size <= 11) {
            Thread.sleep(500 - (size - 1) * 20);
        } else {
            Thread.sleep(300 - Math.min(100, (size - 11) * 25));
        }
    }

    public static void main(String[] args) {
        // игра это Room final переменная
        // в конструкторе сеттеры полей и метод print()

        // в методе print(), int[][] matrix = new int[height][width];
        // в матрице в цикле, через список snakeSection - от куда получают координаты змеи
        // там же проверка состояния змеи, на то жива ли она isAlive()
        // далее какая-то магия, вывода матрицы в консоль
        game = new Room(20, 20, new Snake(10, 10));

        // SnakeDirection - enum перечисления, со значениями: UP, RIGHT, DOWN, LEFT
        game.snake.setDirection(SnakeDirection.DOWN);

        // createMouse() задает рандомные координаты точки для змеи в пределах height и width
        game.createMouse();

        // run() - стартует keyboardObserver который extends Thread и поидее создает окно,
        // но окно не появляется.. _ и отслеживает сирелки клавиатуры (юзает KeyListener и KeyEvent)
        // потом, условие по нажатию q = quit выход   if (event.getKeyChar() == 'q')
        // потом в цикле: отслеживание стрелок (проверкой if.. getKeyCode..)
        // здесь же диваем мышь  snake.move() - в move() условие проверяет текущий snake direction
        //          в move() - идет проверка на if (!isAlive) return; - сам метод void - но
        //          но если мышь не жива вернет return; а значит прервет цикл
        // и проверяет жива ли змея,тут же в цикле выводит в консоль print()-текущее состояние змеи
        // далее в цикле идет sleep() - пауза зависящяя от длины змеи
        // после цикла идет System.out.println("Game Over!"); _
        game.run();
    }
}
