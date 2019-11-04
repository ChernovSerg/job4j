package ru.job4j.search;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int remainder = list.size() % rows;
        int division = list.size() / rows;
        int cells = remainder == 0 ? division : ++division;
        int[][] array = new int[rows][cells];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (k < list.size()) {
                    array[i][j] = list.get(k++);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
