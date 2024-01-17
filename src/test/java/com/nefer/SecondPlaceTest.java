package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SecondPlaceTest {

    @Test
    public void winTheFirstPlace() {
        User user = new User("Kiley", "C111111");
        user.addLotteryTicket(new LotteryTicket("2", new ArrayList<>(List.of(1,2,3,4,5,7))));

        ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThat(rankingList.size()).isEqualTo(1);
        Assertions.assertThat(rankingList.get(0)).isEqualTo(Ranking.SECOND);


    }
}
