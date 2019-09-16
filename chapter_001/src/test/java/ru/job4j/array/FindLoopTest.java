package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class FindLoopTest {

    @Test
    public void findTest1() {
        int[] array = {2, -3, 5, 8, -2};
        FindLoop find = new FindLoop();
        int pos = find.indexOf(array, 8);
        assertThat(pos, is(3));
    }

    @Test
    public void findTest2() {
        int[] array = {2, -3, 5, 8, -2};
        FindLoop find = new FindLoop();
        int pos = find.indexOf(array, 6);
        assertThat(pos, is(-1));
    }

    @Test
    public void whenGoodFindAtFirstArray() {
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = FindLoop.indexOf(input, value, 0, 2);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenGoodFindInsideArray() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }


    @Test
    public void whenGoodFindInEndArray() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 4;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 4;
        assertThat(result, is(expect));
    }

    @Test
    public void whenElementAbsentInArray() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 14;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenBadStartPosition() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 6;
        int finish = 3;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenBadFinishPosition() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 0;
        int finish = 8;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void findMinGood() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int result = FindLoop.min(input, 0, input.length-1);
        assertThat(result, is(2));
    }

    @Test
    public void findMinFromEmptyArray() {
        int[] input = null;
        try {
            int result = FindLoop.min(input, 0, input.length);
        } catch (NullPointerException e) {
            assertThat(e, is(NullPointerException.class));
        }
    }

    @Test
    public void findMinFromBlankArray() {
        int[] input = new int[]{};
        try {
            int result = FindLoop.min(input, 0, input.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertThat(e, is(ArrayIndexOutOfBoundsException.class));
        }
    }

    @Test
    public void findMinWithIncorrectlyArgument() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        try {
            int result = FindLoop.min(input, 0, 10);
        } catch (IllegalArgumentException e) {
            assertThat(e, is(IllegalArgumentException.class));
        }
    }

    @Test
    public void sortTest1() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int[] expect = new int[]{2, 2, 4, 5, 10};
        int[] result = FindLoop.sort(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortTest2() {
        int[] input = new int[]{5, 2, 10};
        int[] expect = new int[]{2, 5, 10};
        int[] result = FindLoop.sort(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortTest3() {
        int[] input = new int[]{10, 5, 2};
        int[] expect = new int[]{2, 5, 10};
        int[] result = FindLoop.sort(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortTest4() {
        int[] input = new int[]{5, 2};
        int[] expect = new int[]{2, 5};
        int[] result = FindLoop.sort(input);
        assertThat(result, is(expect));
    }
}