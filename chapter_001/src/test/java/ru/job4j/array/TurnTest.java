package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] originArray = new int[] {6, 2, 4, 8};
        int[] expectArray = new int[] {8, 4, 2, 6};
        int[] result = turn.back(originArray);
        assertThat(result, is(expectArray));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] originArray = new int[] {6, 2, 4, 8, -5};
        int[] expectArray = new int[] {-5, 8, 4, 2, 6};
        int[] result = turn.back(originArray);
        assertThat(result, is(expectArray));
    }

}