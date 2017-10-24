package com.tow.spring.scheduling.dao;

import com.tow.spring.scheduling.models.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
}
