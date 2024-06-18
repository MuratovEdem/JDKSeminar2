package server.seminar3;

public class Calculator {
    public static <T extends Number, V extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double substract(T a, U b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T a, U b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T a, U b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException();
        } else return a.doubleValue() / b.doubleValue();
    }
}
