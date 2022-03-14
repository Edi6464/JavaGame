package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import Game.Positioning.*;

import static Game.Player.playerHealthbar;
import static Game.Timer.seconds;

public class Map {



    Map(String mat[][])
    {
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
                mat[i][j]= "|";
    }

    public void print2D(String[][] mat) {
        for (String[] row : mat)
            printRows(row);
        System.out.println("\n");
        System.out.println("Healthbar :" + playerHealthbar);
        System.out.println("Time remaining :"+seconds);
        System.out.println("\n");
        System.out.println("--------------------------------------------------");
    }


    public void printRows(String[] row){
        System.out.print("[   ");
        for(int i=0;i< row.length;i++){
            System.out.print(row[i]+"   ");
        }
        System.out.print("]");
        System.out.println("\n");
    }



    public void generatePath(String[][] mat){
        Random random=new Random();
        int x,y;
        int level= random.nextInt(3);
        switch(level) {
            case 0:
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("src/main/resources/Path2"));
                String line = reader.readLine();
                while (line != null && line != "") {
                    y = Integer.parseInt(line);
                    line = reader.readLine();
                    x = Integer.parseInt(line);
                    mat[x][y] = "©";
                    line = reader.readLine();
                }
                Positioning.setRockXPosition(9);
                Positioning.setRockYPosition(6);
                Positioning.setGateXPosition(7);
                Positioning.setGateYPosition(11);
                Positioning.setQmXPosition(7);
                Positioning.setQmYPosition(13);
                mat[Positioning.getRockXPosition()][Positioning.getRockYPosition()] = "K";
                mat[Positioning.getGateXPosition()][Positioning.getGateYPosition()] = "#";
                mat[Positioning.getQmXPosition()][Positioning.getQmYPosition()] = "?";
                print2D(mat);

            } catch (Exception e) {
                e.printStackTrace();

            }
            break;
            case 1:
                BufferedReader reader2;
                try {
                    reader2 = new BufferedReader(new FileReader("src/main/resources/Path3"));
                    String line = reader2.readLine();
                    while (line != null && line != "") {
                        y = Integer.parseInt(line);
                        line = reader2.readLine();
                        x = Integer.parseInt(line);
                        mat[x][y] = "©";
                        line = reader2.readLine();
                    }
                    Positioning.setRockXPosition(8);
                    Positioning.setRockYPosition(11);
                    Positioning.setGateXPosition(5);
                    Positioning.setGateYPosition(2);
                    Positioning.setQmXPosition(6);
                    Positioning.setQmYPosition(12);
                    mat[Positioning.getRockXPosition()][Positioning.getRockYPosition()] = "K";
                    mat[Positioning.getGateXPosition()][Positioning.getGateYPosition()] = "#";
                    mat[Positioning.getQmXPosition()][Positioning.getQmYPosition()] = "?";
                    print2D(mat);

                } catch (Exception e) {
                    e.printStackTrace();

                }
                break;
            case 2:
                BufferedReader reader3;
                try {
                    reader3 = new BufferedReader(new FileReader("src/main/resources/Path4"));
                    String line = reader3.readLine();
                    while (line != null && line != "") {
                        y = Integer.parseInt(line);
                        line = reader3.readLine();
                        x = Integer.parseInt(line);
                        mat[x][y] = "©";
                        line = reader3.readLine();
                    }
                    Positioning.setRockXPosition(10);
                    Positioning.setRockYPosition(5);
                    Positioning.setGateXPosition(8);
                    Positioning.setGateYPosition(6);
                    Positioning.setQmXPosition(5);
                    Positioning.setQmYPosition(13);
                    mat[Positioning.getRockXPosition()][Positioning.getRockYPosition()] = "K";
                    mat[Positioning.getGateXPosition()][Positioning.getGateYPosition()] = "#";
                    mat[Positioning.getQmXPosition()][Positioning.getQmYPosition()] = "?";
                    print2D(mat);

                } catch (Exception e) {
                    e.printStackTrace();

                }
                break;
        }

    }

}
