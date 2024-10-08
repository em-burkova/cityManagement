package com.burkova.cityManagement.mapper;

import com.burkova.cityManagement.dto.PassportDTO;
import com.burkova.cityManagement.model.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportMapper {

    PassportMapper INSTANCE = Mappers.getMapper(PassportMapper.class);

    Passport mapToEntity(PassportDTO passportDTO);
    PassportDTO mapToDTO(Passport passport);
}
