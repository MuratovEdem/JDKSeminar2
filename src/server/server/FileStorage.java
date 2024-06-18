package server.server;

import server.client.ClientGUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStorage implements Repository{
    public static final String LOG_PATH = "src/server/log.txt";

    @Override
    public void saveHistory(String message) {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(LOG_PATH, true))) {
            logWriter.write(message + "\n");
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        if (Files.exists(Paths.get(LOG_PATH))) {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(LOG_PATH))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line)
                            .append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
