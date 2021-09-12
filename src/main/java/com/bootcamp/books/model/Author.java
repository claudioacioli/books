package com.bootcamp.books.model;

import java.time.LocalDate;

public class Author {
    private String name;
    private String email;
    private String resume;
    private LocalDate birthday;

    public Author(String name, String email, String resume, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.resume = resume;
        this.birthday = birthday;
    }

    public Author () {}

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", resume='" + resume + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getResume () {
        return resume;
    }

    public void setResume (String resume) {
        this.resume = resume;
    }

    public LocalDate getBirthday () {
        return birthday;
    }

    public void setBirthday (LocalDate birthday) {
        this.birthday = birthday;
    }
}
