package com.gupaoedu.springbootbeanvalidation.domain;

import com.gupaoedu.springbootbeanvalidation.validation.constraints.ValidCardNumber;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class User {

    @Max(value = 10000)
    private  long id ;

    @NotNull
    private  String name ;

    @NotNull
    @ValidCardNumber
    private  String cardNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
