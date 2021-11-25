package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info log = new Info(0, 0, 0);
        int changeIncrement = 0;
        int addIncrement = 0;
        int unmodifyIncrement = 0;
        Map<Integer, String> rsl = Stream.of(previous)
                .flatMap(Set::stream)
                .collect(Collectors.toMap(
                        User::getId,
                        User::getName));

            for (User user : current) {
                if (!rsl.containsKey(user.getId())) {
                    addIncrement++;
                    continue;
                }
                if (!rsl.get(user.getId()).equals(user.getName())) {
                    changeIncrement++;
                    continue;
                }
                unmodifyIncrement++;
            }
            log.setAdded(addIncrement);
            log.setChanged(changeIncrement);
            log.setDeleted((current.size() + previous.size())
                    - addIncrement - unmodifyIncrement
                    * 2 - changeIncrement * 2);
        return log;
    }
}