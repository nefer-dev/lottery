package com.nefer;

import java.util.ArrayList;
import java.util.List;

public class LotteryController {

    private static final Integer secondPlaceWinningStackSize = 5;


    public void run() {
        ArrayList<Member> memberRepository = new ArrayList<>();

        Member member1 = new Member("Saka", "C111111");
        Member member2 = new Member("Nunez", "C222222");
        Member member3 = new Member("CR7", "C333333");

        memberRepository.add(member1);
        memberRepository.add(member2);
        memberRepository.add(member3);

        member1.addLotteryTicket(new LotteryTicket("0", new ArrayList<>(List.of(1,2,3,4,5,6))));
        member1.addLotteryTicket(new LotteryTicket("1", new ArrayList<>(List.of(1,2,3,4,5,7))));
        member1.addLotteryTicket(new LotteryTicket("2", new ArrayList<>(List.of(1,2,3,4,7,8))));
        member1.addLotteryTicket(new LotteryTicket("3", new ArrayList<>(List.of(1,2,3,4,7,8))));

        member2.addLotteryTicket(new LotteryTicket("4", new ArrayList<>(List.of(1,2,3,4,5,6))));
        member2.addLotteryTicket(new LotteryTicket("5", new ArrayList<>(List.of(1,2,3,4,5,6))));
        member2.addLotteryTicket(new LotteryTicket("6", new ArrayList<>(List.of(1,2,3,4,5,6))));
        member2.addLotteryTicket(new LotteryTicket("7", new ArrayList<>(List.of(1,2,3,4,5,7))));

        member3.addLotteryTicket(new LotteryTicket("8", new ArrayList<>(List.of(1,2,3,7,8,9))));
        member3.addLotteryTicket(new LotteryTicket("9", new ArrayList<>(List.of(1,2,3,7,8,9))));
        member3.addLotteryTicket(new LotteryTicket("10", new ArrayList<>(List.of(1,2,3,7,8,9))));
        member3.addLotteryTicket(new LotteryTicket("11", new ArrayList<>(List.of(1,2,3,7,8,9))));
        member3.addLotteryTicket(new LotteryTicket("12", new ArrayList<>(List.of(1,2,3,7,8,9))));
        member3.addLotteryTicket(new LotteryTicket("13", new ArrayList<>(List.of(1,2,3,7,8,9))));

        ArrayList<Ranking> rankingList1 = member1.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        ArrayList<Ranking> rankingList2 = member2.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        ArrayList<Ranking> rankingList3 = member3.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));


        //----------
        ArrayList<Member> members = this.secondPlaceStackCalculate(memberRepository);
        FinalFirstPlaceCalculator finalFirstPlaceCalculator = calculateWinning(members);




    }

    private ArrayList<Member> secondPlaceStackCalculate(ArrayList<Member> members) {
        for (Member member : members) {
            ArrayList<Ranking> rankingList = member.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

            for (Ranking ranking : rankingList) {


                if (ranking == Ranking.SECOND) {
                    member.increaseSecondPlaceWinningStack();
                }

            }

        }
        return members;


    }

    private FinalFirstPlaceCalculator calculateWinning(ArrayList<Member> members) {
        //ArrayList<Ranking> RankingListFinal = new ArrayList<>();

        FinalFirstPlaceCalculator finalFirstPlaceCalculator = new FinalFirstPlaceCalculator();

        for (Member member : members) {

            int secondPlaceWinningStack = member.getSecondPlaceWinningStack();
            int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
            int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;

            for (int i = 0; i < share; i++) {
                finalFirstPlaceCalculator.add(new FinalFirstCandidate(member));
            }
            member.setSecondPlaceWinningStack(remainder);

            /*
            user에 멤버 변수에 다 들어가있는 상태야 (이건 제대로 됐겠지?)
             */
            //-----


            //----- 이제 1등 티켓들로 계산 들어간다
            ArrayList<Ranking> rankingList = member.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
            for (Ranking ranking : rankingList) {
                if(ranking == Ranking.FIRST) {
                    finalFirstPlaceCalculator.add(new FinalFirstCandidate(member));
                }



            }

        }

        return finalFirstPlaceCalculator;



    }

    private Member finalChoose(FinalFirstPlaceCalculator test){
        return test.selectFinalWinner();
    }
}
