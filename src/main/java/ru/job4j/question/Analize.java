package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info log = new Info(0, 0, 0);
        int c = 0;
        int a = 0;
        int u = 0;
        Map<Integer, String> rsl = Stream.of(previous)
                .flatMap(Set::stream)
                .collect(Collectors.toMap(
                        User::getId,
                        User::getName));

            for (User user : current) {
                // User add
                if (!rsl.containsKey(user.getId())) {
                    a++;
                    continue;
                }
                // User change
                if (!rsl.get(user.getId()).equals(user.getName())) {
                    c++;
                    continue;
                }
                // User unmodify
                u++;
            }
            log.setAdded(a);
            log.setChanged(c);
            log.setDeleted((current.size() + previous.size()) - a - u * 2 - c * 2);
        return log;
    }
}