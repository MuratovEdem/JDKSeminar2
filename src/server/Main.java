package server;

import server.client.ClientController;
import server.client.ClientGUI;
import server.server.ServerController;
import server.server.ServerGUI;

public class Main {
    public static void main(String[] args) {

        //создание объектов сервера и создание связи между ними
        ServerController server = new ServerController();
        ServerGUI serverGUI = new ServerGUI(server);
        server.setServerView(serverGUI);

        ClientController clientController1 = new ClientController();
        clientController1.setServer(server);
        ClientGUI clientGUI1 = new ClientGUI();
        clientGUI1.setClient(clientController1);
        clientController1.setClientView(clientGUI1);

        ClientController clientController2 = new ClientController();
        clientController2.setServer(server);
        ClientGUI clientGUI2 = new ClientGUI();
        clientGUI1.setClient(clientController2);
        clientController2.setClientView(clientGUI2);
    }
}
