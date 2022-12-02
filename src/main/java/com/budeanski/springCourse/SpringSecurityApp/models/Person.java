package com.budeanski.springCourse.SpringSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "Имя не должно быть пустым!")
    @Size(min = 5, max = 25, message = "имя пользователя не может иметь меньше 5 символов и больше 25!")
    private String username;

    @Column(name = "year_of_birth")
    @NotNull(message = "Год обязателен для ввода!")
    @Min(value = 1900, message = "Ошибка ввода года рождения, год не может быть меньше 1900!")
    @Max(value = 2004, message = "Вам должно быть больше 18 лет!")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    @Column(name = "name_surname")
    private String nameSurname;

    public Person(){

    }

    public Person(String username, int yearOfBirth, String password) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    @Override
    public String toString() {
        return "Person: " +
                "id = " + id +
                ", username = '" + username + '\'' +
                ", yearOfBirth = " + yearOfBirth +
                ", password = '" + password;
    }

}
