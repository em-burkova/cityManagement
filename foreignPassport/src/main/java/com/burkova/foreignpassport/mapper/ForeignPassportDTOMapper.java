package com.burkova.foreignpassport.mapper;

import com.burkova.foreignpassport.dto.ForeignPassportDTO;
import com.burkova.foreignpassport.model.ForeignPassport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ForeignPassportDTOMapper {

    ForeignPassportDTOMapper INSTANCE = Mappers.getMapper(ForeignPassportDTOMapper.class);

    ForeignPassport mapToEntity(ForeignPassportDTO foreignPassportDTO);
    ForeignPassportDTO mapToDTO(ForeignPassport foreignPassport);

}
