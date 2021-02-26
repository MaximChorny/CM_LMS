package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class User {

    protected String firstName;
    protected String lastName;
    protected LocalDate dateofBirth;

    public User(String firstName, String lastName, LocalDate dateofBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
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

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateofBirth=" + dateofBirth +
                ", role='" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                dateofBirth.equals(user.dateofBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateofBirth);
    }
}
