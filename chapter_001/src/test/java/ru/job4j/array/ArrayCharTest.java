package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {

    /**
     * Tests for the "startsWith" method
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenWordLessPrefixThenFalse() {
        char[] word = {'H', 'e'};
        char[] pref = {'H', 'e', 'l'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenWordIsNullThenFalse() {
        char[] word = null;
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenPrefixIsNullThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = null;
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }

    /**
     * Tests for the "endsWith" method
     */
    @Test
    public void whenEndsWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'o'};
        boolean result = ArrayChar.endsWith(word, post);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotEndWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'a'};
        boolean result = ArrayChar.endsWith(word, post);
        assertThat(result, is(false));
    }

    @Test
    public void whenWordLessPostThenFalse() {
        char[] word = {'H', 'e'};
        char[] post = {'l', 'l', 'o'};
        boolean result = ArrayChar.endsWith(word, post);
        assertThat(result, is(false));
    }

    @Test
    public void whenWordIsNullThenFalse2() {
        char[] word = null;
        char[] post = {'l', 'a'};
        boolean result = ArrayChar.endsWith(word, post);
        assertThat(result, is(false));
    }

    @Test
    public void whenPostIsNullThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = null;
        boolean result = ArrayChar.endsWith(word, post);
        assertThat(result, is(false));
    }

}