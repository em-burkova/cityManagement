package com.burkova.cityManagement.mapper;

import com.burkova.cityManagement.dto.CarDTO;
import com.burkova.cityManagement.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car mapToEntity(CarDTO carDTO);
    CarDTO mapToDTO(Car car);
    List<CarDTO> mapToCarListDTO(List<Car> cars);

}
