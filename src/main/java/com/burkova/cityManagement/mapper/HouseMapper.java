package com.burkova.cityManagement.mapper;


import com.burkova.cityManagement.dto.HouseDTO;
import com.burkova.cityManagement.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HouseMapper {

    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    House mapToEntity(HouseDTO houseDTO);
    HouseDTO mapToDTO(House house);
    List<HouseDTO> mapToHousesListDTO(List<House> houses);
}
