package com.javarush.task.task38.task3804;

public class FactoryException {
    public static Throwable createException(Enum e) {
        if (e != null) {
            String message = e.name().substring(0, 1) + e.name().substring(1)
                    .replaceAll("_", " ").toLowerCase();

            if (e instanceof ApplicationExceptionMessage)
                return new Exception(message);
            if (e instanceof DatabaseExceptionMessage)
                return new RuntimeException(message);
            if (e instanceof UserExceptionMessage)
                return new Error(message);
        }
        return new IllegalArgumentException();
    }
}
