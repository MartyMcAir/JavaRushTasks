package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            //Add your code here
            // getBook() - получаем экземпляр класса наследовавшего и реализовавшего данный метод
            if(getBook() instanceof  MarkTwainBook){
                output = markTwainOutput;
            }
            if(getBook() instanceof  AgathaChristieBook){
                output = agathaChristieOutput;
            }
            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {
        private String title;
        private static String author = "Mark Twain"; // make static _ del err

        public MarkTwainBook(String title) {
            super(author); // Cannot Reference “X” Before Supertype Constructor Has Been Called
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle(){
            return title;
        }
    }

    public static class AgathaChristieBook extends Book {
        private String title;
        private static String author = "Agatha Christie"; // make static _ del err

        public AgathaChristieBook(String title) {
            super(author); // Cannot Reference “X” Before Supertype Constructor Has Been Called
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle(){
            return title;
        }
    }
}
