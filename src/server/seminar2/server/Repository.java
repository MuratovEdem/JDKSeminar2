package server.seminar2.server;

public interface Repository {
    void saveHistory(String message);
    String getHistory();
}
