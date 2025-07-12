package shift.task.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLinesReader {
    private ArrayList<String> files = new ArrayList<>();

    public FileLinesReader(List<String> files) {
        this.files.addAll(files);
    }

    public ArrayList<String> getAllLines() {
        ArrayList<String> allLines = new ArrayList<>();
        for (String file : files) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    allLines.add(line);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Файл " + file + " не найден");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return allLines;
    }
}
