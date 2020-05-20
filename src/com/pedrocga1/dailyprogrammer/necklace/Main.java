package com.pedrocga1.dailyprogrammer.necklace;

public class Main {
    public static void main(String[] args) {
        String str1 = "";
        for (int i = 0; i < Integer.MAX_VALUE / 10000; i++) {
            str1 = str1.concat("nicole");
        }
        String str2 = str1.substring(41405)
                .concat(str1.substring(0, 41405));
//        new SameNecklaceThread(str1,
//                    str2,
//                    new Thread(() -> System.out.println("true"))).run();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Runnable[] threads = new Runnable[availableProcessors];
        for (int i = 0; i < availableProcessors; i++) {
            threads[i]
                    = new SameNecklaceThread(str1,
                    str2,
                    str2.length() / availableProcessors * i,
                    str2.length() / availableProcessors * (i + 1),
                    new Thread(() -> System.out.println("true")));
        }
        for (int i = 0; i < availableProcessors; i++) {
            threads[i].run();
        }
    }
}
