package mergeintervals.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public List<Interval> mergeIntervals(List<Interval> intervals) {
        var output = new ArrayList<Interval>();
        output.add(new Interval(intervals.get(0).getStart(), intervals.get(0).getEnd()));
        for (var interval : intervals.subList(1, intervals.size())) {
            var lastInterval = output.get(output.size() - 1);
            // Because the intervals are sorted, we can just check if the start of the current interval
            //
            if (interval.getStart() <= lastInterval.getEnd()) {
                lastInterval.setEnd(Math.max(interval.getEnd(), lastInterval.getEnd()));
            } else {
                output.add(new Interval(interval.getStart(), interval.getEnd()));
            }
        }
        return output;
    }
}
