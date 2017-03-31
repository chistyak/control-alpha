/**
 * vk wall control app
 * for saving vk posts even if author have deleted them
 */
package com.chistyak.control;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * list containing id's of observed users
         */
        List<String> list = Initializer.initialize();
        /**
         * start threads for every user
         */
        for (String str : list) {
            new OwnerThread(str).start();
        }
    }
}