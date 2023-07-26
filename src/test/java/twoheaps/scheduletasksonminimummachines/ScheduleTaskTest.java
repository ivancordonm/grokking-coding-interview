package twoheaps.scheduletasksonminimummachines;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntervalsToListConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScheduleTaskTest {

    @CsvSource(value = {
        "1:1,5:5,8:8,4:4,6:6,10:10,7:7;1",
        "1:7,1:7,1:7,1:7,1:7,1:7,1:7;7",
        "12:13,13:15,17:20,13:14,19:21,18:20;3",
        "1:7,8:13,5:6,10:4,6:7;2"
    }, delimiter = ';')

    @ParameterizedTest(name = "shouldReturnMinimumNumberOfMachines() = {1}")
    void shouldReturnMinimumNumberOfMachines(@ConvertWith(IntervalsToListConverter.class) List<List<Integer>> intervals,
                                             int expected) {
        // given
        ScheduleTask scheduleTask = new ScheduleTask();

        // when
        int actual = scheduleTask.tasks(intervals);

        // then
        assertEquals(expected, actual);
    }

}
