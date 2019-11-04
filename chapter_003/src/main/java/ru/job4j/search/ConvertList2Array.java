package ru.job4j.search;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int remainder = list.size() % rows;
        int division = list.size() / rows;
        int cells = remainder == 0 ? division : ++division;
        int[][] array = new int[rows][cells];
        int row = 0, col = 0;
        for (Integer el : list) {
            if (row < rows) {
                array[row][col++] = el;
                if (col == cells) {
                    col = 0;
                    row++;
                }
            }
        }
        return array;
    }
}
