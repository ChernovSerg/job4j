package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

public class ListCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "IvanovAAA"
        );
        assertThat(rst, lessThan(0));
        assertThat(rst, is(-3));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
        assertThat(rst, is(7));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
        assertThat(rst, is(4));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
        assertThat(rst, is(-4));
    }

    @Test
    public void firstStringEmpty() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
        assertThat(rst, is(-6));
    }

    @Test
    public void secontStringEmpty() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ura",
                ""
        );
        assertThat(rst, greaterThan(0));
        assertThat(rst, is(3));
    }
}