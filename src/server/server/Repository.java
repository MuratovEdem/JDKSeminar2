package server.server;

public interface Repository {
    void saveHistory(String message);
    String getHistory();
}
