package org.rinchik;

/**
 * Класс-контейнер для хранения произвольного количества целых чисел.
 * Позволяет хранить, добавлять, удалять элементы.
 */
public class Container {
    private int[] numbers;
    // n - хранит длину массива (выделенную, не заполненную)
    // cnt - хранит длину заполненной части массива
    private int n, cnt;
    public Container() {
        cnt = 0;
        n = 10;
        numbers = new int[n];
    }
    // Операция расширения массива (вызывается, когда не хватает места на запись нового числа)
    private void extend() {
        int constant = 2;
        int[] lastNumbers = new int[n];
        System.arraycopy(numbers, 0, lastNumbers, 0, n);
        int newN = n * constant;
        numbers = new int[newN];
        System.arraycopy(lastNumbers, 0, numbers, 0, n);
        n = newN;
    }
    // Операция добавления одного нового числа по умолчанию (в конец массива)
    public void add(int number) {
        if (cnt == n) extend();
        numbers[cnt] = number;
        cnt++;
    }
    // Функция, возвращающая числа под переданным индексом, в случае отсутстия такого возвращает null
    public Integer getByIndex(int index) { return 0; }
    // Операция добавления массива новых чисел по умолчанию (в конец массива)
    public void add(int[] Numbers, int N) {
        if (N > 0) {
            while (n <= cnt + N) extend();
            for (int i = 0; i < N; i++) {
                numbers[cnt] = Numbers[i];
                cnt++;
            }
        }
    }
    // Операция добавления одного нового числа на место под переданным индексом.
    // Если такой индекс не доступен, добавит либо в конец, либо в начало
    public void addToIndex(int number, int index) {}
    // Операция добавления массива новых чисул на место под переданным индексом.
    // Если такой индекс не доступен, добавит либо в конец, либо в начало
    public void addToIndex(int[] Numbers, int N, int index) {}
    //  Функция, возвращающая индекс первого вхождения переданного числа. В случае отсутствия вернет -1
    public int getIndexOf(int number) { return 0; }
    // Операция удаления первого вхождения переданного числа.
    // В случае успешного удаления вернет true, иначе false
    public boolean delete(int number) { return false; }
    // Операция удаления последнего числа в контейнере
    public boolean deleteLast() { return false; }
    // Операция удаления числа по его индексу
    public boolean deleteByIndex(int index) { return false; }
    // Операция получения последнего числа в контейнере
    public Integer getLast() { return 0; }
    // Операция полного очищения контейнера
    public void clear() {}
    // Функция, возвращающая true, если в контейнере есть числа, и false - если нет
    public boolean isEmpty() { return false; }
    // Функция, возвращающая true, если переданное число есть в контейнере, и false - если нет
    public boolean has(int number) { return false; }
    // Функция, возвращающая количество элементов в контейнере
    public int size() { return 0; }
    // Функция, возвращающая коллекцию элементов контейнера (без незаполненных нулей)
    public int[] getAll() {
        int[] result = new int[cnt];
        System.arraycopy(numbers, 0, result, 0, cnt);
        return result;
    }
}
