package shift.task.statistics;

public class FullStatistics implements Statistics{
    private int integersCounter = 0;
    private int floatsCounter = 0;
    private int stringsCounter = 0;
    private long integersSum = 0;
    private double floatsSum = 0;
    private long integersMin = Long.MAX_VALUE;
    private long integersMax = Long.MIN_VALUE;
    private double floatsMin = Double.MAX_VALUE;
    private double floatsMax = Double.MIN_VALUE;
    private long stringsMin = Long.MAX_VALUE;
    private long stringsMax = Long.MIN_VALUE;


    @Override
    public void addInteger(long value){
        integersCounter++;
        integersSum += value;
        if (value < integersMin){
            integersMin = value;
        }
        if (value > integersMax){
            integersMax = value;
        }
    }

    @Override
    public void addFloat(double value){
        floatsCounter++;
        floatsSum += value;
        if (value < floatsMin){
            floatsMin = value;
        }
        if (value > floatsMax){
            floatsMax = value;
        }
    }

    @Override
    public void addString(String value){
        stringsCounter++;
        if (value.length() < stringsMin){
            stringsMin = value.length();
        }
        if (value.length() > stringsMax){
            stringsMax = value.length();
        }
    }

    @Override
    public void printStatistics() {
        System.out.println("Полная статистика");
        if (integersCounter != 0) {
            System.out.println("Статистика по Integer");
            System.out.println("Количество: " + integersCounter + ", минимальное: " + integersMin + ", максимальное: " + integersMax + ", сумма:" + integersSum + ", среднее: " + integersSum / integersCounter);
        }
        if (floatsCounter != 0) {
            System.out.println("Статистика по Float");
            System.out.println("Количество: " + floatsCounter + ", минимальное: " + floatsMin + ", максимальное: " + floatsMax + ", сумма:" + floatsSum + ", среднее: " + floatsSum / (double) floatsCounter);
        }
        if (stringsCounter != 0) {
            System.out.println("Статистика по String");
            System.out.println("Количество: " + stringsCounter + ", минимальная длина: " + stringsMin + ", максимальная длина: " + stringsMax);
        }

    }
}
