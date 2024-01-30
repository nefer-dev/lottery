package com.nefer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MemberRepository {

    private ArrayList<Member> memberList;
    private Long memberIndex = 0L;

    public MemberRepository() {
        this.memberList = new ArrayList<>();
        this.initializeMembers();
    }

    public void add(String name) {
        this.memberList.add(new Member(this.memberIndex, name));
        this.memberIndex++;
    }

    public void delete(String name) {
        Member memberFoundByName = this.findByName(name);
        this.memberList.remove(memberFoundByName);
    }

    public Member findByName(String name) {
        for (Member member : memberList) {
            if(member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    private void initializeMembers() {
        ArrayList<String> memberNames = new ArrayList<>();
        memberNames.add("전지윤");
        memberNames.add("조용준");
        memberNames.add("강성현");
        memberNames.add("정준영");
        memberNames.add("김지수");
        memberNames.add("성지훈");
        memberNames.add("김강석");
        memberNames.add("김지안");
        memberNames.add("이승훈");
        memberNames.add("이가인");
        memberNames.add("박유빈");
        memberNames.add("양준서");
        memberNames.add("한아현");
        for (String memberName : memberNames) {
            this.add(memberName);

        }

    }

}
