package ru.job4j.condition;

public class Triangle {
    /**
     * Determines if a triangle exists with such sides
     * @param ab length of the first side of the triangle
     * @param bc length of the second side of the triangle
     * @param ac length of the third side of the triangle
     * @return
     */
    public static boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if ((ab + ac) > bc
                && (ab + bc) > ac
                && (bc + ac) > ab
        ) {
            result = true;
        }
        return result;
    }
}
