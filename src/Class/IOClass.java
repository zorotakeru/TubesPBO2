package Class;

import javafx.scene.control.TextArea;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class IOClass {
    public void history(String s) {
        String path = "src/IO/HistoryAll.txt";
        List<String> textList;
        String text = null;
        String fill = s + "\n";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((text = reader.readLine()) != null) {
                fill = fill + text + "\n";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(fill);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(fill);
    }

    public void save(TextArea a){
        String path = "src/IO/HistoryGame.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(a.getText());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
