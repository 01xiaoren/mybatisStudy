package com.xiaoren;

public class game2 {
    public static void main(String[] args) {
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("cpu飙高");
                }
            }
        }).start();*/
        new Thread(() -> {
            while (true) {
                System.out.println("cpu飙高");
            }
        }).start();
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
