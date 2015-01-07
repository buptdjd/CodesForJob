package com.supercode.djd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2015/1/7.
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPoints {

    public static int maxPoints(Point[] points) {
        int len = points.length;
        if(len<=2){
            return len;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++) {
            int x = points[i].x;
            int y = points[i].y;
            int dup = 1;
            HashMap<Float, Integer> maps = new HashMap<Float, Integer>();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int x1 = points[j].x;
                int y1 = points[j].y;
                if (x == x1 && y == y1) {
                    dup++;
                    continue;
                }
                float value = (x == x1 ? (float) Integer.MAX_VALUE : (y - y1)*1.0f / (x - x1));
                if (maps.containsKey(value)) {
                    maps.put(value, maps.get(value) + 1);
                } else {
                    maps.put(value, 1);
                }
            }
            if(maps.size()==0){
                max = max > dup?max:dup;
            }
            for (Map.Entry<Float, Integer> entry : maps.entrySet()) {
                int value = entry.getValue() + dup;
                max = max > value ? max : value;
            }
        }
        return max;
    }

    public static void main(String args[]){
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,1);
        Point p4 = new Point(1,1);
        Point p5 = new Point(1,1);
        Point []points = new Point[5];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        points[4] = p5;
        System.out.println(maxPoints(points));
    }

}
