public interface Deque<T> {

     boolean isEmpty();
     int size();
     void addFirst(T front) ;
     void addLast(T last) ;
     void printDeque() ;
     T removeFirst();
     T removeLast();
     T get(int index);

}
