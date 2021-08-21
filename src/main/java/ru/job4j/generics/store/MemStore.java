package ru.job4j.generics.store;


import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
    mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (mem.containsKey(id)) {
            mem.put(id, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(id, findById(id));
    }

    @Override
    public T findById(String id) {
        T model;
        if (mem.containsKey(id)) {
            model = mem.get(id);
            return model;
        }
        return null;
    }
}