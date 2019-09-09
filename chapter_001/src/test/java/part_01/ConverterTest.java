package part_01;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.part_01.Converter;

public class ConverterTest {
    @Test
    public void roubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void roubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void dollarToRuble() {
        int in = 3;
        int expected = 180;
        int out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euro() {
        int in = 3;
        int expected = 210;
        int out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out);
    }
}
