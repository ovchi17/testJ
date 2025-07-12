package shift.task.model;

import java.util.List;

public class ListWithType {
    private List<String> list;
    private Class<?> type;

    public ListWithType(List<String> list, Class<?> type) {
        this.list = list;
        this.type = type;
    }

    public List<String> getList() {
        return list;
    }

    public Class<?> getType() {
        return type;
    }
}
