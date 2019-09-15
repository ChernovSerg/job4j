package ru.job4j.array;

public class ArrayChar {
    /**
     * Method determines the "word" begins or not at the "pref"
     * @param word
     * @param pref
     * @return true, if word ends in "pref"
     */
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

    /**
     * Method determines the "word" ends or not at the "post"
     * @param word
     * @param post
     * @return true, if word ends in "post"
     */
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        if (word != null
                && post != null
                && word.length > 0
                && post.length > 0
                && word.length >= post.length
        ) {
            result = true;
            for (int i = 0; i < post.length; i++) {
                if (word[word.length - 1 - i] != post[post.length - 1 - i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
