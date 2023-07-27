package twoheaps.scheduletasksonminimummachines;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ScheduleTask {

    public int tasks(List<List<Integer>> tasksList) {
        // A queue of tasks, sorted by the start time
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // A queue of machines, sorted by the end time
        PriorityQueue<int[]> machineQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        var numMachine = 0;

        for (var task : tasksList) {
            taskQueue.offer(new int[]{task.get(0), task.get(1)});
        }
        while (!taskQueue.isEmpty()) {
            var task = taskQueue.poll();
            int[] machine;
            if (!machineQueue.isEmpty() && task[0] >= machineQueue.peek()[0]) {
                machineQueue.poll();
            } else {
                numMachine++;
            }
            machine = new int[]{task[1], numMachine};
            machineQueue.offer(machine);
        }
        return numMachine;
    }

}
