package lesson1.builder;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();

        person
                .addFirstName("Roman")
                .addLastName("Kurganov")
                .addMiddleName("Vasilevich")
                .addAddress("Podeda St.")
                .addAge(39)
                .addCountry("Russia")
                .addGender("M")
                .addPhone("+79221111111");

        System.out.println(person);
    }

}
