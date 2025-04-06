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
        int[] expected = {12, 43, 76, 98, 21, 89, 56, 23};

        Container c = new Container();
        c.add(expected, 8);

        int[] actual = c.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getByIndex() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        Integer[] actual = {c.getByIndex(5), c.getByIndex(-5), c.getByIndex(10)};

        Integer[] expected = {89, null, null};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addToIndex() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        c.addToIndex(1, 5);
        c.addToIndex(2, -1);
        c.addToIndex(3, 90);
        int[] actual = c.getAll();

        int[] expected = {2, 12, 43, 76, 98, 21, 1, 89, 56, 23, 3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testAddToIndex() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        int[] a = {1, 2, 3};
        Container c = new Container();
        c.add(b, 8);

        c.addToIndex(a, 3, 4);
        c.addToIndex(a, 3, -5);
        c.addToIndex(a, 3, 90);
        int[] actual = c.getAll();

        int[] expected = {1, 2, 3, 12, 43, 76, 98, 1, 2, 3, 21, 89, 56, 23, 1, 2, 3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getIndexOf() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 12};
        Container c = new Container();
        c.add(b, 8);

        int[] actual = {c.getIndexOf(43), c.getIndexOf(9)};

        int[] expected = {1, -1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getLast() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        int actual = c.getLast();

        int expected = 23;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        boolean[] actual = new boolean[2];
        actual[0] = c.isEmpty();
        c.clear();
        actual[1] = c.isEmpty();

        boolean[] expected = {false, true};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void has() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        boolean[] actual = {c.has(98), c.has(87)};

        boolean[] expected = {true, false};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        int actual = c.size();

        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }
}