package com.nefer.domain;

import com.nefer.domain.ticket.LotteryTicket;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class AutoLotteryGenerator {

    private String id;

    public AutoLotteryGenerator() {
        this.id = "0";
    }

    public LotteryTicket generate(){
        return new LotteryTicket(createId(),createNumbers());
    }


    private String createId(){
        String tmp = this.id;
        int number = Integer.parseInt(tmp);
        number += 1;
        return Integer.toString(number);
    }

    private ArrayList<Integer> createNumbers(){
        return new Random()
                .ints(6,1,11).boxed()
                .distinct().collect(Collectors.toCollection(ArrayList<Integer>::new));
    }
}
