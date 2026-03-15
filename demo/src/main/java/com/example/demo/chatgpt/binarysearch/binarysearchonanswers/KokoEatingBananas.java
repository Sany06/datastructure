package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for (int count : piles) {
            maxSpeed = Math.max(maxSpeed, count);
        }

        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatInTime(piles, h, mid)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    private boolean canEatInTime(int[] piles, int h, int mid) {

        int time=0;
        for (int count:piles){
            //time+= (int) Math.ceil((double) count /mid);
            time += (count + mid - 1) / mid;     //Math.ceil(a/b) = (a+b-1)/b  // here computation of Math.ceil is very slower as it does
                                                //floating point division and again returns back to int then returns
                                                // if we do (a+b-1)/b its a simple int calculation so its much faster, here we will get the
                                                //ceiling by increasing the numerator value
        }
        return time<=h;
    }
}
