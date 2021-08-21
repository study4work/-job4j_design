package ru.job4j.generics.store;

public class RoleStore implements Store<Role> {
    Store<Role> roleStore = new MemStore<>();

    @Override
    public void add(Role model) {
        roleStore.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        roleStore.replace(id, model);
        return false;
    }

    @Override
    public boolean delete(String id) {
        roleStore.delete(id);
        return false;
    }

    @Override
    public Role findById(String id) {
        roleStore.findById(id);
        return null;
    }
}