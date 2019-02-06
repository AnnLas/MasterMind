package sample;

import java.util.ArrayList;
import java.util.List;

public class ArrayHashWrapper {
    private ArrayList<Integer> list;


    public ArrayHashWrapper(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ArrayHashWrapper that = (ArrayHashWrapper) o;
        List<Integer> foreignList = that.getList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != foreignList.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * list.size();

        for (Integer number : list) {
            result = 31 * result + number;
        }

        return result;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
}
