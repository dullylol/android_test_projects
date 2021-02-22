package com.asustuf.dialog;

import androidx.appcompat.app.AlertDialog;

public class AlertDebugger implements Runnable {
    volatile AlertDialog alert;
    volatile boolean[] mSelectedIngredients;

    AlertDebugger(AlertDialog alert, boolean[] mSelectedIngredients) {
        this.alert = alert;
        //this.mSelectedIngredients = mSelectedIngredients;
        this.mSelectedIngredients = new boolean[mSelectedIngredients.length];
        for (int i = 0; i < mSelectedIngredients.length; i++) {
            this.mSelectedIngredients[i] = mSelectedIngredients[i];
        }
    }


    @Override
    public void run() {
        System.out.println("\nStart new thread...");
        while (alert.isShowing()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting...");
        }
        for (boolean element: mSelectedIngredients) {
            System.out.print(element + "\t");
        }
        System.out.println("\nFinish thread...");
    }
}