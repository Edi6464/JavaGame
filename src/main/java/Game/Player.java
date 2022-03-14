package Game;

public class Player extends Positioning {

    private int playerXPosition;
    private int playerYPosition;
    public static int playerHealthbar =3;


    Player(){
        playerXPosition =14;
        playerYPosition =8;
    }


    public int getPlayerXPosition() {
        return playerXPosition;
    }

    public int getPlayerYPosition() {
        return playerYPosition;
    }

    public void setPlayerXPosition(int playerXPosition) {
        this.playerXPosition = playerXPosition;
    }

    public void setPlayerYPosition(int playerYPosition) {
        this.playerYPosition = playerYPosition;
    }
}
