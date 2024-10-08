package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.service.HouseService;
import com.burkova.cityManagement.model.House;
import com.burkova.cityManagement.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    public House getHouse(Long id) {
        return houseRepository.findById(id).orElseThrow();
    }

    public House updateHouse(House house) {
        if (!houseRepository.existsById(house.getId())) {
            throw new RuntimeException("house not found");
        } return houseRepository.save(house);
    }

    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }
}
