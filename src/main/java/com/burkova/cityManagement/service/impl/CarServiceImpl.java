package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.model.Person;
import com.burkova.cityManagement.service.CarService;
import com.burkova.cityManagement.model.Car;
import com.burkova.cityManagement.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
       this.carRepository = carRepository;
    }

    @Transactional
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    public Car updateCar(Car car) {
      if (!carRepository.existsById(car.getId())) {
          throw new RuntimeException("car not found");
      } return carRepository.save(car);
    }

    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAllCarsByPerson(Long id) {
        return carRepository.findAllCarsByPerson(id);
    }


}
