package datastructure;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;

public class MyLinkedListTest {

    @Test
    public void addWorks() {
        final MyLinkedList<Integer> sut = sut();

        sut.add(1);
    }

    @Test
    public void iteratorWorks() {
        final MyLinkedList<Integer> sut = sut();
        sut.add(1);
        sut.add(2);
        sut.add(3);

        final Iterator<Integer> actual = sut.iterator();

        Assert.assertThat(actual.hasNext(), is(true));
        Assert.assertThat(actual.next(), is(1));
        Assert.assertThat(actual.hasNext(), is(true));
        Assert.assertThat(actual.next(), is(2));
        Assert.assertThat(actual.hasNext(), is(true));
        Assert.assertThat(actual.next(), is(3));
        Assert.assertThat(actual.hasNext(), is(false));
    }

    private static <T> MyLinkedList<T> sut() {
        return new MyLinkedList<>();
    }
}
