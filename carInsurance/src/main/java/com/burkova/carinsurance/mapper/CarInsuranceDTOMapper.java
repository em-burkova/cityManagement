package com.burkova.carinsurance.mapper;

import com.burkova.carinsurance.dto.CarInsuranceDTO;
import com.burkova.carinsurance.exceptions.model.CarInsurance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper
public interface CarInsuranceDTOMapper {

    CarInsuranceDTOMapper INSTANCE = Mappers.getMapper(CarInsuranceDTOMapper.class);

    CarInsurance mapToEntity(CarInsuranceDTO carInsuranceDTO);
    @Mapping(target = "carsDTO", source = "car", qualifiedByName = "mapToCarDTOList")
    CarInsuranceDTO mapToDTO(CarInsurance car);
    @Named("mapToCarDTOList")
    default List<CarInsuranceDTO> mapToCarInsuranceListDTO(List<CarInsurance> carInsurances){
        return CarInsuranceDTOMapper.INSTANCE.mapToCarInsuranceListDTO(carInsurances);
    }

}
