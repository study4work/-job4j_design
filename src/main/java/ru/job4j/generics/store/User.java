package ru.job4j.generics.store;

public class User extends Base {
    // класс User наследуется от Base,т.к. у Base есть поле String id,
    // модель User иницилизируется полем id класса Base
    public User(String id) {
        super(id);
    }
}
