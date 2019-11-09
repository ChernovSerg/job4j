package ru.job4j.list;

import java.util.ArrayList;
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

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int el : arr) {
                result.add(el);
            }
        }
        return result;
    }
}
