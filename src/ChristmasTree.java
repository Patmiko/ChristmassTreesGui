import java.util.Arrays;
import java.util.Random;

public class ChristmasTree {
    static String[][] Map;
    static int[] drawTree(int segments, int size, int positionx){
        int width = 2*size-1+positionx;
        int height = size*segments +1;
        int baseOfTree =size-1+positionx;
        Map = new String[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Map[i][j] = " ";
            }

        }
        // Drawing the segments of the tree using the function
        for (int i =size; i <= segments*size ; i += size) {
            drawBranch(size,baseOfTree,i, "*");
        }
        // Draw the base of the tree
        Map[height-1][baseOfTree] = "\u001B[30m|\u001B[0m";
        printMap();
        return new int[]{width,height};

    }
    static void drawMultipleTrees(int numberOfTrees, int[][] parameters){
        int width = 0;
        int height = 0;
        for (int[] param : parameters){
            if (width < 2*param[1]-1+param[2]){width = 2*param[1]-1+param[2];}
            if (height < param[0]*param[1]+1){height = param[0]*param[1]+1;}
        }

        Map = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Map[i][j] = " ";
            }

        }
        for (int[] tree : parameters) {
            int segments = tree[0];
            int size = tree[1];
            int baseOfTree = size-1+tree[2];
            for (int j =size; j <= segments*size ; j += size) {
                drawBranch(size,baseOfTree,j, "*");
            }
            Map[height-1][baseOfTree] ="\u001B[30m|\u001B[0m";
        }

        printMap();
    }
    static void drawBranch(int height, int varx, int vary, String symbol){
        String[] symbols = new String[7];
        symbols[0] = "\u001B[31m";
        symbols[1]= "\u001B[37m";
        symbols[2] = "\u001B[33m";
        symbols[3]= "\u001B[34m";
        symbols[4] = "\u001B[35m";
        symbols[5] = "\u001B[36m";
        String reset = "\u001B[0m";
        for (int i = vary; i >=vary-height+1 ; i--) {
            for (int j = varx - (vary-i); j <=varx + (vary-i) ; j++) {
                int randNum = new Random().nextInt(0,18);
                if (randNum <= 5){
                    Map[Map.length-i-1][j] = symbols[randNum] + "o" + reset;
                }
                else {
                Map[Map.length-i-1][j] = "\u001B[32m" +symbol + "\u001B[0m";
                }
            }
        }

    }
    static void printMap(){
        // Print out the map which contains coordinates for the tree
        for (String[] segment : Map){
            for (String arg : segment){
                System.out.print(arg);
            }
            System.out.println();
        }
    }
}
