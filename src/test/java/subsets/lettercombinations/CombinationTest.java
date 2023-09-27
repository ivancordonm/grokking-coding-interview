package subsets.lettercombinations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringListConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationTest {

    @CsvSource(value = {
            "23;ad,ae,af,bd,be,bf,cd,ce,cf",
            "2;a,b,c",
            ";",
            "345;dgj,dgk,dgl,dhj,dhk,dhl,dij,dik,dil,egj,egk,egl,ehj,ehk,ehl,eij,eik,eil,fgj,fgk,fgl,fhj,fhk,fhl,fij,fik,fil"
    }, delimiter = ';')
    @ParameterizedTest(name = "letterCombinations({0}) should return {1}")
    void shouldReturnAllCombinations(String digits, @ConvertWith(StringListConverter.class) List<String> expected) {

        //given
        var combination = new Combination();

        //when
        var actual = combination.letterCombinations(digits);

        //then
        assertEquals(expected, actual);
    }
}