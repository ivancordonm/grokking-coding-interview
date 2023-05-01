package mergeintervals.Intervallistintersections;

import mergeintervals.mergeintervals.Interval;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public List<Interval> intervalsIntersection(List<Interval> intervalLista, List<Interval> intervalListb) {
        List<Interval> intersections = new ArrayList<>(); // to store all intersecting intervals
        int indexA = 0, indexB = 0;
        while (indexA < intervalLista.size() && indexB < intervalListb.size()) {
            var intersectionLeft = Math.max(intervalLista.get(indexA).getStart(), intervalListb.get(indexB).getStart());
            var intersectionRight = Math.min(intervalLista.get(indexA).getEnd(), intervalListb.get(indexB).getEnd());
            if (intersectionLeft <= intersectionRight)
                intersections.add(new Interval(intersectionLeft, intersectionRight));
            if (intervalLista.get(indexA).getEnd() < intervalListb.get(indexB).getEnd()) indexA++;
            else indexB++;

        }
        return intersections;
    }
}
