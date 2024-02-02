package com.nefer.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LotteryNumberInputValidator {
    // 실행결과 dropdown 1 ~ 10 arraylist로 받아서 여섯개 숫자 다르면 true 반환 같으면 false
    /*
    1. 로또 번호에 중복이 없는지 검사하는 클래스
    2. DropdownController 에서 LotteryNumberInputValidator 객체를 만든 뒤 유효성 체크
     */

    public boolean checkForDuplicateLotteryNumbers(ArrayList<Integer> lotteryNumbers) {
        Set<Integer> numset = new HashSet<>(lotteryNumbers);
        if(numset.size() != lotteryNumbers.size()) return false;
        else return true;
    }
}
