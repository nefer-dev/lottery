package com.nefer;

import com.nefer.util.LotteryNumberInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumberInputValidatorTest {
    @Test
    public void test(){
        LotteryNumberInputValidator lotteryNumberInputValidator = new LotteryNumberInputValidator();
        ArrayList<Integer> integers1 = new ArrayList<>(List.of(1,1,3,4,5,6));
        ArrayList<Integer> integers2 = new ArrayList<>(List.of(1,2,3,4,5,6));
        Assertions.assertThat(lotteryNumberInputValidator.checkForDuplicateLotteryNumbers(integers1)).isEqualTo(false);
        Assertions.assertThat(lotteryNumberInputValidator.checkForDuplicateLotteryNumbers(integers2)).isEqualTo(true);


    }
}
