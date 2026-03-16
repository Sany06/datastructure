package com.example.demo.chatgpt.heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<MyClass> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distToOrigin, a.distToOrigin));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double dist = Math.sqrt((x * x) + (y * y));

            MyClass myClass = new MyClass(point, dist);
            pq.offer(myClass);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] result = new int[pq.size()][2];
        int row = 0;
        while (!pq.isEmpty()) {
            int[] points1 = pq.poll().getPoints();
            result[row] = points1;
            row++;
        }
        return result;
    }

    class MyClass {
        int[] points;
        double distToOrigin;

        public MyClass(int[] points, double distToOrigin) {
            this.points = points;
            this.distToOrigin = distToOrigin;
        }

        public int[] getPoints() {
            return points;
        }
    }
}
