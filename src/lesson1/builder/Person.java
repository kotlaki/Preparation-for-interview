package lesson1.builder;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person addFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person addLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person addMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Person addCountry(String country) {
        this.country = country;
        return this;
    }

    public Person addAddress(String address) {
        this.address = address;
        return this;
    }

    public Person addPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Person addAge(int age) {
        this.age = age;
        return this;
    }

    public Person addGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}