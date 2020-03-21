package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    public List<Integer> readFileToCollection(List<Integer> collection, String path) {
        try (FileInputStream inputStream = new FileInputStream(path);
             Scanner sc = new Scanner(inputStream, "UTF-8")) {

            while (sc.hasNextInt()) {
                Integer number = sc.nextInt();
                collection.add(number);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return collection;
    }
}
