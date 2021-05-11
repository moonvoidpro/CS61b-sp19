public class LinkedListDeque<T> implements Deque<T> {
    // node of deque linkedlist // not cycle
    private class dequeNode {
        public T itemT;
        public dequeNode frontNode;
        public dequeNode nextNode;

        public dequeNode(T item, dequeNode front,  dequeNode next) {
            itemT = item;
            frontNode = front;
            nextNode = next;
        }
    }

    private dequeNode node;
    private int size;
    //Creates an empty linked list deque.
    public LinkedListDeque(){
        node = new dequeNode(null, null, null);
        node.frontNode = node;
        node.nextNode = node;
        size = 0;
    }
    public void addFirst(T item){
        dequeNode newNode = new dequeNode(item, node, node.nextNode);
        node.nextNode.frontNode = newNode;
        node.nextNode = newNode;
        size += 1;
    }
    public void addLast(T item){
        node.frontNode = new dequeNode(item, node.frontNode, node);
        node.frontNode.frontNode.nextNode = node.frontNode;
        size += 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
    public void printDeque(){
        dequeNode print = node.nextNode;
        for (int i = 0; i < size; i++) {
            System.out.print(print.itemT+" ");
            print = print.nextNode;
        }
        System.out.println();
    }
    public T removeFirst(){
        T removeF = node.nextNode.itemT;
        node.nextNode = node.nextNode.nextNode;
        node.nextNode.frontNode = node;
        size -= 1;
        return removeF;
    }
    public T removeLast(){
        T removeL = node.frontNode.itemT;
        node.frontNode = node.frontNode.frontNode;
        node.frontNode.nextNode = node;
        size -= 1;
        return removeL;
    }
    public T get(int index){
        if (index > size) return null;
        dequeNode get = node;
        for (int i = 0; i < index; i++) {
            get = get.nextNode;
        }
        return get.itemT;

    }
    //Creates a deep copy of `other`
    public LinkedListDeque(LinkedListDeque other){
        node = new dequeNode(null, null, null);
        node.nextNode = node;
        node.frontNode = node;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addFirst((T) other.get(i));
        }

    }
    private T getRecursive(dequeNode D, int index){
        if (index == 0) return D.itemT;
        return getRecursive(D.nextNode, index-1);
    }

    public T getRecursive(int index){
        if (index > size) return null;
        return getRecursive(node, index);
    }
}
