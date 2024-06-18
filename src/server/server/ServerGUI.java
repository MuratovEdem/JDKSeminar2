package server.server;

import server.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ServerGUI extends JFrame implements ServerView{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private JButton btnStart, btnStop;
    private JTextArea log;

    private ServerController server;

    private JList<String> userList;
    private DefaultListModel<String> userListModel;


    public ServerGUI(ServerController server) {
        this.server = server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                server.start();
            }
        });
        btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                server.stop();
                userListModel.clear();
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }


    @Override
    public void showOnLogs(String message) {
        log.append(message);
    }

    @Override
    public void connectUser(String name) {
        userListModel.addElement(name);
    }

    @Override
    public void disconnectUser(String name) {
        userListModel.removeElement(name);
    }
}
