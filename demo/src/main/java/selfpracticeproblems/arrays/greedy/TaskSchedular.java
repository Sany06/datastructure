package selfpracticeproblems.arrays.greedy;

public class TaskSchedular {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // Step 1: Count frequency of each task
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: Find the maximum frequency
        // This is the "boss task" frequency
        int maxfreq = 0;

        for (int a : freq) {
            maxfreq = Math.max(maxfreq, a);
        }

        // Step 3: Count how many tasks have that maximum frequency
        // Example: A=3, B=3, then maxCount = 2
        int maxcount = 0;

        for(int a : freq) {
            if( a == maxfreq) {
                maxcount++;
            }
        }
        // Number of complete blocks = maxFreq - 1
        // Size of each block = n + 1
        // Last block contains maxCount tasks
        return Math.max(tasks.length, (maxfreq - 1) * (n + 1) + maxcount);
    }
}
