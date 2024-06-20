public class LinkedListDeque<T> implements Deque<T> {
    //    节点构造，由3部分组成，3部分的定义以及构造器
    private class TNode {
        private T item;
        private TNode prev;
        private TNode next;

        private TNode(T i, TNode p, TNode n ) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }

    }

    private TNode sentinel;
    private int size;
    //    链表构造器
    public LinkedListDeque() {
        sentinel = new TNode((T) new Object(), null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void addFirst(T front) {
        TNode newNode = new TNode(front, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }
    @Override
    public void addLast(T last) {
        TNode newNode = new TNode(last, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }
    @Override
    public void printDeque() {
        for (TNode i = sentinel.next; i != sentinel; i = i.next) {
            if (i.next == sentinel) {
                System.out.println(i.item);
            }
            System.out.println(i.item + " ");
        }
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return res;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return res;
    }
    @Override
    public T get(int index) {
        if (size < index) {
            return null;
        }
        TNode iNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            iNode = iNode.next;
        }
        return iNode.item;
    }

    public T getRecursive(int index) {
        if (size < index) {
            return null;
        }
        return getRecursivehelper(index, sentinel.next);
    }

    private T getRecursivehelper(int index, TNode T) {
        if (index == 0) {
            return T.item;
        }
        return getRecursivehelper(index - 1, T.next);
    }
}
