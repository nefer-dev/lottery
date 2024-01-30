package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FinalWinnerRandomDrawTest {

    private static final Integer secondPlaceWinningStackSize = 5;

    @Test
    public void test() {
        Member member = new Member("aaa", "C333333");
        member.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,6))));
        member.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,4,5,6))));
        member.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,4,5,8))));
        member.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,4,6,10))));
        member.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(1,2,3,7,8,9))));
        member.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(1,2,3,10,9,8))));


        ArrayList<Ranking> rankingList = member.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));


        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (Ranking ranking : rankingList) {
            if(ranking == Ranking.FIRST) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(member));
            }

            else if(ranking == Ranking.SECOND) {
                member.increaseSecondPlaceWinningStack();
            }

        }

        Assertions.assertThat(finalFirstPlaceCalculator.getArr().size()).isEqualTo((2));

        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(finalFirstPlaceCalculator.draw()).isGreaterThan(-1);
            Assertions.assertThat(finalFirstPlaceCalculator.draw()).isLessThan(7);
        }



        //second place calculate -> need test
        int secondPlaceWinningStack = member.getSecondPlaceWinningStack();
        int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
        int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;


        for (int i = 0; i < share; i++) {
            finalFirstPlaceCalculator.add(new FinalFirstCandidate(member));
        }

        member.setSecondPlaceWinningStack(remainder);
    }

    @Test
    public void testSecondPlace() {
        Member member = new Member("aaa", "C333333");
        member.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(1,2,3,4,5,7))));


        ArrayList<Ranking> rankingList = member.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));


        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (Ranking ranking : rankingList) {
            if(ranking == Ranking.FIRST) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(member));
            }

            else if(ranking == Ranking.SECOND) {
                member.increaseSecondPlaceWinningStack();
            }

        }


        //second place calculate -> need test
        int secondPlaceWinningStack = member.getSecondPlaceWinningStack();
        int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
        int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;


        for (int i = 0; i < share; i++) {
            finalFirstPlaceCalculator.add(new FinalFirstCandidate(member));
        }

        member.setSecondPlaceWinningStack(remainder);

        Assertions.assertThat(member.getSecondPlaceWinningStack()).isEqualTo(2);
    }

}
