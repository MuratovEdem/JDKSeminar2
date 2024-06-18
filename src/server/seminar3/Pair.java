package server.seminar3;

public class Pair <T, V>{
    T t;
    V v;

    public T getFirst() {
        return t;
    }

    public V getSecond() {
        return v;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + t.getClass().getName() +
                ", v=" + v.getClass().getName() +
                '}';
    }
}
