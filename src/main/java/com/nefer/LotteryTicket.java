package com.nefer;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {

    private String id;
    private ArrayList<Integer> lotteryNumbers;

    public LotteryTicket(String id, ArrayList<Integer> lotteryNumbers) {
        this.id = id;
        this.lotteryNumbers = lotteryNumbers;
    }

    private List<Integer> getRankingList() {
        return new ArrayList<>();

    }
}
