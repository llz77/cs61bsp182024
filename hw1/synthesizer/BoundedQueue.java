package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {

    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();

    // is the buffer empty (fillCount equals zero)?
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    // is the buffer full (fillCount is same as capacity)?
    default boolean isFull() {
        return fillCount() == capacity();
    }

}
