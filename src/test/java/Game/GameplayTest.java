package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GameplayTest {

    @Test
    void TestPlayerHealthbar(){
        Player player = new Player();
        Finish finish = new Finish();
        String mat[][] = new String[15][15];
        Map map = new Map(mat);
        mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "P";
        mat[finish.getFinishXPosition()][finish.getFinishYPosition()] = "X";
        map.generatePath(mat);
    }


}
