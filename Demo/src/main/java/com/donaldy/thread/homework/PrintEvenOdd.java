package com.donaldy.thread.homework;

/**
 * @author donald
 * @date 2021/03/02
 */
public class PrintEvenOdd {

    private int state;
    private int num;
    private final static Object LOCK = new Object();

    private PrintEvenOdd(int num) {
        this.num = num;
    }

    private void printEventOdd(int target) {

        for (; state < num;) {

            synchronized (LOCK) {
                while (state % 2 != target) {

                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (state < num) {

                    System.out.print(state + " ");
                    state++;
                    LOCK.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {

        PrintEvenOdd printEvenOdd = new PrintEvenOdd(100);

        new Thread(() -> {printEvenOdd.printEventOdd(0);}).start();
        new Thread(() -> {printEvenOdd.printEventOdd(1);}).start();
    }
}
