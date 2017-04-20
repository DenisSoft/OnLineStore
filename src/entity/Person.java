package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dzianis on 28.03.2017.
 */
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String password1;
    private String address;
    private String phone;
    private Groups groups;
    private Map errors;

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.password1 = "";
        this.address = "";
        this.phone = "";
        this.groups = groups.USER;
        this.errors = new HashMap();
    }

    public Person(String firstName, String lastName, String email, String password,
                  String address, String phone, Groups groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.groups = groups.USER;
    }

    public Person(long id, String firstName, String lastName, String email,
                  String password, String address, String phone, Groups groups) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.groups = groups;
    }

    public boolean validate() {
        boolean allOk = true;
        if (firstName.equals("")) {
            errors.put("firstName", "Пожалуйста, введите свое имя!");
            firstName = "";
            allOk = false;
        }
        if (lastName.equals("")) {
            errors.put("lastName", "Пожалуйста, введите свою фамилию!");
            lastName = "";
            allOk = false;
        }
        if (email.equals("") || !email.matches("[a-zA-Z]\\w*@[a-zA-Z]+\\.[a-zA-Z]+")) {
            errors.put("email", "Пожалуйста, введите свой E-Mail!");
            email = "";
            allOk = false;
        }
        if (password.equals("")) {
            errors.put("password", "Пожалуйста, введите пароль!");
            password = "";
            allOk = false;
        }
        if (!password.equals("") && (password1.equals("") ||
                !password.equals(password1))) {
            errors.put("password1", "Пожалуйста, подтвердите пароль!");
            password1 = "";
            allOk = false;
        }
        if (address.equals("")) {
            errors.put("address", "Пожалуйста, введите свой адрес!");
            address = "";
            allOk = false;
        }
        if (phone.equals("") || !phone.matches("(\\+375)(\\d{2})(\\d{3})(\\d{2})(\\d{2})")) {
            errors.put("phone", "Введите телефон в формате +375290000000");
            phone = "";
            allOk = false;
        }
        return allOk;
    }

    public String getErrorMsg(String s) {
        String errorMsg = (String) errors.get(s.trim());
        return (errorMsg == null) ? "" : errorMsg;
    }


    public long getId() {
        return id;
    }

    public Map getErrors() {
        return errors;
    }

    public void setErrors(Map errors) {
        this.errors = errors;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", groups=" + groups +
                '}';
    }
}
