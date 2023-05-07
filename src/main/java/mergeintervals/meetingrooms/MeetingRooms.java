package mergeintervals.meetingrooms;

import mergeintervals.mergeintervals.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals = intervals.stream().sorted(Comparator.comparingInt(Interval::getStart)).toList();
        var meetingRooms = new ArrayList<Interval>();
        meetingRooms.add(intervals.get(0));
        for (var interval : intervals.subList(1, intervals.size())) {
            for (var room : meetingRooms) {
                if (room.getEnd() <= interval.getStart()) {
                    meetingRooms.remove(room);
                    break;
                }
            }
            meetingRooms.add(interval);
        }
        return meetingRooms.size();
    }
}
