package part_01;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.part_01.SqArea;

public class SqAreaTest {
    @Test
    public void square() {
        int p = 6;
        int k = 2;
        int expected = 2;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }
}
