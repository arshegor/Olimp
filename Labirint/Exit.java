package Labirint;

import java.util.Arrays;
import java.util.Scanner;

public class Exit {
    public static String[][] splitter(String shifr){
        shifr = shifr.replaceAll(" ", "1");
        shifr = shifr.replaceAll("\\.", "2");
        shifr = shifr.replaceAll("@", "3");
        shifr = shifr.replaceAll("\\*", "4");
        shifr = shifr.replaceAll("\\D", "#");
        shifr = shifr.replaceAll("4", "*");
        shifr = shifr.replaceAll("3", "@");
        shifr = shifr.replaceAll("2", ".");
        shifr = shifr.replaceAll("1", " ");
        String[] first = shifr.split("\\.");

        String[][] second = new String[first.length][17];

        for (int i = 0; i < second.length; i++){
            for (int j = 0; j < second[i].length; j++) {
                char[] chars = first[i].toCharArray();
                
                second[i][j] = String.valueOf(chars[j]);
            }
        }




        return second;
    }

    public static void Plotter(String[][] second){
        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < second[i].length; j++) {
                System.out.print(second[i][j] );
            }
            System.out.println();
        }
    }

    public static String exiter(String str) {
        String result = ">";
        int startX = 1;
        int startY = 1;
        int stepX;
        int stepY;

        String[][] second = splitter(str);
        
        
        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < second[i].length; j++) {
                if (second[i][j].equals("@")) {
                    startX = i;
                    startY = j+1;
                    break;
                }
            }
        }
        stepX = startX;
        stepY = startY;
        Scanner scanner = new Scanner(System.in);
        while (!second[stepX][stepY+1].equals("*")) {

            if (!second[stepX][stepY+1].equals("#") && !second[stepX][stepY].equals("<")){
                second[stepX][stepY] = ">";
                stepY+=1;
                second[stepX][stepY] = ">";
                result+=">";

            }
            else {
                if (!second[stepX - 1][stepY].equals("#") && !second[stepX][stepY].equals("|")) {
                    second[stepX][stepY] = "^";
                    stepX -= 1;
                    second[stepX][stepY] = "^";
                    result+="^";
                } else {
                    if (!second[stepX + 1][stepY].equals("#") && !second[stepX][stepY].equals("^")) {
                        second[stepX][stepY] = "|";
                        stepX += 1;
                        second[stepX][stepY] = "|";
                        result+="|";
                    } else {
                        if (!second[stepX][stepY - 1].equals("#") && !second[stepX][stepY].equals(">")) {
                            second[stepX][stepY] = "<";
                            stepY -= 1;
                            second[stepX][stepY] = "<";
                            result+="<";
                        }


                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shifr = scanner.nextLine();
        System.out.println(exiter(shifr));
    }
}
