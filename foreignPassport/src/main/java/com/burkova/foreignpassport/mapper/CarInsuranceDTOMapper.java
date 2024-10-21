package com.burkova.foreignpassport.mapper;

import com.burkova.foreignpassport.dto.CarInsuranceDTO;
import com.burkova.foreignpassport.model.CarInsurance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarInsuranceDTOMapper {

    CarInsuranceDTOMapper INSTANCE = Mappers.getMapper(CarInsuranceDTOMapper.class);

    CarInsurance mapToEntity(CarInsuranceDTO carInsuranceDTO);
    CarInsuranceDTO mapToDTO(CarInsurance car);
    List<CarInsuranceDTO> mapToCarInsuranceListDTO(List<CarInsurance> carInsurances);

}
