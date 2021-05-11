public class ArrayDeque<T> {
    private int size;
    private T[] deque;
    private int nextFirst;
    private int nextLast;
    private int lengthA;

    //The starting size of your array should be 8.
    public ArrayDeque(){
        deque = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        lengthA = 8;
    }

    public ArrayDeque(ArrayDeque other){
        deque = (T[]) new Object[other.lengthA];


    }

    public int size() {
        return size;
    }

    public T get (int index) {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {

    }

    public void addLast(T item) {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public ArrayDeque(ArrayDeque other){

    }

}
