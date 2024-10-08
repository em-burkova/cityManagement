package com.burkova.cityManagement.aspect;

import com.burkova.cityManagement.model.Person;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class RobinGoodAspect {

    //todo: имплементировать репо, в нём создать метод "персон без машин" и среди них выбирать (афтер)

    @Before(value = "@annotation(com.burkova.cityManagement.aspect.RobinGood)")
    @SneakyThrows
    public void hasCar(ProceedingJoinPoint proceedingJoinPoint) {
       Person person = (Person) proceedingJoinPoint.proceed();
       if (person.getCars().size() == 0) {
           person.setBankAccountSum(person.getBankAccountSum() + 1000);
       }
    }
}
