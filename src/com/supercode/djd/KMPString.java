package com.supercode.djd;

/**
 * Created by jiangdongdeng on 2015/1/9.
 */
public class KMPString {

    public static void prefix(String pattern,int next[]){
        int i,j = -1;
        int len = pattern.length();
        for(i=1;i<len;i++){
            while(j>-1&&pattern.charAt(i)!=pattern.charAt(j+1)){
                j = next[j];
            }
            if(pattern.charAt(i)==pattern.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }

    public static int kmp_index(String text,String pattern){
        if(text==null){
            return -1;
        }
        if(pattern==null||"".equals(pattern)){
            return 0;
        }
        int m = text.length();
        int n = pattern.length();
        int j = -1;
        int next[] = new int[n];
        prefix(pattern,next);
        for(int i=0;i<m;i++){
            while(j>-1&&pattern.charAt(j+1)!=text.charAt(i)){
                j = next[j];
            }
            if(pattern.charAt(j+1)==text.charAt(i)){
                j++;
            }
            if(j==n-1){
                return i-j;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        String text = "ababcabcdeabdabefg";
        String pattern = "abdg";
        System.out.println(kmp_index(text,pattern));
    }
}
