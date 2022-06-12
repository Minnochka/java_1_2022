package ru.geekbrains.bogachevaks;

    public class WaitNotifyClass {
        private final Object mon = new Object();
        private volatile char currentLetter = 'A';

        public static void main(String[] args) {
            WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
            Thread thread1 = new Thread(() -> {
                waitNotifyObj.printA();
            });
            Thread thread2 = new Thread(() -> {
                waitNotifyObj.printB();
            });
            Thread thread3 = new Thread(() -> {
                waitNotifyObj.printC();
            });
            thread3.start();
            thread2.start();
            thread1.start();
        }

        public void printA() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (currentLetter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notifyAll();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printB() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (currentLetter != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'D';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printC() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (currentLetter != 'D') {
                            mon.wait();
                        }
                        System.out.print("D");
                        currentLetter = 'A';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

