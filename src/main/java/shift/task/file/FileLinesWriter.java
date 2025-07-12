package shift.task.file;

import shift.task.model.ListWithType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileLinesWriter {
    private String path;
    private String prefix;
    private Boolean isAdd;

    private Map<Class<?>, String> fileNames = new HashMap<>() {};

    public FileLinesWriter(String path, String prefix, Boolean isAdd) {
        this.path = path;
        this.prefix = prefix;
        this.isAdd = isAdd;

        fileNames.put(Integer.class, "integers");
        fileNames.put(Float.class, "floats");
        fileNames.put(String.class, "strings");
    }

    public void writeToFile(ListWithType object) {
        if (object.getList() == null || object.getList().isEmpty()) return;

        String fileName;
        try {
            fileName = fileNames.get(object.getType());
        } catch (Exception e) {
            System.err.println("Значение не принадлежит к Integer, Float или String");
            return;
        }
        Path basePath = Paths.get(this.path);
        Path filePath = basePath.resolve(prefix + fileName + ".txt");

        try {
            if (!Files.exists(basePath)) {
                Files.createDirectories(basePath);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), isAdd))) {
                for (String item : object.getList()) {
                    writer.write(item);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка при записи в " + filePath);
        }
    }

}
