package server.seminar3;

public class Task2 {
    public static void main(String[] args) {
        Test[] task1 = {new Task3Impl2(), new Task3Impl(), new Task3Impl2()};
        Test[] task2 = {new Task3Impl2(), new Task3Impl(), new Task3Impl()};
        System.out.println(compareArrays(task1, task2));
    }

    public static <T, V> boolean compareArrays(T[] a, V[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].getClass().equals(b[i].getClass())) {
                return false;
            }
        }
        return true;
    }
}

interface Test {}

class Task3Impl implements Test {}

class Task3Impl2 implements Test {}
