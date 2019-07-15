package datastructure;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyQueueTest {

    MyQueue<String> sut = new MyQueue<>();

    @Test
    public void name() {
        sut.offer("foo");
        sut.offer("bar");
        sut.offer("baz");

        assertEquals("foo", sut.poll());
        assertEquals("bar", sut.poll());
        assertEquals("baz", sut.poll());
        assertNull(sut.poll());
    }

    @Test
    public void name2() {
        assertNull(sut.poll());
    }

    @Test
    public void name3() {
        sut.offer("foo");

        String actual = sut.poll();

        assertEquals("foo", actual);
        assertNull(sut.poll());
    }

    @Test
    public void name4() {
        sut.offer("foo");
        sut.offer("bar");
        sut.offer("baz");

        Iterator<String> iterator = sut.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("foo", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("bar", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("baz", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
