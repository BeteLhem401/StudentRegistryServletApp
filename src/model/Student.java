package model;

public class Student {

    private int id;
    private String name;
    private String email;
    private int year;

    public Student(int id, String name, String email, int year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }
}

