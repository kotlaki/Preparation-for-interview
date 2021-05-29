package lesson2.myarraylist;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList test = new MyArrayList();
        System.out.println("size = " + test.getSize());
        System.out.println("length = " + test.getMyArrayList().length);
        test.add("first");
        test.add("more");
        test.add("hello");
        test.add("Queue");
        test.add("lorn");
        test.add("depth");
        test.add("death");
        test.add("cat");
        test.add("dog");
        test.add("RU");
        test.add("bird");
        test.add("666");
        System.out.println("size = " + test.getSize());
        System.out.println("length = " + test.getMyArrayList().length);
        System.out.println(Arrays.asList(test.getMyArrayList()));
        test.delete(4);
        System.out.println(Arrays.asList(test.getMyArrayList()));
        test.delete(0);
        System.out.println(Arrays.asList(test.getMyArrayList()));
        test.delete(9);
        System.out.println(Arrays.asList(test.getMyArrayList()));
        test.delete(0);
        System.out.println(Arrays.asList(test.getMyArrayList()));
        test.delete(1);
        System.out.println(Arrays.asList(test.getMyArrayList()));
        System.out.println("size = " + test.getSize());
        System.out.println("length = " + test.getMyArrayList().length);
        test.add("first");
        test.add("more");
        test.add("hello");
        test.add("Queue");
        test.add("lorn");
        test.add("depth");
        test.add("death");
        test.add("cat");
        test.add("dog");
        test.add("RU");
        test.add("bird");
        test.add("666");
        System.out.println(Arrays.asList(test.getMyArrayList()));
    }
}
