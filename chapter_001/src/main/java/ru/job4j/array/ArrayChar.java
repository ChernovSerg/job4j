package ru.job4j.array;

public class ArrayChar {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = false;

        if (word != null
            && pref != null
            && word.length > 0
            && pref.length > 0
            && word.length >= pref.length
        ) {
            result = true;
            for (int i = 0; i < pref.length; i++) {
                if (word[i] != pref[i]) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
