package com.tow.spring.schedling.dao;

import com.google.common.collect.Lists;
import com.tow.spring.schedling.models.Car;
import com.tow.spring.schedling.models.CarRepository;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void updateCarAgeJob() {
        List<Car> cars = findAll();

        DateTime currentDate = DateTime.now();
        LOGGER.info("Car age update job started");

        for (Car car : cars) {
            int age = Years.yearsBetween(
                    car.getManufactureDate(),
                    currentDate
            ).getYears();
            car.setAge(age);
            save(car);
            LOGGER.info("Car age update--- " + car);
        }
        LOGGER.info("Car age update job completed successfully");
    }
}
