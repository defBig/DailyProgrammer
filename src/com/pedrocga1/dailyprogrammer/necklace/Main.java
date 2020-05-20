package com.pedrocga1.dailyprogrammer.necklace;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String str1 = "";
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            str1 = str1.concat("nicole");
//        }
        String str1 = null;
        String str2 = null;
        try {
            str1 = new Scanner(new File("/tmp/necklace")).nextLine();
            str2 = new Scanner(new File("/tmp/necklace2")).nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long start = System.nanoTime();
//        new SameNecklaceThread(
//            str1,
//            str2,
//            new Thread(() ->  {
//                System.out.println(System.nanoTime() - start)
//            })
//        ).run();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Runnable[] threads = new Runnable[availableProcessors];
        for (int i = 0; i < availableProcessors; i++) {
            threads[i]
                = new SameNecklaceThread(
                    str1,
                    str2,
                    str2.length() / availableProcessors * i,
                    str2.length() / availableProcessors * (i + 1),
                    new Thread(() ->  {
                        System.out.println(System.nanoTime() - start);
                        System.exit(0);
                    })
                );
        }
        for (int i = 0; i < availableProcessors; i++) {
            threads[i].run();
        }
    }
}
