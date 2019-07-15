package datastructure;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyBinarySearchTreeTest {

    private MyBinarySearchTree<String, String> sut = new MyBinarySearchTree<>();

    @Test
    public void name() {
        sut.put("foo", "foo-value");
        sut.put("bar", "bar-value");
        sut.put("baz", "baz-value");

        assertEquals("foo-value", sut.get("foo"));
        assertEquals("bar-value", sut.get("bar"));
        assertEquals("baz-value", sut.get("baz"));
        assertNull(sut.get("nothing"));
    }

    @Test
    public void name2() {
        sut.put("foo", "old");
        sut.put("foo", "new");

        assertEquals("new", sut.get("foo"));
    }

    @Test
    public void name3() {
        sut.put("9", "whatever");
        sut.put("2", "whatever");
        sut.put("1", "whatever");
        sut.put("0", "whatever");
        sut.put("3", "whatever");
        sut.put("4", "whatever");
        sut.put("7", "whatever");
        sut.put("8", "whatever");
        sut.put("5", "whatever");
        sut.put("6", "whatever");

        Iterator<MyBinarySearchTree.Entry<String, String>> iterator = sut.iterator();

        assertEquals("0", iterator.next().key);
        assertEquals("1", iterator.next().key);
        assertEquals("2", iterator.next().key);
        assertEquals("3", iterator.next().key);
        assertEquals("4", iterator.next().key);
        assertEquals("5", iterator.next().key);
        assertEquals("6", iterator.next().key);
        assertEquals("7", iterator.next().key);
        assertEquals("8", iterator.next().key);
        assertEquals("9", iterator.next().key);

    }

    /*
    5
  2   7
 1 3 6 8
depth   first: 5213768
breadth first: 5271368
     */
    @Test
    public void name4() {
        sut.put("5", "whatever");
        sut.put("2", "whatever");
        sut.put("7", "whatever");
        sut.put("1", "whatever");
        sut.put("3", "whatever");
        sut.put("6", "whatever");
        sut.put("8", "whatever");

        Iterator<MyBinarySearchTree.Entry<String, String>> iterator = sut.depthFirstIterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        assertEquals("5", iterator.next().key);
        assertEquals("2", iterator.next().key);
        assertEquals("1", iterator.next().key);
        assertEquals("3", iterator.next().key);
        assertEquals("7", iterator.next().key);
        assertEquals("6", iterator.next().key);
        assertEquals("8", iterator.next().key);
    }
}