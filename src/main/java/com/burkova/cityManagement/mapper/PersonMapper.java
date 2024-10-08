package com.burkova.cityManagement.mapper;

import com.burkova.cityManagement.dto.*;
import com.burkova.cityManagement.model.Passport;
import com.burkova.cityManagement.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person mapToEntity(PersonResponseDTO personResponseDTO);
    Person mapToEntity(PersonRequestCreateDTO personRequestCreateDTO);
    @Mapping(target = "carsDTO", source = "person", qualifiedByName = "mapToCarDTOList")
    @Mapping(target = "housesDTO", source = "person", qualifiedByName = "mapToHousesDTOList")
    @Mapping(target = "passportDTO", source = "person", qualifiedByName = "mapToPassportDTO")
    PersonResponseDTO mapToDTO(Person person);
    List<PersonResponseDTO> mapToPersonDTO(List<Person> persons);
    @Named("mapToPassportDTO")
    default PassportDTO mapToPassportDTO(Person person) {
        return PassportMapper.INSTANCE.mapToDTO(person.getPassport());
    }
    @Named("mapToCarDTOList")
    default List<CarDTO> mapToCarDTOList(Person person) {
      return CarMapper.INSTANCE.mapToCarListDTO(person.getCars());
    }
    @Named("mapToHousesDTOList")
    default List<HouseDTO> mapToHousesDTOList(Person person) {
      return HouseMapper.INSTANCE.mapToHousesListDTO(person.getHouses());
    }
}
