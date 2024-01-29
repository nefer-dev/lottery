package com.nefer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTicket {

    private String id;
    private ArrayList<Integer> lotteryNumbers;
    private OpenDate date;

    public LotteryTicket(String id, ArrayList<Integer> lotteryNumbers) {
        this.id = id;
        this.lotteryNumbers = lotteryNumbers;
    }

    public LotteryTicket(ArrayList<Integer> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public Ranking getRanking(ArrayList<Integer> numbers) {
        Collections.sort(this.lotteryNumbers);
        Collections.sort(numbers);
        int numberOfCorrectLotteryNumbers = 0;

        for (int i = 0; i < this.lotteryNumbers.size(); i++) {
            if(this.lotteryNumbers.get(i).equals(numbers.get(i))) {
                numberOfCorrectLotteryNumbers += 1;
            }
        }

        if(numberOfCorrectLotteryNumbers == 6) {
            return Ranking.FIRST;
        }
        else if(numberOfCorrectLotteryNumbers == 5) {
            return Ranking.SECOND;
        }
        else {
            return Ranking.LOSE;
        }
    }

    public String getDate() {
        return date.printOpenDate();
    }


}
