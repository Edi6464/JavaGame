package Game;

import static Game.Gameplay.*;

public class Timer extends Thread {
    int timeDecrement = 1;
    public static int seconds = 100;
    public static boolean timeLeft = true;

    public void run() {

        while (timeLeft == true) {
            try {

                seconds = seconds - timeDecrement;
                if(seconds == 10){
                    System.out.println("10 SECONDS LEFT !!!");
                }
                if (seconds == 0) {
                    timeLeft=false;
                    timeRemain = false;
                    this.stop();
                }
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}
