package com.max.CM_LMS.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Teacher extends User {

    private String role;
    Set<Group> groups;

    public Teacher(String firstName, String lastName, LocalDate dateofBirth, String role) {
        super(firstName, lastName, dateofBirth);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addGroup(Group group) {
        if (this.groups == null) {
            this.groups = new HashSet<>();
        }
        groups.add(group);
    }

    public Set<Group> getGroups() {
        return this.groups;
    }
   private String getAllGroupsName(){
         Set<Group> buffer = this.groups;
         String res = "";
         for (Group s : buffer){
             res += s.getName();
         }
        return res;
     }
    @Override
    public String toString() {
        return "Teacher{" +
                "role='" + role + '\'' +
                ", groups=" + getAllGroupsName() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateofBirth=" + dateofBirth +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return role.equals(teacher.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }
}
