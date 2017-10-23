package com.tow.spring.schedling.models;

import org.joda.time.DateTime;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "car")
public class Car {
    private Long id;
    private String licensePlate;
    private String manufacturer;
    private DateTime manufactureDate;
    private int age;
    private int version;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", age=" + age +
                ", version=" + version +
                '}';
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "license_plate")
    public String getLicensePlate() {
        return licensePlate;
    }

    public Car setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public Car setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Column(name = "manufacture_date")
    public DateTime getManufactureDate() {
        return manufactureDate;
    }

    public Car setManufactureDate(DateTime manufactureDate) {
        this.manufactureDate = manufactureDate;
        return this;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public Car setAge(int age) {
        this.age = age;
        return this;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public Car setVersion(int version) {
        this.version = version;
        return this;
    }
}
