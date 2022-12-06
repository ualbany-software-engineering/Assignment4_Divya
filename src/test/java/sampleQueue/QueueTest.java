package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueTest {

    /**
     * Tests for Queue.
     */

    private static final String SOME_ITEM = "some-content";
    private Queue<String> q;

    @Test
    @Disabled
    @DisplayName("is instantiated with new Queue()")
    void isInstantiatedWithNew() {
        new Queue<>();
    }

    @BeforeEach
    void init() {
        this.q = new Queue<String>();
    }

    @Test
    @DisplayName("Verify Queue isEmpty when queue is initialized")
    void isEmptyShouldGiveTrueOnQueueInit() {
        assertTrue(q.isEmpty());
    }

    @Test
    @DisplayName("Peek should throw an Exception if called on empty queue")
    void peekThrowsExceptionOnEmpty() {
        assertThrows(NoSuchElementException.class, () -> this.q.peek());
    }

    //Example of Wrong Test!
    @Test
    @Disabled
    @DisplayName("Verify Queue isEmpty returns false when queue is not empty")
    void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
        this.q.enqueue(SOME_ITEM);
        assertFalse(q.isEmpty());
    }

    @Test
    @DisplayName("Dequeue throws an Exception if called on empty queue")
    void dequeueThrowsExceptionOnEmpty() {
        assertThrows(NoSuchElementException.class, () -> this.q.dequeue());
    }

    @Test
    @DisplayName("verify append method")
    void appendAllItemsOnQueue() {
        Queue<String> queue = new Queue<>(3);
        queue.enqueue("SomeValue");
        queue.enqueue("SomeContent");
        assertEquals("SomeValue SomeContent ", queue.toString());
    }

    @Test
    @DisplayName("Verifying whether all the items are removed from the queue or not")
    void removeAllItems() {
        Queue<String> queue = new Queue<>(1);
        queue.enqueue("SomeItem");
        queue.removeAll();
        assertEquals(0, queue.length());
    }

    @Test
    @DisplayName("Verifying dequeue operation")
    void dequeueItemsFromQueue() {
        Queue<String> queue = new Queue<>(2);
        queue.enqueue("SomeContent");
        assertEquals("SomeContent", queue.dequeue());
    }

}
