package mergeintervals.employeefreetime;

import mergeintervals.mergeintervals.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTimes {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        // [[3, 5], [8, 10]]
        // [[4, 6], [9, 12]]
        // [[5, 6], [8, 10]]
        // [[3, 5],[4, 6],[5, 6],[8, 10],[8, 10],[9, 12]]
        // => [[6,8]]
        List<Interval> ans = new ArrayList<>();

        var allIntervals = schedule.stream()
                                   .flatMap(List::stream)
                                   .sorted(Comparator.comparingInt(Interval::getStart))
                                   .toList();

        var lastEnd = allIntervals.get(0).getEnd();
        for (var interval : allIntervals.subList(1, allIntervals.size())) {
            if (interval.getStart() > lastEnd) ans.add(new Interval(lastEnd, interval.getStart()));
            if (interval.getEnd() > lastEnd) lastEnd = interval.getEnd();
        }

        return ans;
    }
}
