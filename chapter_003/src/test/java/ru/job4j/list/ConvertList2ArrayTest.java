package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void testConvert() {
        ConvertList2Array convertList2Array = new ConvertList2Array();
        List<int[]> list = Arrays.asList(
                new int[]{11, 12, 13},
                new int[]{21, 22, 23, 24, 25},
                new int[]{31, 32});
        List<Integer> expected = Arrays.asList(11, 12, 13, 21, 22, 23, 24, 25, 31, 32);
        List<Integer> actual = convertList2Array.convert(list);
        assertThat(actual, is(expected));
    }
}