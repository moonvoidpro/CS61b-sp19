public class ArrayDeque<T> {
    private int size;
    private T[] deque;
    private int nextFirst;
    private int nextLast;

    //The starting size of your array should be 8.
    public ArrayDeque(){
        deque = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }

    private boolean isFull(){
        return size == deque.length;
    }

    private boolean isSparse(){
        return size > 16 && size < (deque.length/4);
    }

    public ArrayDeque(ArrayDeque other){

    }

    public int size() {
        return size;
    }

    public T get (int index) {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst() {

    }

    public void addLast() {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public ArrayDeque(ArrayDeque other){

    }

}
