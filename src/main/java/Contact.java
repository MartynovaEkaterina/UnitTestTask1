public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private int age;
    private String sex;

    public Contact(String name, String surname, String phoneNumber, int age, String sex) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", " + "Фамилия: " + surname + ", " + "Телефон: " + phoneNumber + "Возраст: " + age + "Пол: " + sex;
    }
}
