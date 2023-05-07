package mergeintervals.meetingrooms;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntervalsConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRoomsTest {

    @CsvSource(value = {
        " 3:17,19:20,20:22,1:18,9:19,21:22,3:4,7:22;4",
        "1:2,4:6,3:4,7:8;1",
        "1:2,1:2,1:2;3"
    }, delimiter = ';')
    @ParameterizedTest()
    void minMeetingRooms(@ConvertWith(IntervalsConverter.class) List<Interval> intervals, int expected) {
        assertEquals(expected, new MeetingRooms().minMeetingRooms(intervals));
    }
}
