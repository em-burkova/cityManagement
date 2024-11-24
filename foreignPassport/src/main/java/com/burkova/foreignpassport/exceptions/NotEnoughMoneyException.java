package com.burkova.foreignpassport.exceptions;

public class NotEnoughMoneyException extends RuntimeException {


        public NotEnoughMoneyException() {
        }
        public NotEnoughMoneyException(String message) {
            super(message);
        }

}
