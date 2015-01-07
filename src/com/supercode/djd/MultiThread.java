package com.supercode.djd;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Lenovo on 2015/1/2.
 */

class DownloadCall implements Callable<String>{

    private URL url;
    public DownloadCall(URL url){
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        String content = null;
        //download

        return content;
    }
}

public class MultiThread {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        int threads = 4;
        ExecutorService es = Executors.newFixedThreadPool(threads);
        Set<Future<String>> sets = new HashSet<Future<String>>();
        List<URL> urls = new ArrayList<URL>();
        for(final URL url: urls){
            DownloadCall task = new DownloadCall(url);
            Future<String> future = es.submit(task);
            sets.add(future);
        }
        for(Future<String> future:sets){
            String content = future.get();
        }
    }

}
