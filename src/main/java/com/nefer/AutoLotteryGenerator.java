package com.nefer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotteryGenerator {

    public LotteryTicket generate(){
        LotteryTicket test = new LotteryTicket(createId(),createNumbers());
        return test;
    }


    private String createId(){
        return "";
    }
    private ArrayList<Integer> createNumbers(){
        ArrayList<Integer> test = new Random()
                .ints(6,1,11).boxed()
                .distinct().collect(Collectors.toCollection(ArrayList<Integer>::new));
        return test;
    }
}
