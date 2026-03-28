package com.example.demo.chatgpt.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList();
        calculate(s,0,new ArrayList<>(),list);
        return list;
    }

    public void calculate(String s, int index,List<String> temp,List<List<String>> list){
        if(index==s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){

            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                calculate(s,i+1,temp,list);
                temp.remove(temp.size()-1);

            }
        }

    }


    public boolean isPalindrome(String s,int start,int end){
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
