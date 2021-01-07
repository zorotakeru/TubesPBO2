package Class;

import java.io.*;
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
}
