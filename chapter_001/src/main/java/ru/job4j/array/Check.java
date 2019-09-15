package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        if (data.length > 0) {
            result = true;
            boolean etalon = data[0];
            for (int i = 1; i < data.length; i++) {
                if (data[i] != etalon) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
