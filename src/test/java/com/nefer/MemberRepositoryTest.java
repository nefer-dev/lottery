package com.nefer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

    @Test
    public void test() {
        MemberRepository memberRepository = new MemberRepository();
        Assertions.assertThat(memberRepository.findByName("전지윤")).isNotNull();

        memberRepository.delete("전지윤");
        Assertions.assertThat(memberRepository.findByName("전지윤")).isNull();

    }
}
