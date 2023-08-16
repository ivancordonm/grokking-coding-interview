package topkelements.kclosestpoints;

import utils.Point;

import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ClosestPoints {

    private double calculateDistanceToCenter(Point point) {
        return abs(sqrt(point.x() * point.x() + point.y() * point.y()));
    }

    public List<Point> kClosest(Point[] points, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k,
            (a, b) -> Double.compare(calculateDistanceToCenter(b), calculateDistanceToCenter(a)));

        for (int i = 0; i < points.length; i++) {
            maxHeap.offer(points[i]);
            if (i >= k) maxHeap.poll();
        }

        return List.copyOf(maxHeap);
    }
}
