package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User("Alex", 2, new GregorianCalendar());
        User user2 = new User("Alex", 2, new GregorianCalendar());

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(map);
        System.out.println(map.get(user1));
    }
}
