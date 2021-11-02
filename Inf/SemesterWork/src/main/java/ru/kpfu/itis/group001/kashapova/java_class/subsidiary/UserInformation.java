package ru.kpfu.itis.group001.kashapova.java_class.subsidiary;

public class UserInformation {
    protected int id = -1;
    protected String name;
    protected String surname;
    protected String email;
    protected String email_confirmed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_confirmed() {
        return email_confirmed;
    }

    public void setEmail_confirmed(String email_confirmed) {
        this.email_confirmed = email_confirmed;
    }
}
