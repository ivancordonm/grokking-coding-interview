package mergeintervals.employeefreetime;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ListOfIntervalsConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeFreeTimesTest {

    @CsvSource(value = {"3:5,8:10;4:6,9:12;5:6,8:10;6:8"}, delimiter = ';')
    @ParameterizedTest(name = "employeeFreeTime({0}) should return {1}")
    void employeeFreeTime(@ConvertWith(ListOfIntervalsConverter.class) List<List<Interval>> listOfIntervals) {
        var expected = listOfIntervals.remove(listOfIntervals.size() - 1);
        assertEquals(expected, new EmployeeFreeTimes().employeeFreeTime(listOfIntervals));
    }
}
