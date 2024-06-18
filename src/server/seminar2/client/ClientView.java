package server.seminar2.client;

/**
 * Интерфейс описывающий абстракцию GUI
 */
public interface ClientView {
    void showMessage(String message);
    void disconnectedFromServer();
    void connectToServer();
}
