public class LinkedListDeque<T> implements Deque<T>{

    private class DNode {
        public T item;
        public DNode prev;
        public DNode next;

        public DNode (T Ditem, DNode Dprev, DNode Dnext) {
            item = Ditem;
            prev = Dprev;
            next = Dnext;
        }
    }

    private int size;
    private DNode node;

    public LinkedListDeque() {
        DNode node = new DNode(null, null, null);
        node.next = node;
        node.prev = node;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        DNode node = new DNode(null, null, null);
        node.next = node;
        node.prev = node;
        size = 0;

        // linked list type of depp copy
        for (DNode i = other.node.next; i != null; i = i.next) {
            addFirst(i.item);
        }

/*        // use method to deep copy
        for (int i = 0; i < other.size(); i++) {
            addFirst((T) other.get(i));
        }*/

    }

    @Override
    public void addLast(T x) {
        node.prev = new DNode(x, node.prev, node);
        node.prev.prev.next = node.prev;
        size += 1;
    }

    @Override
    public void addFirst(T x) {
        node.next = new DNode(x, node, node.next);
        node.next.next.prev = node.next;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

/*    // have default method
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }*/

    @Override
    public T get(int index) {
        if (index > size) return null;
        DNode ptr = node;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T toRemove = node.next.item;
        node.next = node.next.next;
        node.next.prev = node;
        size -= 1;
        return toRemove;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        T toRemove = node.next.item;
        node.prev = node.prev.prev;
        node.prev.next = node;
        size -= 1;
        return toRemove;
    }

    @Override
    public void printDeque() {
        DNode ptr = node.next;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

}