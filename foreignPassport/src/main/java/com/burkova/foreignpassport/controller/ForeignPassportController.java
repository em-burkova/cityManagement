package com.burkova.foreignpassport.controller;


import com.burkova.foreignpassport.dto.ForeignPassportDTO;
import com.burkova.foreignpassport.mapper.ForeignPassportDTOMapper;
import com.burkova.foreignpassport.model.ForeignPassport;
import com.burkova.foreignpassport.service.ForeignPassportService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person/foreignpassport")
public class ForeignPassportController {

    private final ForeignPassportService foreignPassportService;
    public ForeignPassportController(@Qualifier("foreignPassportServiceImpl") ForeignPassportService foreignPassportService) {
        this.foreignPassportService = foreignPassportService;
    }
    @PostMapping("/create/{id}")
    public ResponseEntity<ForeignPassportDTO> createForeignPassport(@PathVariable Long id) {
        ForeignPassport foreignPassport = foreignPassportService.createForeignPassport(id);
        ForeignPassportDTO result = ForeignPassportDTOMapper.INSTANCE.mapToDTO(foreignPassport);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
