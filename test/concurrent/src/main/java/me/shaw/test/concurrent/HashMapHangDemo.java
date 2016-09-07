package me.shaw.test.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yes on 12/6/16.
 */
public class HashMapHangDemo {
    final Map<Integer,Object> holder = new HashMap<>();

    private class ConcurrencyTask implements Runnable {
        Random random = new Random();
        public void run() {
            System.out.println("Add loop started in task!");
            while (true) {
                holder.put(random.nextInt()%(1024*1024*100),null);
            }
        }
    }

    ConcurrencyTask getConcurrencyCheckTask() {
        return new ConcurrencyTask();
    }

    public static void main(String[] args) {
        HashMapHangDemo demo = new HashMapHangDemo();

        for(int i=0;i<100;i++){
            demo.holder.put(i,null);
        }

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        for(int i=0;;++i){
            for(int j=0;j<10000;++j){
                demo.holder.get(j);
                System.out.printf("Got key %s in round %s\n",j,i);
            }
        }

    }
}
