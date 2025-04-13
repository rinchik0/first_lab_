package org.rinchik.interfaces;

import org.rinchik.interfaces.MyIterator;

/**
 * Интерфейс итеративной коллекции.
 * Содержит возможность создания итератора для коллекции.
 */
public interface IterativeCollection {
    /**
     * Функция, создающая и возвращающая итератор для коллекции.
     * @return итератор
     */
    MyIterator createIterator();
}
