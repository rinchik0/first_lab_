package org.rinchik;

import org.rinchik.interfaces.IterativeCollection;
import org.rinchik.interfaces.MyIterator;

/**
 * Класс-контейнер для хранения произвольного количества целых чисел.
 * Позволяет хранить, добавлять, удалять элементы.
 * Имплементирует свойства итеративной коллекции IterativeCollection.
 */
public class Container implements IterativeCollection {
    private int[] numbers;
    private int n, cnt;
    /**
     * Конструктор. Инициализирует пустой объект.
     */
    public Container() {
        cnt = 0;
        n = 10;
        numbers = new int[n];
    }
    /**
     * Приватная функция, расширяющая массив в два раза (вызывается, когда не хватает места на запись нового числа).
     */
    private void extend() {
        int constant = 2;
        int[] lastNumbers = new int[n];
        System.arraycopy(numbers, 0, lastNumbers, 0, n);
        int newN = n * constant;
        numbers = new int[newN];
        System.arraycopy(lastNumbers, 0, numbers, 0, n);
        n = newN;
    }
    /**
     * Функция, добавляющая новое число в конец контейнера.
     * @param number число, которое следует добавить
     */
    public void add(int number) {
        if (cnt == n) extend();
        numbers[cnt] = number;
        cnt++;
    }
    /**
     * Функция, возвращающая число под переданным индексом, в случае отсутствия такого возвращает null.
     * @param index индекс
     * @return целое число под индексом
     */
    public Integer getByIndex(int index) {
        if (index < cnt && index >= 0)
            return numbers[index];
        return null;
    }
    /**
     * Функция, добавляющая массив новых чисел в конец контейнера.
     * @param Numbers массив целых чисел
     * @param N длина переданного массива
     */
    public void add(int[] Numbers, int N) {
        if (N > 0) {
            while (n <= cnt + N) extend();
            for (int i = 0; i < N; i++) {
                numbers[cnt] = Numbers[i];
                cnt++;
            }
        }
    }
    /**
     * Функция, добавляющая новое число на место под переданным индексом.
     * Если такой индекс недоступен, добавит либо в конец, либо в начало.
     * @param number число для вставки
     * @param index индекс
     */
    public void addToIndex(int number, int index) {
        if (n <= cnt + 1) extend();
        if (index <= cnt) {
            if (index >= 0) {
                for (int i = cnt + 1; i > index; i--)
                    numbers[i] = numbers[i - 1];
                numbers[index] = number;
            }
            else {
                for (int i = cnt + 1; i > 0; i--)
                    numbers[i] = numbers[i - 1];
                numbers[0] = number;
            }
        }
        else numbers[cnt] = number;
        cnt++;
    }
    /**
     * Функция, добавляющая массив новых чисел на место под переданным индексом.
     * Если такой индекс недоступен, добавит либо в конец, либо в начало.
     * @param Numbers массив для вставки
     * @param N длина массива
     * @param index индекс
     */
    public void addToIndex(int[] Numbers, int N, int index) {
        if (N > 0) {
            while (n <= cnt + N) extend();
            if (index <= cnt) {
                if (index >= 0) {
                    for (int i = cnt + N; i >= index + N; i--)
                        numbers[i] = numbers[i - N];
                    System.arraycopy(Numbers, 0, numbers, index, N);
                } else {
                    for (int i = cnt + N; i >= N; i--)
                        numbers[i] = numbers[i - N];
                    System.arraycopy(Numbers, 0, numbers, 0, N);
                }
            } else System.arraycopy(Numbers, 0, numbers, cnt, N);
            cnt += N;
        }
    }
    /**
     * Функция, возвращающая индекс первого вхождения переданного числа. В случае отсутствия вернет -1.
     * @param number число для поиска
     * @return индекс введенного числа в текущей коллекции контейнера
     */
    public int getIndexOf(int number) {
        int i = 0;
        while (i < cnt && numbers[i] != number)
            i++;
        if (numbers[i] == number)
            return i;
        return -1;
    }
    /**
     * Функция, удаляющая первое вхождение переданного числа.
     * В случае успешного удаления вернет true, иначе false.
     * @param number число для удаления
     * @return результат удаления
     */
    public boolean delete(int number) {
        int index = getIndexOf(number);
        if (index != -1) {
            for (int i = index; i < cnt - 1; i++)
                numbers[i] = numbers[i + 1];
            numbers[cnt - 1] = 0;
            cnt--;
            return true;
        }
        return false;
    }
    /**
     * Функция, удаляющая последнее числа в контейнере.
     * В случае успешного удаления вернет true, иначе false.
     * @return результат удаления
     */
    public boolean deleteLast() {
        if (cnt > 0) {
            numbers[cnt - 1] = 0;
            cnt--;
            return true;
        }
        return false;
    }
    /**
     * Функция, удаляющая число по его индексу.
     * В случае успешного удаления вернет true, иначе false.
     * @param index индекс
     * @return результат удаления
     */
    public boolean deleteByIndex(int index) {
        if (index < cnt && index >= 0) {
            for (int i = index; i < cnt; i++)
                numbers[i] = numbers[i + 1];
            numbers[cnt - 1] = 0;
            cnt--;
            return true;
        }
        return false;
    }
    /**
     * Функция, удаляющая все вхождения переданного числа.
     * @param number число
     */
    public void deleteDuplicates(int number) {
        int index;
        do {
            index = getIndexOf(number);
            if (index != -1) {
                for (int i = index; i < cnt - 1; i++)
                    numbers[i] = numbers[i + 1];
                numbers[cnt - 1] = 0;
                cnt--;
            }
        } while (index != -1);
    }
    /**
     * Функция, удаляющая какое-то количество чисел, идущих друг за другом, начиная с элемента под переданным индексом.
     * Возвращает true, если выполнены обы условия: индекс внутри массива и после этого индекса есть нужное количество чисел.
     * В противном случае возвращает false. При этом, если индекс внутри массива, удалятся элементы после него, даже если их
     * недостаточно (меньше N).
     * @param index индекс первого элемента для удаления
     * @param N количество удаляемых элементов
     * @return результат удаления
     */
    public boolean deleteN(int index, int N) {
        if (index >= 0 && index < cnt) {
            if (index + N >= cnt) {
                for (int i = index; i < cnt; i++)
                    numbers[i] = 0;
                cnt = index;
                return false;
            }
            else {
                for (int i = index; i < index + N; i++)
                    if (i + N > cnt)
                        numbers[i] = 0;
                    else
                        numbers[i] = numbers[i + N];
                cnt -= N;
                return true;
            }
        }
        return false;
    }
    /**
     * Функция, возвращающая последнее число в контейнере.
     * @return число
     */
    public Integer getLast() {
        if (cnt > 0) return numbers[cnt - 1];
        return null;
    }
    /**
     * Функция, полностью очищающая контейнер.
     */
    public void clear() {
        n = 10;
        for (int i = 0; i < cnt; i++)
            numbers[i] = 0;
        numbers = new int[n];
        cnt = 0;
    }
    /**
     * Функция, проверки пустоты контейнера.
     * Возвращает true, если в контейнере есть числа, и false - если нет.
     * @return true или false
     */
    public boolean isEmpty() {
        return cnt == 0;
    }
    /**
     * Функция проверки наличия числа в контейнере.
     * Возвращает true, если переданное число есть в контейнере, и false - если нет.
     * @param number число для проверки
     * @return true или false
     */
    public boolean has(int number) {
        return getIndexOf(number) != -1;
    }
    /**
     * Функция, возвращающая количество элементов в контейнере.
     * @return количество
     */
    public int size() {
        return cnt;
    }
    /**
     * Функция, возвращающая коллекцию элементов контейнера (без незаполненных нулей)
     * @return массив, состоящий из части массива numbers длиной cnt
     */
    public int[] getAll() {
        int[] result = new int[cnt];
        System.arraycopy(numbers, 0, result, 0, cnt);
        return result;
    }
    // Понадобился бы для вывода коллекции
    @Override
    public MyIterator createIterator() {
        return new ContainerIterator(numbers, cnt);
    }
}
