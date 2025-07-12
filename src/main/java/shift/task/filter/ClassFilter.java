package shift.task.filter;

import shift.task.model.ListWithType;
import shift.task.statistics.Statistics;

import java.util.ArrayList;
import java.util.List;

public class ClassFilter {

    private ArrayList<String> integers = new ArrayList<>();
    private ArrayList<String> floats = new ArrayList<>();
    private ArrayList<String> strings = new ArrayList<>();
    private Statistics statistics = null;

    private boolean isFloat(String line){
        try {
            Double.parseDouble(line);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isInteger(String line){
        try {
            Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ClassFilter(List<String> data, Statistics statistics) {
        this.statistics = statistics;
        filter(data);
    }

    private void filter(List<String> data) {
        for (String line : data) {
            String trimmedLine = line.trim();
            if (trimmedLine.isEmpty()) continue;
            if (isInteger(trimmedLine)) {
                if (statistics != null) {
                    statistics.addInteger(Long.parseLong(trimmedLine));
                }
                integers.add(trimmedLine);
            }else if (isFloat(trimmedLine)) {
                if (statistics != null) {
                    statistics.addFloat(Double.parseDouble(trimmedLine));
                }
                floats.add(trimmedLine);
            }else {
                if (statistics != null) {
                    statistics.addString(trimmedLine);
                }
                strings.add(trimmedLine);
            }
        }
    }

    public ListWithType getIntegers(){
        return new ListWithType(integers, Integer.class);
    }
    public ListWithType getFloats(){
        return new ListWithType(floats, Float.class);
    }
    public ListWithType getStrings(){
        return new ListWithType(strings, String.class);
    }

}
