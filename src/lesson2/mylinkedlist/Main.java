package lesson2.mylinkedlist;

public class Main {
    public static void main(String[] args) throws Exception {
        MyNewLinkedList test = new MyNewLinkedList();
        test.add("First");
        test.add("Next");
        test.add("Go");
        System.out.println(test.get(0).item);
        System.out.println(test.get(1).item);
        System.out.println(test.get(2).item);
        test.delete(1);
        System.out.println(test.get(0).item);
        System.out.println(test.get(1).item);
        System.out.println(test.getSize());
    }
}
