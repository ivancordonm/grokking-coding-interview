package topkelements.topkfrequentword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ArrayOfStringConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FrequentWordsTest {

    @CsvSource(value = {
        "aaa,aaa,bbb,bbb,ccc;2;aaa,bbb",
        "lets,play,cricket,and,then,lets,play,badminton;3;lets,play,and",
        "for,every,action,there,is,an,equal,but,opposite,reaction;2;action,an",
        "glarko,zlfiwwb,nsfspyox,pwqvwmlgri,qggx,qrkgmliewc,zskaqzwo,zskaqzwo,ijy,htpvnmozay," +
            "jqrlad,ccjel,qrkgmliewc,qkjzgws,fqizrrnmif,jqrlad,nbuorw,qrkgmliewc,htpvnmozay,nftk," +
            "glarko,hdemkfr,axyak,hdemkfr,nsfspyox,nsfspyox,qrkgmliewc,nftk,nftk,ccjel,qrkgmliewc," +
            "ocgjsu,ijy,glarko,nbuorw,nsfspyox,qkjzgws,qkjzgws,fqizrrnmif,pwqvwmlgri,nftk,qrkgmliewc," +
            "jqrlad,nftk,zskaqzwo,glarko,nsfspyox,zlfiwwb,hwlvqgkdbo,htpvnmozay,nsfspyox,zskaqzwo," +
            "htpvnmozay,zskaqzwo,nbuorw,qkjzgws,zlfiwwb,pwqvwmlgri,zskaqzwo,qengse,glarko,qkjzgws,pwqvwmlgri," +
            "fqizrrnmif,nbuorw,nftk,ijy,hdemkfr,nftk,qkjzgws,jqrlad,nftk,ccjel,qggx,ijy,qengse,nftk,htpvnmozay," +
            "qengse,eonrg,qengse,fqizrrnmif,hwlvqgkdbo,qengse,qengse,qggx,qkjzgws,qggx,pwqvwmlgri,htpvnmozay," +
            "qrkgmliewc,qengse,fqizrrnmif,qkjzgws,qengse,nftk,htpvnmozay,qggx,zlfiwwb,bwp,ocgjsu,qrkgmliewc," +
            "ccjel,hdemkfr,nsfspyox,hdemkfr,qggx,zlfiwwb,nsfspyox,ijy,qkjzgws,fqizrrnmif,qkjzgws,qrkgmliewc," +
            "glarko,hdemkfr,pwqvwmlgri;" +
            "14;nftk,qkjzgws,qrkgmliewc,nsfspyox,qengse,htpvnmozay,fqizrrnmif,glarko,hdemkfr,pwqvwmlgri,qggx,zskaqzwo,ijy,zlfiwwb"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {2} most {1} frequent words from {0}")
    void shouldReturnKMostFrequentWords(@ConvertWith(ArrayOfStringConverter.class) String[] input, int k,
                                        @ConvertWith(ArrayOfStringConverter.class) String[] expected) {
        // given
        FrequentWords frequentWords = new FrequentWords();

        // when
        var actual = frequentWords.topKFrequent(input, k);

        // then
        assertIterableEquals(List.of(expected), actual);
    }
}
