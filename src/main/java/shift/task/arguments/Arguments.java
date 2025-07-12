package shift.task.arguments;

import java.util.ArrayList;

public class Arguments {
    private String path = ""; // путь в папке -o
    private String prefix = ""; // префикс файлов -p
    private boolean add = false; // режим добавления -a
    private boolean shortStatistics = false; // краткая статистика -s
    private boolean fullStatistics = false; // полная статистика -f

    private ArrayList<String> files = new ArrayList<>();

    public Arguments (String[] args){
        parser(args);
    }

    public void parser(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 >= args.length) {
                        System.err.println("Отсутствует параметр для -o. Флаг -o не будет использоваться");
                        break;
                    } else if (args[i + 1].startsWith("-")) {
                        System.err.println("В качестве параметра для флага -o был передан аргумент: " + args[i + 1] + ". Флаг -o не будет использоваться");
                        break;
                    }
                    this.path = args[++i];
                    break;
                case "-p":
                    if (i + 1 >= args.length) {
                        System.err.println("Отсутствует параметр для -p. Флаг -p не будет использоваться");
                        break;
                    } else if (args[i + 1].startsWith("-")) {
                        System.err.println("В качестве параметра для флага -p был передан аргумент: " + args[i + 1] + ". Флаг -p не будет использоваться");
                        break;
                    }
                    this.prefix = args[++i];
                    break;
                case "-a":
                    this.add = true;
                    break;
                case "-s":
                    this.shortStatistics = true;
                    break;
                case "-f":
                    this.fullStatistics = true;
                    break;
                default:
                    files.add(args[i]);
                    break;
            }
        }

        if (files.isEmpty()){
            System.err.println("Файлы не указаны в аргументах.");
            System.exit(0);
        }
        if (this.fullStatistics && this.shortStatistics) {
            System.err.println("Флаги -s и -f несовместимы, будет выведена только полная статистика");
            this.shortStatistics = false;
        }
    }

    public String getPath() {
        return path;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAddMode() {
        return add;
    }

    public boolean isShortStatistics() {
        return shortStatistics;
    }

    public boolean isFullStatistics() {
        return fullStatistics;
    }

    public ArrayList<String> getFiles() {
        return files;
    }
}
