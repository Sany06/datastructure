package com.example.demo.chatgpt.graph.bfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        q.offer(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            String word = q.poll();

            if (word == null) {
                level++;

                if (!q.isEmpty()) {
                    q.offer(null);
                }

                continue;
            }

            if (word.equals(endWord)) {
                return level;
            }

            char[] chars = word.toCharArray();

            for (int i = 0; i < word.length(); i++) {

                char original = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {

                    chars[i] = c;

                    String nextWord = new String(chars);

                    if (words.contains(nextWord)
                            && !visited.contains(nextWord)) {

                        visited.add(nextWord);
                        q.offer(nextWord);
                    }
                }

                chars[i] = original;
            }
        }
        return 0;
    }
}
