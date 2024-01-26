package com.nefer;

import java.util.ArrayList;
import java.util.List;

public class LotteryController {

    private static final Integer secondPlaceWinningStackSize = 5;


    public void run() {
        ArrayList<User> userRepository = new ArrayList<>();

        User user1 = new User("Saka", "C111111");
        User user2 = new User("Nunez", "C222222");
        User user3 = new User("CR7", "C333333");

        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);

        user1.addLotteryTicket(new LotteryTicket("0", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user1.addLotteryTicket(new LotteryTicket("1", new ArrayList<>(List.of(1,2,3,4,5,7))));
        user1.addLotteryTicket(new LotteryTicket("2", new ArrayList<>(List.of(1,2,3,4,7,8))));
        user1.addLotteryTicket(new LotteryTicket("3", new ArrayList<>(List.of(1,2,3,4,7,8))));

        user2.addLotteryTicket(new LotteryTicket("4", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user2.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user2.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,4,5,6))));
        user2.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,4,5,7))));

        user3.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user3.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user3.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user3.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user3.addLotteryTicket(new LotteryTicket("12", new ArrayList<>(List.of(1,2,3,7,8,9))));
        user3.addLotteryTicket(new LotteryTicket("13", new ArrayList<>(List.of(1,2,3,7,8,9))));

        ArrayList<Ranking> rankingList1 = user1.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        ArrayList<Ranking> rankingList2 = user2.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        ArrayList<Ranking> rankingList3 = user3.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));


        //----------
        ArrayList<User> users = this.secondPlaceStackCalculate(userRepository);
        FinalFirstPlaceCalculator finalFirstPlaceCalculator = calculateWinning(users);




    }

    private ArrayList<User> secondPlaceStackCalculate(ArrayList<User> users) {
        for (User user : users) {
            ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

            for (Ranking ranking : rankingList) {


                if (ranking == Ranking.SECOND) {
                    user.increaseSecondPlaceWinningStack();
                }

            }

        }
        return users;


    }

    private FinalFirstPlaceCalculator calculateWinning(ArrayList<User> users) {
        //ArrayList<Ranking> RankingListFinal = new ArrayList<>();

        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (User user : users) {

            int secondPlaceWinningStack = user.getSecondPlaceWinningStack();
            int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
            int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;

            for (int i = 0; i < share; i++) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
            }
            user.setSecondPlaceWinningStack(remainder);

            /*
            user에 멤버 변수에 다 들어가있는 상태야 (이건 제대로 됐겠지?)
             */
            //-----


            //----- 이제 1등 티켓들로 계산 들어간다
            ArrayList<Ranking> rankingList = user.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
            for (Ranking ranking : rankingList) {
                if(ranking == Ranking.FIRST) {
                    finalFirstPlaceCalculator.add(new FinalFirstCandidate(user));
                }



            }

        }

        return finalFirstPlaceCalculator;



    }

    private User finalChoose(FinalFirstPlaceCalculator test){
        return test.selectFinalWinner();
    }
}
