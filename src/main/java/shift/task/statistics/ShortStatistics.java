package shift.task.statistics;

public class ShortStatistics implements Statistics {
    private int integersCounter = 0;
    private int floatsCounter = 0;
    private int stringsCounter = 0;

    @Override
    public void addInteger(long value){
        integersCounter++;
    }

    @Override
    public void addFloat(double value){
        floatsCounter++;
    }

    @Override
    public void addString(String value){
        stringsCounter++;
    }

    @Override
    public void printStatistics() {
        System.out.println("Краткая статистика");
        System.out.println("Количество integer: " + integersCounter);
        System.out.println("Количество float: " + floatsCounter);
        System.out.println("Количество string: " + stringsCounter);
    }
}
