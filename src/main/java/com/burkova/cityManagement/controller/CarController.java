package com.burkova.cityManagement.controller;


import com.burkova.cityManagement.dto.CarDTO;
import com.burkova.cityManagement.mapper.CarMapper;
import com.burkova.cityManagement.model.Car;
import com.burkova.cityManagement.service.CarService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id) {
        Car car = carService.getCar(id);
        CarDTO result = CarMapper.INSTANCE.mapToDTO(car);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @DeleteMapping("/delete")
    public void deleteCar(@PathParam("id") Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/allcarsbyperson")
    public ResponseEntity<List<CarDTO>> findAllCarsByPerson(@PathParam("id") Long id) {
        return new ResponseEntity<>(CarMapper.INSTANCE.mapToCarListDTO(carService.getAllCarsByPerson(id)), HttpStatus.OK);
    }
}
