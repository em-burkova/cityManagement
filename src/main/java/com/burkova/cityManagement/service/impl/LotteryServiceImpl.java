package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.aspect.RobinGood;
import com.burkova.cityManagement.service.LotteryService;
import com.burkova.cityManagement.service.PersonService;
import com.burkova.cityManagement.model.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class LotteryServiceImpl implements LotteryService {

    private PersonService personService;

   @Override
   @Scheduled(fixedDelay = 3000)
   @RobinGood
    public Person startLottery() {
       List<Person> participants = personService.getAllPersons();
       Collections.shuffle(participants);
       return participants.get(0);
    }
}
