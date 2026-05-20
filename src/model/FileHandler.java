package model;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    // Save simple text data to file
    public void saveToFile(String data, String fileName) {

        try {

            FileWriter writer = new FileWriter(fileName, true);

            writer.write(data + "\n");

            writer.close();

            System.out.println("Data saved to file.");

        } catch (IOException e) {

            System.out.println("File error: " + e.getMessage());
        }
    }
}