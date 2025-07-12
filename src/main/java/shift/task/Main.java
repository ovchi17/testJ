package shift.task;

import shift.task.arguments.Arguments;
import shift.task.file.FileLinesReader;
import shift.task.file.FileLinesWriter;
import shift.task.filter.ClassFilter;
import shift.task.statistics.FullStatistics;
import shift.task.statistics.ShortStatistics;
import shift.task.statistics.Statistics;

public class Main {
    public static void main(String[] args) {

        Arguments arguments = new Arguments(args);
        Statistics statistics = null;

        FileLinesReader fileLinesReader = new FileLinesReader(arguments.getFiles());

        if (arguments.isShortStatistics()){
            statistics = new ShortStatistics();
        } else if (arguments.isFullStatistics()) {
            statistics = new FullStatistics();
        }

        ClassFilter classFilter = new ClassFilter(fileLinesReader.getAllLines(), statistics);

        FileLinesWriter fileLinesWriter = new FileLinesWriter(arguments.getPath(), arguments.getPrefix(), arguments.isAddMode());
        fileLinesWriter.writeToFile(classFilter.getIntegers());
        fileLinesWriter.writeToFile(classFilter.getFloats());
        fileLinesWriter.writeToFile(classFilter.getStrings());

        if (statistics != null) statistics.printStatistics();

    }
}