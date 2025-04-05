package org.rinchik;
public class Container {
    private int[] numbers;
    // n - хранит длину массива (выделенную, не заполненную)
    // cnt - хранит длину заполненной части массива
    private int n, cnt;
    public Container() {}
    // Операция расширения массива (вызывается, когда не хватает места на запись нового числа)
    private void extend() {}
    // Операция добавления одного нового числа по умолчанию (в конец массива)
    public void add(int number) {}
    // Функция, возвращающая числа под переданным индексом, в случае отсутстия такого возвращает null
    public Integer getByIndex(int index) { return 0; }
    // Операция добавления массива новых чисел по умолчанию (в конец массива)
    public void add(int[] Numbers, int N) {}
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
    public int[] getAll() { return null; }
}
