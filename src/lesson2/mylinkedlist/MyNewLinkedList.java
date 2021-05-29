package lesson2.mylinkedlist;

import java.util.Arrays;

public class MyNewLinkedList {
    private transient int size = 0;
    private transient Node<Object> first;
    private transient Node<Object> last;

    private int INITIAL_CAPACITY = 10;
    private Node<Object> node;

    private Node[] myLinkedList = new Node[INITIAL_CAPACITY];

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<Object> getFirst() {
        return first;
    }

    public void setFirst(Node<Object> first) {
        this.first = first;
    }

    public Node<Object> getLast() {
        return last;
    }

    public void setLast(Node<Object> last) {
        this.last = last;
    }

    public int getINITIAL_CAPACITY() {
        return INITIAL_CAPACITY;
    }

    public void setINITIAL_CAPACITY(int INITIAL_CAPACITY) {
        this.INITIAL_CAPACITY = INITIAL_CAPACITY;
    }

    public Node<Object> getNode() {
        return node;
    }

    public void setNode(Node<Object> node) {
        this.node = node;
    }

    public Node[] getMyLinkedList() {
        return myLinkedList;
    }

    public void setMyLinkedList(Node[] myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    public void add(Object obj) {
        if (isFirstElement()) {
            addFirst(obj);
        } else {
            addLast(obj);
        }
    }

    public void add(int index, Object obj) throws Exception {
        if (index == 0) {
            addFirst(obj);
        } else {
            addObjectToIndex(index, obj);
        }
    }

    private void addFirst(Object obj) {
        node = new Node<>(null, obj, null);
        myLinkedList[size] = node;
        size++;
        first = node;
        last = node;
    }

    private void addLast(Object obj) {
        if (myLinkedList.length == size) {
            myLinkedList = Arrays.copyOf(myLinkedList, size * 2, Node[].class);

        }
        node = new Node<>(myLinkedList[size - 1], obj, null);
        myLinkedList[size] = node;
        myLinkedList[size - 1].next = node;
        size++;
        last = node;

    }

    public void addObjectToIndex(int index, Object obj) throws Exception {
        // проверяем не выходит ли индекс за пределы диапазонов
        if (index < 0 || index > size) {
            throw new Exception("IndexOutOfBoundsException!!!");
        }
        // если индекс равен последнему элементу используем стандартную вставку в конец
        if (index == size){
            addLast(obj);
        } else {
           moveRight(index, obj);
        }
    }

    public void delete(int index) throws Exception {
        if (index >= 0 || index <= size) {
            if (index == size) {
                deleteLastElement(index);
            }
            if (index == 0) {
                deleteFirstElement();
            }
            if (index > 0 && index != size) {
                deleteElementToIndex(index);
            }
        } else {
            throw new Exception("IndexOutOfBoundsException!!!");
        }
    }

    private void deleteElementToIndex(int index) {
        size--;
        for (int i = index; i <= size ; i++) {
            myLinkedList[i] = myLinkedList[i + 1];
            if(myLinkedList[i] != null) {
                myLinkedList[i].prev = myLinkedList[i - 1];
            }
            if (i == index) {
                myLinkedList[i - 1].next = myLinkedList[i];
            }
            replaceLastElementNext(i);
        }
    }

    private void deleteLastElement(int index) {
        myLinkedList[index] = null;
        myLinkedList[index - 1].next = null;
        size--;
    }

    private void deleteFirstElement() {
        size--;
        for (int i = 0; i <= size; i++) {
            if (i == 0) {
                myLinkedList[i + 1].prev = null;
            }
            myLinkedList[i] = myLinkedList[i + 1];
            replaceLastElementNext(i);
        }
    }

    private void moveRight(int index, Object obj) {
        // смещаем элементы от индекса в конец массива
        for (int i = size - 1; i >= index; i--) {
            myLinkedList[i +1] = myLinkedList[i];
        }
        if(index == 0) {
            myLinkedList[index] = new Node(null, obj, myLinkedList[index + 1]);
        } else {
            // присваеваем заданному индексу новый node
            myLinkedList[index] = new Node(myLinkedList[index - 1], obj, myLinkedList[index + 1]);
            // меняем ссылку на следующий элемент node
            myLinkedList[index - 1].next = myLinkedList[index];
        }
        // меняем ссылку на предыдущий элемент node
        myLinkedList[index + 1].prev = myLinkedList[index];
    }

    public Node get(int index) throws Exception {
        if (index > size || myLinkedList[index] == null) throw new Exception("IndexOutOfBoundsException!!!");
        return myLinkedList[index];
    }

    private Node getPreviousElementToIndex(int index) {
        return myLinkedList[index];
    }

    private Node getFirstElement() {
        return myLinkedList[0];
    }

    private Node getLastElement() {
        return myLinkedList[size];
    }

    private boolean isLastElementToIndex(int index) {
        return index == size;
    }

    private boolean isFirstElementToIndex(int index) {
        return index == 0;
    }

    private boolean isFirstElement() {
        return size == 0;
    }

    private boolean isLastElement() {
        return size == myLinkedList.length;
    }

    private void replaceLastElementNext(int replaceIndex) {
        if (myLinkedList[replaceIndex] != null) {
            if (myLinkedList[replaceIndex].next == null) {
                myLinkedList[replaceIndex + 1] = null;
            }
        }
    }

}
