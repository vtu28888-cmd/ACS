import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the current timestamp
        queue.offer(t);
        
        // Remove timestamps that are older than t - 3000
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // The size of the queue is the number of recent calls in the range [t - 3000, t]
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */