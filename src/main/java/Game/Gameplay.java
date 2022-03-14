package Game;

import java.util.Scanner;
import static Game.Player.playerHealthbar;
import static Game.Timer.*;

public class Gameplay extends  Thread  {

    public static boolean timeRemain=true;
    public static boolean status = false;
    Player player = new Player();
    Finish finish = new Finish();
    String mat[][] = new String[15][15];
    Map map = new Map(mat);


    Gameplay() {
        mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "P";
        mat[finish.getFinishXPosition()][finish.getFinishYPosition()] = "X";
        map.generatePath(mat);
        Scanner scan = new Scanner(System.in);
        Timer timer=new Timer();
        timer.start();
        while (status == false) {
            System.out.println("Where do you want to go :");
            String choice = scan.nextLine();
            switch (choice) {
                case "w":
                if (checkWallCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), "w") == false) {
                    if (checkRockCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), "w") == false) {
                        mat[player.getPlayerXPosition() - 1][player.getPlayerYPosition()] = "P";
                        mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                        player.setPlayerXPosition(player.getPlayerXPosition() - 1);
                    } else {
                        if(mat[player.getPlayerXPosition()-2][player.getPlayerYPosition()].equals("|")) {
                            playerHealthbar--;
                        }
                        else {
                            mat[player.getPlayerXPosition() - 2][player.getPlayerYPosition()] = "K";
                            mat[player.getPlayerXPosition() - 1][player.getPlayerYPosition()] = "P";
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                            player.setPlayerXPosition(player.getPlayerXPosition() - 1);
                        }
                    }

                }
                map.print2D(mat);
            break;
                case "a" :
                if (checkWallCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), "a") == false) {
                    if (checkRockCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), "a") == false) {
                        mat[player.getPlayerXPosition()][player.getPlayerYPosition() - 1] = "P";
                        mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                        player.setPlayerYPosition(player.getPlayerYPosition() - 1);
                    } else {
                        if (mat[player.getPlayerXPosition() ][player.getPlayerYPosition() - 2].equals("|")) {
                            playerHealthbar--;
                        } else {
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition() - 2] = "K";
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition() - 1] = "P";
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                            player.setPlayerYPosition(player.getPlayerYPosition() - 1);
                        }
                    }
                }
                map.print2D(mat);
                break;
                case "d":
                if (checkWallCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), "d") == false) {
                    if (checkRockCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), "d") == false) {
                        mat[player.getPlayerXPosition()][player.getPlayerYPosition() + 1] = "P";
                        mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                        player.setPlayerYPosition(player.getPlayerYPosition() + 1);
                    } else {
                        if (mat[player.getPlayerXPosition()][player.getPlayerYPosition()+2].equals("|")) {
                            playerHealthbar--;
                        } else {
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition() + 2] = "K";
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition() + 1] = "P";
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                            player.setPlayerYPosition(player.getPlayerYPosition() + 1);
                        }
                    }
                }
                map.print2D(mat);
            break;

                case "s":
                if (checkWallCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), choice) == false) {
                    if (checkRockCollision(mat, player.getPlayerXPosition(), player.getPlayerYPosition(), choice) == false) {
                        mat[player.getPlayerXPosition() + 1][player.getPlayerYPosition()] = "P";
                        mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                        player.setPlayerXPosition(player.getPlayerXPosition() + 1);
                    } else {
                        if (mat[player.getPlayerXPosition() +2][player.getPlayerYPosition()].equals("|")) {
                            playerHealthbar--;
                        } else {
                            mat[player.getPlayerXPosition() + 2][player.getPlayerYPosition()] = "K";
                            mat[player.getPlayerXPosition() + 1][player.getPlayerYPosition()] = "P";
                            mat[player.getPlayerXPosition()][player.getPlayerYPosition()] = "©";
                            player.setPlayerXPosition(player.getPlayerXPosition() + 1);
                        }
                    }
                }
                map.print2D(mat);
            break;
        }
            if(mat[Positioning.getQmXPosition()][Positioning.getQmYPosition()].equals("K")){
                mat[Positioning.getQmXPosition()][Positioning.getQmYPosition()]="K";
                mat[Positioning.getGateXPosition()][Positioning.getGateYPosition()]="©";
                map.print2D(mat);
            }
            if(mat[1][3].equals("P")){
                status=true;
                timer.stop();
                System.out.println("------------------------");
                System.out.println("\n");
                System.out.println("-------YOU WON-------");
                System.out.println("\n");
                System.out.println("------------------------");
            }
            if (playerHealthbar == 0) {
                status = true;
                timer.stop();
                System.out.println("------------------------");
                System.out.println("\n");
                System.out.println("-------GAME OVER-------");
                System.out.println("\n");
                System.out.println("------------------------");
            }

            if(timeRemain == false){
                status = true;
                System.out.println("------------------------");
                System.out.println("\n");
                System.out.println("-------TIME OUT---------");
                System.out.println("\n");
                System.out.println("------------------------");

            }
        }
    }


    public boolean checkWallCollision(String mat[][], int x, int y, String choice) {
        if (choice.equals("w")) {
            if (mat[x - 1][y].equals("|") || mat[x - 1][y].equals("#")) {
                playerHealthbar--;
                return true;
            }
        }
        if (choice.equals("a")) {
            if (mat[x][y - 1].equals("|") || mat[x][y-1].equals("#") ) {
                playerHealthbar--;
                return true;
            }
        }
        if (choice.equals("d")) {
            if (mat[x][y + 1].equals("|")|| mat[x ][y +1].equals("#")) {
                playerHealthbar--;
                return true;
            }
        }
        if (choice.equals("s")) {
            if (mat[x + 1][y].equals("|")|| mat[x + 1][y].equals("#")) {
                playerHealthbar--;
                return true;
            }
        }


        return false;
    }

    public boolean checkRockCollision(String mat[][], int x, int y, String choice) {
        if (choice.equals("w") ) {
            if (mat[x - 1][y].equals("K")) {
                return true;
            }
        }
        if (choice.equals("a") ) {
            if (mat[x][y - 1].equals("K")) {
                return true;
            }
        }
        if (choice.equals("s") ) {
            if (mat[x + 1][y].equals("K")) {
                return true;
            }
        }
            if (choice.equals("d")) {
                if (mat[x][y + 1].equals("K")) {
                    return true;
                }
            }

            return false;

        }



}

