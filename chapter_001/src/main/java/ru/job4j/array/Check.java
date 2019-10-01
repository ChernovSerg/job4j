package ru.job4j.array;

public class Check {
    /**
     * Method determines if an array consists of identical elements
     *
     * @param data array of boolean values
     * @return true if array consists of identical elements, else - false
     */
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
