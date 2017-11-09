package com.tow.spring.form.model;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String password;
    private String confirmPassword;
    private boolean newsletter;
    private List<String> framework;
    private String sex;
    private Integer number;
    private String country;
    private List<String> skill;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", confirmPassword='").append(confirmPassword).append('\'');
        sb.append(", newsletter=").append(newsletter);
        sb.append(", framework=").append(framework);
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", number=").append(number);
        sb.append(", country='").append(country).append('\'');
        sb.append(", skill=").append(skill);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public User setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
        return this;
    }

    public List<String> getFramework() {
        return framework;
    }

    public User setFramework(List<String> framework) {
        this.framework = framework;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public User setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<String> getSkill() {
        return skill;
    }

    public User setSkill(List<String> skill) {
        this.skill = skill;
        return this;
    }

    public boolean isNew() {
        return (this.id == null);

    }
}
