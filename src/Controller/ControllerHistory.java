package Controller;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ControllerHistory {
    public TextArea historyArea;
    public TextArea battleArea;

    public void initialize(){
        String path = "src/IO/HistoryGame.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String text;
            while ((text = reader.readLine()) != null) {
                battleArea.appendText(text + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String path2 = "src/IO/HistoryAll.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path2));
            String text2;
            while ((text2 = reader.readLine()) != null) {
                historyArea.appendText(text2 + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

