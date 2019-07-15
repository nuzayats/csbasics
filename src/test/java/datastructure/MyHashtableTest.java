package datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashtableTest {

    MyHashtable<String, String> sut = new MyHashtable<>(200);

    @Test
    public void name() {
        sut.put("foo", "bar");

        assertEquals("bar", sut.get("foo"));
    }

    @Test
    public void update() {
        sut.put("foo", "bar");
        sut.put("foo", "baz");

        assertEquals("baz", sut.get("foo"));
    }

    @Test
    public void many() {
        for (int i = 0; i < 10000; i++) {
            sut.put(String.valueOf(i), i + "-value");
        }

        assert sut.get("3").equals("3-value");
        assert sut.get("8344").equals("8344-value");
    }
}
