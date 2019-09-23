package ru.job4j.array;

public class FindLoop {
    /**
     * Method search element position from array.
     *
     * @param data array of integer
     * @param el   required element
     * @return the position of the element found or -1 if the element is not found
     */
    public int indexOf(final int[] data, int el) {
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
    public static int indexOf(final int[] data, int el, int start, int finish) {
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

    /**
     * Method implements sorting by selection
     *
     * @param data source array
     * @return sorted array of integers
     */
    public static int[] sort(int[] data) {
        int min = min(data, 0, data.length - 1);
        int posMin = FindLoop.indexOf(data, min, 0, data.length - 1);

        if (data.length > 1) {
            int temp = data[0];
            data[0] = data[posMin];
            data[posMin] = temp;

            for (int i = 1; i < data.length; i++) {
                int newMin = min(data, i, data.length - 1);
                int newPosMin = FindLoop.indexOf(data, newMin, i, data.length - 1);
                temp = data[i];
                data[i] = data[newPosMin];
                data[newPosMin] = temp;
            }
        }
        return data;
    }

    /**
     * Return minimum array element.
     *
     * @param data   source array.
     * @param start  start position for search, starts at 0
     * @param finish end position for search, ends with a value equal to the size-1 of the origin array
     * @return value of the minimum array element.
     * @throws NullPointerException           if surce array is null.
     * @throws ArrayIndexOutOfBoundsException if array is blank.
     * @throws IllegalArgumentException       if start or finish larger than array size.
     */
    public static int min(final int[] data, int start, int finish)
            throws NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (data == null) {
            throw new NullPointerException();
        } else if (data.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (start >= data.length || finish >= data.length) {
            throw new IllegalArgumentException();
        } else {
            int min = data[start];
            for (int i = start + 1; i < data.length; i++) {
                if (data[i] < min) {
                    min = data[i];
                }
            }
            return min;
        }
    }
}
