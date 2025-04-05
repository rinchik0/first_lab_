package org.rinchik;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ContainerTest {

    @Test
    void add() {
        int[] expected = {1, 0, 10, 20, 30, 40};

        Container c = new Container();
        int[] b = {0, 10, 20, 30, 40};

        c.add(1);
        c.add(b, 5);
        int[] actual = c.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getAll() {
    }
}