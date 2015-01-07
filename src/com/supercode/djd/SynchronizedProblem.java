package com.supercode.djd;

/**
 * Created by Lenovo on 2015/1/2.
 */

class SharedData{
    public static String data = "";
};

class ThreadDemo extends Thread{

    private SharedData data;

    public ThreadDemo(SharedData data,String name){
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
    }
};

public class SynchronizedProblem {

}
