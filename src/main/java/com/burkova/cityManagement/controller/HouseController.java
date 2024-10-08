package com.burkova.cityManagement.controller;

import com.burkova.cityManagement.dto.HouseDTO;
import com.burkova.cityManagement.mapper.HouseMapper;
import com.burkova.cityManagement.model.House;
import com.burkova.cityManagement.service.HouseService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/create")
    public ResponseEntity<HouseDTO> createHouse(@RequestBody HouseDTO houseDTO) {
        House house = HouseMapper.INSTANCE.mapToEntity(houseDTO);
        House savedHouse = houseService.createHouse(house);
        HouseDTO result = HouseMapper.INSTANCE.mapToDTO(savedHouse);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable Long id) {
        House house = houseService.getHouse(id);
        HouseDTO houseDTO = HouseMapper.INSTANCE.mapToDTO(house);
        return new ResponseEntity<>(houseDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HouseDTO> updateHouse(@RequestBody HouseDTO houseDTO) {
        House house = HouseMapper.INSTANCE.mapToEntity(houseDTO);
        House savedHouse = houseService.updateHouse(house);
        HouseDTO result = HouseMapper.INSTANCE.mapToDTO(savedHouse);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteHouse (@PathParam("id") Long id) {
        houseService.deleteHouse(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HouseDTO>> getAllHouses() {
        return new ResponseEntity<>(HouseMapper.INSTANCE.mapToHousesListDTO(houseService.getAllHouses()), HttpStatus.OK);
    }
}
