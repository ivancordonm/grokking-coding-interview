package mergeintervals.insertinterval;

import mergeintervals.mergeintervals.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        // First part insert every interval lower than new interval
        var output = new ArrayList<Interval>();
        var i = 0;
        while (i < existingIntervals.size() && existingIntervals.get(i).getStart() < newInterval.getStart()) {
            output.add(new Interval(existingIntervals.get(i).getStart(), existingIntervals.get(i).getEnd()));
            i++;
        }
        // Now insert new interval. It can be merged or just inserted to output
        var lastOutputElement = output.isEmpty() ? null : output.get(output.size() - 1);
        if (lastOutputElement != null && newInterval.getStart() <= lastOutputElement.getEnd())
            lastOutputElement.setEnd(Math.max(newInterval.getEnd(), lastOutputElement.getEnd()));
        else output.add(new Interval(newInterval.getStart(), newInterval.getEnd()));
        // Last part merge or insert the rest
        for (var currentInterval : existingIntervals.subList(i, existingIntervals.size())) {
            lastOutputElement = output.get(output.size() - 1);
            if (currentInterval.getStart() <= lastOutputElement.getEnd())
                lastOutputElement.setEnd(Math.max(lastOutputElement.getEnd(), currentInterval.getEnd()));
            else output.add(new Interval(currentInterval.getStart(), currentInterval.getEnd()));
        }
        return output;
    }
}
