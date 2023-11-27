package greedy.jumpgame1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameTest {

    @CsvSource(value = {
            "2,3,1,1,9;true",
            "3,2,1,0,4;false",
            "4,0,0,0,4;true",
            "0;true",
            "1;true"
    }, delimiter = ';')

    @ParameterizedTest(name = "nums = {0} should return {1}")
    void jumpGame(@ConvertWith(IntArrayConverter.class) int[] nums, boolean expected) {
        // Given
        JumpGame jumpGame = new JumpGame();

        // When
        boolean actual = jumpGame.jumpGame(nums);

        // Then
        assertEquals(expected, actual);

    }
}