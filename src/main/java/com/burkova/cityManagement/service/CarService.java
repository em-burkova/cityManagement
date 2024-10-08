package com.burkova.cityManagement.service;

import com.burkova.cityManagement.model.Car;
import com.burkova.cityManagement.model.Person;

import java.util.List;

public interface CarService {

    Car createCar(Car car);
    Car getCar(Long id);
    Car updateCar(Car car);
    void deleteCar(Long id);
    List<Car> getAllCars();
    List<Car> getAllCarsByPerson(Long id);
}
