package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
//complete
public class WinningLotteryTest {

    @Test
    public void winTheFirstPlace() {
        User user = new User("Judy", "C000000");
        user.addLotteryTicket(new LotteryTicket("1", new ArrayList<>(List.of(1,2,3,4,5,6))));

        ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThat(rankingList.size()).isEqualTo(1);
        Assertions.assertThat(rankingList.get(0)).isEqualTo(Ranking.FIRST);


    }

}
