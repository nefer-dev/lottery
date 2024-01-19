package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainsFirstPrizeAndSecondPrize {

    @Test
    public void test() {
        User user = new User("hello", "C222222");
        user.addLotteryTicket(new LotteryTicket("3", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user.addLotteryTicket(new LotteryTicket("4", new ArrayList<>(List.of(1,2,3,4,5,7))));


        ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThat(rankingList.size()).isEqualTo(2);
        Assertions.assertThat(rankingList.get(0)).isEqualTo(Ranking.FIRST);
        Assertions.assertThat(rankingList.get(1)).isEqualTo(Ranking.SECOND);


    }

}
