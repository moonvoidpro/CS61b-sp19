public class ArrayDeque<T> {
    private int size;
    private T[] deque;
    private int nextFirst;
    private int nextLast;

    // The starting size of your array should be 8.
    public ArrayDeque() {
        deque = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }
    // check if upsize needed
    private boolean isFull() {
        return size == deque.length;
    }
    // check if downsize needed
    private boolean isSparse() {
        return size >= 16 && size < (deque.length / 4);
    }

    private int plusOne(int index) {
        return (index + 1) % deque.length;
    }

    private int minusOne(int index) {
        return (index - 1 + deque.length) % deque.length;
    }

    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            nextFirst = plusOne(nextFirst);
            newDeque[i] = deque[nextFirst];
        }
        nextFirst = capacity - 1;
        nextLast = size;
        deque = newDeque;
    }

    private void downSize() {
        resize(deque.length / 2);
    }

    private void upSize() {
        resize(deque.length * 2);
    }

    public ArrayDeque(ArrayDeque other) {
        deque = (T[]) new Object[other.deque.length]; // I want to copy the full length of deque
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size();

        System.arraycopy(other.deque, 0, deque, 0, other.deque.length);

    }

    public int size() {
        return size;
    }
    /* Gets the item at the given index,
    where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (index >= size)
            return null;
        return deque[minusOne(index + nextFirst)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T x) {
        if (isFull()) {
            upSize();
        }
        deque[nextFirst] = x;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T x) {
        if (isFull()) {
            upSize();
        }
        deque[nextLast] = x;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        nextFirst = plusOne(nextFirst);
        T toRemove = deque[nextFirst];
        size -= 1;
        if (isSparse()) {
            downSize();
        }
        return toRemove;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        nextLast = minusOne(nextLast);
        T toRemove = deque[nextLast];
        size -= 1;
        if (isSparse()) {
            downSize();
        }
        return toRemove;
    }
    // Prints the items in the deque from first to last
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; plusOne(i)) {
            System.out.print(deque[i] + " ");
        }
        System.out.println();
    }
}
