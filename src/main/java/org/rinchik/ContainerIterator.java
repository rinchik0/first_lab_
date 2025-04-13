package org.rinchik;

import org.rinchik.interfaces.MyIterator;

/**
 * Класс, имплементирующий свойства интерфейса MeIterator конкретно для коллекции Container.
 * Позволяет использовать итератор для передвижения по коллекции.
 */
public class ContainerIterator implements MyIterator {
    private int[] elements;
    private int n;
    private int position = 0;

    /**
     * Конструктор. Привязывает итератор к конкретному массиву элементов.
     * @param elements массив
     * @param n количество элементов массива
     */
    public ContainerIterator(int[] elements, int n) {
        this.elements = elements;
        this.n = n;
    }
    @Override
    public boolean hasNext() {
        return position < n;
    }
    @Override
    public Object next() {
        if (this.hasNext())
            return elements[position++];
        return null;
    }
    @Override
    public void clear() {
        position = 0;
    }
}
