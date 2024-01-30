package com.nefer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MemberRepository {

    private ArrayList<Member> memberList;

    public MemberRepository() {
        this.memberList = new ArrayList<>();
        this.initializeMembers();
    }

    public void add(Member member) {
        this.memberList.add(member);
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
        this.add(new Member(1L, "전지윤"));
        this.add(new Member(2L, "조용준"));
        this.add(new Member(3L, "강성현"));
        this.add(new Member(4L, "정준영"));
        this.add(new Member(5L, "김지수"));
        this.add(new Member(6L, "성지훈"));
        this.add(new Member(7L, "김강석"));
        this.add(new Member(8L, "김지안"));
        this.add(new Member(9L, "이승훈"));
        this.add(new Member(10L, "이가인"));
        this.add(new Member(11L, "박유빈"));
        this.add(new Member(12L, "양준서"));
        this.add(new Member(13L, "한아현"));
    }

}
