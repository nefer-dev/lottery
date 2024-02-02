package com.nefer.domain.winning;

import com.nefer.MemberRepository;
import com.nefer.domain.member.Member;
import com.nefer.domain.member.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Calculator {

    private static final Integer secondPlaceWinningStackSize = 5;

    @Autowired
    private MemberRepository memberRepository;

    public void calculate() {
        ArrayList<Member> members = this.secondPlaceStackCalculate(this.memberRepository.getMemberList());
        ArrayList<Member> firstPlaceCandidates = this.secondPlaceStackToFirstPlaceCandidate(members);
        ArrayList<Member> firstPlaceCandidates2 = this.firstPlaceTicketToFirstPlaceCandidate(this.memberRepository.getMemberList(), firstPlaceCandidates);

        Integer drewNumber = this.draw(firstPlaceCandidates2);

        Member winner = firstPlaceCandidates2.get(drewNumber);



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

    private ArrayList<Member> secondPlaceStackToFirstPlaceCandidate(ArrayList<Member> members) {
        ArrayList<Member> firstPlaceCandidates = new ArrayList<>();

        for (Member member : members) {

            int secondPlaceWinningStack = member.getSecondPlaceWinningStack();
            int share = secondPlaceWinningStack / secondPlaceWinningStackSize;
            int remainder = secondPlaceWinningStack % secondPlaceWinningStackSize;

            for (int i = 0; i < share; i++) {
                firstPlaceCandidates.add(member);
            }
            member.setSecondPlaceWinningStack(remainder);

        }

        return firstPlaceCandidates;
    }

    private ArrayList<Member> firstPlaceTicketToFirstPlaceCandidate(ArrayList<Member> members,
                                                                    ArrayList<Member> firstPlaceCandidates) {


        for (Member member : members) {
            //----- 이제 1등 티켓들로 계산 들어간다
            ArrayList<Ranking> rankingList = member.getRankingList(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
            for (Ranking ranking : rankingList) {
                if(ranking == Ranking.FIRST) {
                    firstPlaceCandidates.add(member);
                }

            }

        }

        return firstPlaceCandidates;
    }

    private Integer draw(ArrayList<Member> firstPlaceCandidates) {
        Random random = new Random();
        return random.nextInt(firstPlaceCandidates.size());
    }

}