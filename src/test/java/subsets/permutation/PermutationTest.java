package subsets.permutation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringListConverter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {

    @CsvSource(value = {
            "abc;abc,acb,bac,bca,cab,cba",
            "dog;dog,dgo,odg,ogd,gdo,god",
            "123;123,132,213,231,312,321",
            "a;a",
            "ab;ab,ba"
    }, delimiter = ';')
    @ParameterizedTest(name = "permuteWord({0}) should return {1}")
    void shouldReturnAllPermutations(String word,  @ConvertWith(StringListConverter.class) ArrayList<String> expected) {

        //given
        var permutation = new Permutation();

        //when
        var actual = permutation.permuteWord(word);

        //then
        assertEquals(expected, actual);
    }

}