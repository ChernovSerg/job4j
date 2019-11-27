package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        if (o1.length() > 0 && o2.length() > 0) {
            int i = 0;
            while (i < o1.length() && i < o2.length()) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    result = o1.charAt(i) - o2.charAt(i);
                    break;
                }
                i++;
            }
            if (result == 0 && (o1.length() != o2.length())) {
                result = o1.length() - o2.length();
            }
        } else if (o1.length() > 0 || o2.length() > 0) {
            result = o1.length() > 0 ? o1.length() : -o2.length();
        }
        return result;
    }
}
