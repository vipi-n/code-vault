// https://leetcode.com/problems/task-scheduler/description/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        for (char task : freq.keySet()) {
            pq.offer(new Task(freq.get(task), 0));
        }

        Queue<Task> cooldown = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // Step 1: bring back tasks whose cooldown has expired
            while (!cooldown.isEmpty() && cooldown.peek().execTime <= time) {
                pq.offer(cooldown.poll());
            }

            // Step 2: run a task if available
            if (!pq.isEmpty()) {
                Task task = pq.poll();
                task.frequency--;

                if (task.frequency > 0) {
                    task.execTime = time + n + 1;  // Ready after n units
                    cooldown.offer(task);
                }
            }

            // else CPU is idle this unit
        }

        return time;
    }
}

class Task {
    int frequency;
    int execTime;

    Task(int frequency, int execTime) {
        this.frequency = frequency;
        this.execTime = execTime;
    }
}
