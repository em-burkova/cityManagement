package com.burkova.cityManagement.service;

import com.burkova.cityManagement.model.House;

import java.util.List;

public interface HouseService {

    House createHouse(House house);
    House getHouse(Long id);
    House updateHouse(House house);
    void deleteHouse(Long id);
    List<House> getAllHouses();
}
