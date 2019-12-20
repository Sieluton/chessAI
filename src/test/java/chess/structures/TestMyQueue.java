package chess.structures;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMyQueue {

    @Test
    public void testEmpty() {
        MyQueue queue = new MyQueue();
        assertTrue(queue.isEmpty());
        queue.add(1);
        queue.pop();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetObject() {
        MyQueue queue = new MyQueue();
        queue.add(3);
        queue.add(5);
        queue.add(7);
        assertTrue((int) queue.pop() == 3);
        assertTrue((int) queue.pop() == 5);
        assertTrue((int) queue.pop() == 7);
    }

    @Test
    public void testClone() {
        MyQueue queue = new MyQueue();
        queue.add(3);
        queue.add(5);
        queue.add(7);
        MyQueue copyqueue = queue.clone();
        assertTrue((int) queue.pop() == 3);
        assertTrue((int) queue.pop() == 5);
        assertTrue((int) queue.pop() == 7);
        assertTrue((int) copyqueue.pop() == 3);
        assertTrue((int) copyqueue.pop() == 5);
        assertTrue((int) copyqueue.pop() == 7);
    }
}
