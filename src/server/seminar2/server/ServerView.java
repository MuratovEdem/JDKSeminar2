package server.seminar2.server;

public interface ServerView {
    void showOnLogs(String msg);
    void connectUser(String name);
    void disconnectUser(String name);
}
