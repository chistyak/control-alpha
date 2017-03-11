/**
 * vk wall control app
 * for saving vk posts even if author have deleted them
 */
package com.chistyak.control;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = Initializer.initialize();

        for (String str : list) {
            new OwnerThread(str).start();
        }
    }
}