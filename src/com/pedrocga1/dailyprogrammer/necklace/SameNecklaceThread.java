package com.pedrocga1.dailyprogrammer.necklace;

public class SameNecklaceThread implements Runnable {
    private final String firstNecklace;
    private final String secondNecklace;
    private final int beginIndex;
    private final int endIndex;
    private final Runnable callback;

    public SameNecklaceThread(
            String firstNecklace,
            String secondNecklace,
            int beginIndex,
            int endIndex,
            Runnable callback
    ) {
        this.firstNecklace = firstNecklace;
        this.secondNecklace = secondNecklace;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.callback = callback;
    }

    public SameNecklaceThread(String firstNecklace,
                              String secondNecklace,
                              Runnable callback) {
        this.firstNecklace = firstNecklace;
        this.secondNecklace = secondNecklace;
        this.beginIndex = 0;
        this.endIndex = firstNecklace.length();
        this.callback = callback;
    }

    public void run() {
        if (this.firstNecklace.isEmpty() && secondNecklace.isEmpty()) {
            callback.run();
        }

        int str1Len = firstNecklace.length();
        if (str1Len != secondNecklace.length()) {
            return;
        }

        for (int i = beginIndex; i < endIndex; i++) {
            if (firstNecklace.charAt(0) == secondNecklace.charAt(i)
                    && firstNecklace.substring(0, str1Len - i)
                    .equals(secondNecklace.substring(i))
                    && firstNecklace.substring(str1Len - i)
                    .equals(secondNecklace.substring(0, i))) {
                callback.run();
            }
        }
    }
}
