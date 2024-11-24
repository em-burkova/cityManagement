package com.burkova.foreignpassport.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForeignPassportDTO {

    private Long id;
    private String number;
    private Long personId;
}
