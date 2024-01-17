package com.nefer;

import java.util.ArrayList;

public class User {

    private String name;
    private String studentId;
    private ArrayList<LotteryTicket> lotteryTicketList;

    public User(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.lotteryTicketList = new ArrayList<>();
    }

    public void addLotteryTicket(LotteryTicket lotteryTicket) {
        this.lotteryTicketList.add(lotteryTicket);
    }

    public ArrayList<Ranking> getRankingList(ArrayList<Integer> winningLotteryNumbers) {
        ArrayList<Ranking> rankings = new ArrayList<>();
        for (LotteryTicket lotteryTicket : lotteryTicketList) {
            Ranking ranking = lotteryTicket.getRanking(winningLotteryNumbers);

            rankings.add(ranking);

        }

        return rankings;
    }
}
