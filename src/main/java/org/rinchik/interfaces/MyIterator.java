package org.rinchik.interfaces;

/**
 * Интерфейс итератора.
 * Содержит необходимые операции для итератора.
 */
public interface MyIterator {
    /**
     * Функция проверки наличия следующего элемента коллекции
     * @return true, если элемент есть и конец коллекции не достигнут, false - конец коллекции
     */
    boolean hasNext();
    /**
     * Функция, возвращающая следующий элемент коллекции
     * @return элемент коллекции
     */
    Object next();
    /**
     * Функция, сбрасывающая итератор для повторного использования
     */
    void clear();
}
