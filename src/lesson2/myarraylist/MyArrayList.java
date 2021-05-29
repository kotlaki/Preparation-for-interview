package lesson2.myarraylist;

import java.util.Arrays;

public class MyArrayList {
    private final int INITIAL_SIZE = 10;
    private int size = 0;
    private int index = 0;

    private Object[] myArrayList = new Object[INITIAL_SIZE];

    public void add(Object obj) {
        if(size == index && size != 0 && size == myArrayList.length - 1) {
            myArrayList = Arrays.copyOf(myArrayList, size * 2, Object[].class);
        }
        myArrayList[index] = obj;
        size++;
        index++;
    }

    public void get(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            System.out.println("[" + index + "] = " + myArrayList[index - 1]);
        }
    }

    public void delete(int index) {
        if (index > size && index >= 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (index == 0) {
                deleteFirstElement();
            }
            if (index == size) {
                deleteLastElement();
            }
            if (index != 0 && index != size) {
                deleteElementByIndex(index);
            }
        }
    }

    private void deleteElementByIndex(int removeIndex) {
        for (int i = removeIndex; i < size; i++) {
            if (!lastElement(i)) {
                myArrayList[i] = myArrayList[i + 1];
            } else {
                deleteLastElement();
            }
        }
        size--;
        index--;
    }

    private void deleteLastElement() {
        myArrayList[size] = null;
        size--;
        index--;
    }

    private void deleteFirstElement() {
        for (int i = 0; i < size; i++) {
            myArrayList[i] = myArrayList[i + 1];
            if (lastElement(i)) {
                myArrayList[i] = null;
            }
        }
        size--;
        index--;
    }

    private boolean lastElement(int i) {
       return i == size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object[] getMyArrayList() {
        return myArrayList;
    }

    public void setMyArrayList(Object[] myArrayList) {
        this.myArrayList = myArrayList;
    }
}
