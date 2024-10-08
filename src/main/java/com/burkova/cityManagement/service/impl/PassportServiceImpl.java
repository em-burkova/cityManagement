package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.model.Passport;
import com.burkova.cityManagement.service.PassportService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PassportServiceImpl implements PassportService {

    private int series;
    private int number;


    public Passport createSeriesAndNumber() {
        Random r = new Random();
        series = r.nextInt(1000, 9999);
        number = r.nextInt(100000, 999999);
        return Passport.builder().series(series).number(number).build();
    }


}
