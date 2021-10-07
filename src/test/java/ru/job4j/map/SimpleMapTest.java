package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class SimpleMapTest  {
    SimpleMap<Object, Object> map = new SimpleMap();

    @Test
    public void putTwoBacket() {
        map.put("key", 2);
        map.put(3, "two");
        int size = map.size();
        Assert.assertEquals(2, size);
    }

    @Test
    public void putBacket() {
        map.put("key", 2);
        Object value = map.get("key");
        Assert.assertEquals(2, value);
    }

    @Test
    public void getThenOne() {
        map.put("Key", "Value");
        Object value = map.get("Key");
        Assert.assertEquals("Value", value);
    }

    @Test
    public void getThenSome() {
        map.put("Key", "Value");
        map.put("key", "value");
        Object value = map.get("Key");
        Assert.assertEquals("Value", value);
    }

    @Test
    public void removeOneBacket() {
        map.put("Key", "Value");
        map.put("k", "value");
        map.remove("k");
        int size = map.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void removeTwoBackets() {
        map.put("Key", "Value");
        map.put("k", "value");
        map.remove("k");
        map.remove("Key");
        int size = map.size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void iteratorHasNext() {
        map.put(2, 2);
        Iterator<Object> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorNext() {
        map.put("2", 33);
        Iterator<Object> iterator = map.iterator();
        Assert.assertEquals(iterator.next(), "2");
    }
}