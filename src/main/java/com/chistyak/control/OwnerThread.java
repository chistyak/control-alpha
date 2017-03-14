/**
 * each user is observed in separate thread
 * this class realizes run() method
 */

package com.chistyak.control;


public class OwnerThread extends Thread{

    private static boolean doStop = false;

    private String OWNER_ID;

    public OwnerThread(String OWNER_ID){
        this.OWNER_ID = OWNER_ID;
    }

    public void run(){
        String lastPost = null;//this and next to save and compare different versions of last post
        String lastPostNew;
        Owner owner = new Owner(OWNER_ID);
        if(!owner.isPresent())
            owner.initialize();
        try {
            for(;;){
                /**
                 * getting the last post from the wall
                 */
                lastPostNew = owner.getLastPost();
                /**
                 * saving last post to the file
                 * if it differs from previously saved lastPost
                 */
                if ((!lastPostNew.toString().equals(lastPost))&&
                        (!lastPostNew.toString().contains("requests"))){
                    owner.savePost(lastPostNew);
                    lastPost = lastPostNew;
                }
                /**
                 * changing value of stopping flag to true
                 * and interrupting all threads(doStop is static)
                 */
                if(lastPost.contains("бэшэнамавпа")) doStop = true;
                if(doStop) this.interrupt();
                /**
                 * pause between checking new posts
                 */
                Thread.sleep(1000);
            }
        }catch (Throwable cause){
            cause.printStackTrace();
        }
    }
}