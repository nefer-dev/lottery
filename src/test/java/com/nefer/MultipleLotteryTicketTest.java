package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
//complete
public class MultipleLotteryTicketTest {

    @Test
    public void test() {
        User user = new User("aaa", "C333333");
        user.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,7,8,10))));
        user.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,4,5,8))));
        user.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(5,6,7,8,9,1))));
        user.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(10,3,2,4,5,1))));


        ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThat(rankingList.size()).isEqualTo(7);

        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (Ranking ranking : rankingList) {
            if(ranking == Ranking.FIRST) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
            }

        }

        Assertions.assertThat(finalFirstPlaceCalculator.getArr().size()).isEqualTo((2));

    }


}
