package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FinalWinnerRandomDrawTest {

    private static final Integer secondPlaceWinningStackSize = 5;

    @Test
    public void test() {
        User user = new User("aaa", "C333333");
        user.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,4,5,8))));
        user.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,4,6,10))));
        user.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(1,2,3,10,9,8))));


        ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));


        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (Ranking ranking : rankingList) {
            if(ranking == Ranking.FIRST) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
            }

            else if(ranking == Ranking.SECOND) {
                user.increaseSecondPlaceWinningStack();
            }

        }

        Assertions.assertThat(finalFirstPlaceCalculator.getArr().size()).isEqualTo((7));

        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(finalFirstPlaceCalculator.draw()).isGreaterThan(-1);
            Assertions.assertThat(finalFirstPlaceCalculator.draw()).isLessThan(7);
        }



        //second place calculate -> need test
        int secondPlaceWinningStack = user.getSecondPlaceWinningStack();
        int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
        int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;


        for (int i = 0; i < share; i++) {
            finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
        }

        user.setSecondPlaceWinningStack(remainder);
    }

    @Test
    public void testSecondPlace() {
        User user = new User("aaa", "C333333");
        user.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(1,2,3,4,5,7))));


        ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));


        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (Ranking ranking : rankingList) {
            if(ranking == Ranking.FIRST) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
            }

            else if(ranking == Ranking.SECOND) {
                user.increaseSecondPlaceWinningStack();
            }

        }


        //second place calculate -> need test
        int secondPlaceWinningStack = user.getSecondPlaceWinningStack();
        int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
        int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;


        for (int i = 0; i < share; i++) {
            finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
        }

        user.setSecondPlaceWinningStack(remainder);

        Assertions.assertThat(user.getSecondPlaceWinningStack()).isEqualTo(2);
    }

}
