package org.rinchik;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.rinchik.interfaces.MyIterator;

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

    @Test
    void delete() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 76};
        Container c = new Container();
        c.add(b, 8);

        boolean[] actualResult = {c.delete(76), c.delete(2)};
        int[] resultArray = c.getAll();
        Object[] actual = {actualResult, resultArray};

        boolean[] expectedResult = {true, false};
        int[] expectedArray = {12, 43, 98, 21, 89, 56, 76};
        Object[] expected = {expectedResult, expectedArray};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteLast() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        boolean[] actualResult = new boolean[2];
        actualResult[0] = c.deleteLast();
        int[] actualArray = c.getAll();
        for (int i = 0; i < 7; i++)
            c.deleteLast();
        actualResult[1] = c.deleteLast();
        Object[] actual = {actualResult, actualArray};

        boolean[] expectedResult = {true, false};
        int[] expectedArray = {12, 43, 76, 98, 21, 89, 56};
        Object[] expected = {expectedResult, expectedArray};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteByIndex() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        boolean[] actualResult = {c.deleteByIndex(6), c.deleteByIndex(-1), c.deleteByIndex(78)};
        int[] actualArray = c.getAll();
        Object[] actual = {actualResult, actualArray};

        boolean[] expectedResult = {true, false, false};
        int[] expectedArray = {12, 43, 76, 98, 21, 89, 23};
        Object[] expected = {expectedResult, expectedArray};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void clear() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        c.clear();
        int[] actual = c.getAll();

        int[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteDuplicates() {
        int[] b = {12, 43, 12, 98, 21, 12, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        c.deleteDuplicates(12);
        int[][] actual = new int[2][8];
        actual[0] = c.getAll();
        c.deleteDuplicates(1);
        actual[1] = c.getAll();

        int[][] expected = {{43, 98, 21, 56, 23}, {43, 98, 21, 56, 23}};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteN() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        boolean[] actualResult = new boolean[3];
        actualResult[0] = c.deleteN(2, 3);
        int[] actualArray1 = c.getAll();
        actualResult[1] = c.deleteN(4, 3);
        int[] actualArray2 = c.getAll();
        actualResult[2] = c.deleteN(-1, 6);
        int[] actualArray3 = c.getAll();
        Object[] actual = {actualResult, actualArray1, actualArray2, actualArray3};

        boolean[] expectedResult = {true, false, false};
        int[] expectedArray1 = {12, 43, 89, 56, 23};
        int[] expectedArray2 = {12, 43, 89, 56};
        int[] expectedArray3 = {12, 43, 89, 56};
        Object[] expected = {expectedResult, expectedArray1, expectedArray2, expectedArray3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void createIterator() {
        int[] b = {12, 43, 76, 98, 21, 89, 56, 23};
        Container c = new Container();
        c.add(b, 8);

        String actual = "";
        MyIterator iterator = c.createIterator();
        while (iterator.hasNext())
            actual += (iterator.next() + " ");

        String expected = "12 43 76 98 21 89 56 23 ";

        Assertions.assertEquals(expected, actual);
    }
}