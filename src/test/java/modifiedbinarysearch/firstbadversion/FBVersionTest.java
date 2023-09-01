package modifiedbinarysearch.firstbadversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FBVersionTest {

    @CsvSource({
        "13,10,3",
        "100,67,7",
        "29,10,5",
        "40,28,5",
        "23,19,5"
    })
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    void should_return_first_bad_version(int n, int firstBadVersion, int expected) {
        // given
        FBVersion fbVersion = new FBVersion();

        // when
        fbVersion.setBadVersion(firstBadVersion);
        var actual = fbVersion.firstBadVersion(n);

        // then
        assertEquals(firstBadVersion, actual[0]);
        assertEquals(expected, actual[1]);
    }
}
