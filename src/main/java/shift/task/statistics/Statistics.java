package shift.task.statistics;

public interface Statistics {

    void addInteger(long value);

    void addFloat(double value);

    void addString(String value);

    void printStatistics();
}
