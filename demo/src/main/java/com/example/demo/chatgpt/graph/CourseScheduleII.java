package com.example.demo.chatgpt.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] preq : prerequisites) {
            int course = preq[0];
            int prereq = preq[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            order[idx++] = curr;

            for(int next : graph.get(curr)){
                indegree[next]--;

                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return idx == numCourses ? order : new int[0];

    }
}
