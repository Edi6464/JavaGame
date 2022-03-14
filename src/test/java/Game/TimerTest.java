package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {

    @Test
    void testTimerThread(){
        Timer timer=new Timer();
        Timer timer2=new Timer();
        timer.seconds=10;
        assertTrue(timer.timeLeft);
        timer2.seconds=1;
        assertTrue(timer2.timeLeft);
    }



}
