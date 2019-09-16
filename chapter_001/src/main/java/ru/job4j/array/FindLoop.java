package ru.job4j.array;

public class FindLoop {
    /**
     * Method search element position from array.
     *
     * @param data array of integer
     * @param el   required element
     * @return the position of the element found or -1 if the element is not found
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Method search element position from array from start position to end position.
     *
     * @param data   origin array
     * @param el     required element
     * @param start  start position for search, starts at 0
     * @param finish end position for search, ends with a value equal to the size-1 of the origin array
     * @return the position of the element found or -1 if the element is not found
     */
    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        if (data.length > start && data.length > finish) {
            for (int index = start; index <= finish; index++) {
                if (data[index] == el) {
                    rst = index;
                    break;
                }
            }
        }
        return rst;
    }
}
