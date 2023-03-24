package twopointers.sumofthree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfThreeTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource(value = {"1,-1,0;1;false", "3,7,1,2,8,4,5;10;true", "3,7,1,2,8,4,5;20;true", "3,7,1,2,8,4,5;21;false",
            "-1,2,1,-4,5,-3;-8;true", "-1,2,1,-4,5,-3;0;true", "-1,2,1,-4,5,-3;7;false", "3,7,1,2,8,4,5;20;true"}, delimiterString = ";")
    void given_a_list_of_int_when_find_three_nums_that_sum_the_target_then_should_return_correct_answer(@ConvertWith(IntArrayConverter.class) int[] nums, int target, boolean result) {
        var sumOfThree = new SumOfThree();
        assertEquals(result, sumOfThree.findSumOfThree(nums, target));
    }

}
