package server.server;

import server.client.ClientController;
import server.client.ClientGUI;
import server.client.ClientView;

import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private ServerView serverView;

    private Repository repository;

    private List<ClientController> clients;

    private boolean work;

    public ServerController() {
        clients = new ArrayList<>();
        repository = new FileStorage();
        work = false;
    }

    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }

    public boolean connectUser(ClientController clientController) {
        if (!work){
            return false;
        }
        clients.add(clientController);
        return true;
    }

    public void disconnectUser(ClientController clientController) {
        clients.remove(clientController);
        serverView.disconnectUser(clientController.getName());
        serverView.showOnLogs(clientController.getName() + " disconnected...\n");
    }

    public void message(String message) {
        if (work) {
            serverView.showOnLogs(message + "\n");
            for (ClientController client: clients) {
                client.answerFromServer(message + "\n");
            }
            saveHistory(message);
        }
    }

    public void start() {
        if(!work) {
            work = true;
            serverView.showOnLogs("Server started...\n");
            serverView.showOnLogs(getHistory());
        } else {
            serverView.showOnLogs("Server is already running...\n");
        }
    }

    public void stop() {
        if (work) {
            work = false;
            serverView.showOnLogs("Server stopped...\n");
            while (!clients.isEmpty()) {
                clients.get(clients.size()-1).disconnectFromServer();
            }
        } else {
            serverView.showOnLogs("Server is not running...\n");
        }
    }

    public void saveHistory(String msg) {
        repository.saveHistory(msg);
    }

    public String getHistory() {
        return repository.getHistory();
    }

}
