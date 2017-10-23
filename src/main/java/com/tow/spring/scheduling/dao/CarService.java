package com.tow.spring.schedling.dao;

import com.tow.spring.schedling.models.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
}
