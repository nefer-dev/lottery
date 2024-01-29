package com.nefer;

import java.util.ArrayList;

public class User {

    private Long id;
    private String name;
    private String studentId;
    private ArrayList<LotteryTicket> lotteryTicketList;
    private Integer secondPlaceWinningStack;

    public User(Long id, String name) {
        this.id = id; //0L
        this.name = name;
        this.lotteryTicketList = new ArrayList<>();
        this.secondPlaceWinningStack = 0;
    }

    public User(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.lotteryTicketList = new ArrayList<>();
        this.secondPlaceWinningStack = 0;
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

    public void increaseSecondPlaceWinningStack() {
        this.secondPlaceWinningStack += 1;
    }

    public Integer getSecondPlaceWinningStack() {
        return secondPlaceWinningStack;
    }

    public void setSecondPlaceWinningStack(Integer secondPlaceWinningStack) {
        this.secondPlaceWinningStack = secondPlaceWinningStack;
    }

    public String getName() {
        return name;
    }
}
