package Buratino;

import java.util.Scanner;

public class Investor {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        int coins = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        int days = scanner2.nextInt();
       //System.out.println(coins - field_of_wonderful_differences(coins,days));
        if (field_of_wonderful_differences(coins,days) <= coins && field_of_wonderful_cubes(coins,days) <= coins){
            System.out.println("Буратино, не делай этого");
        }

        if (field_of_wonderful_cubes(coins,days) > field_of_wonderful_differences(coins,days)){
                System.out.println("Поле чудесных кубов выгоднее на " + (field_of_wonderful_cubes(coins,days) - field_of_wonderful_differences(coins,days)));
        }

        if (field_of_wonderful_differences(coins,days) > field_of_wonderful_cubes(coins,days)){
            System.out.println("Поле чудесных разностей выгоднее на " + (field_of_wonderful_differences(coins,days) - field_of_wonderful_cubes(coins,days)));
        }
               System.out.println(field_of_wonderful_cubes(coins, days));
       System.out.println(field_of_wonderful_differences(coins, days));

    }




    public static int field_of_wonderful_cubes(int coins, int days){
        int profit = coins;
        for (int i = 0; i < days; i++){

            String s = Integer.toString(profit);
            int[] arr = new int[s.length()];

            for (int k = s.length() - 1; k >= 0; k--) {
                arr[k] = profit % 10;
                profit /= 10;
            }

            int up = 0;
            for (int j = 0; j < s.length(); j++){
                up += arr[j]*arr[j]*arr[j];

            }
            profit+=up;
        }


        return profit;

    }

    public static int field_of_wonderful_differences(int coins, int days){
        int profit = coins;

        for (int l = 1; l < days; l++) {
            String s = Integer.toString(coins);
            int[] arr = new int[s.length()];

            for (int k = s.length() - 1; k >= 0; k--) {
                arr[k] = profit % 10;
                profit /= 10;
            }


            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {

                    if (arr[j] < arr[j + 1]) {
                        int tmp1 = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp1;
                    }
                }
            }
            String maxs = "";

            for (int g = 0; g < arr.length; g++) {
                maxs += arr[g];
            }


            for (int m = arr.length - 1; m > 0; m--) {
                for (int j = 0; j < m; j++) {

                    if (arr[j] > arr[j + 1]) {
                        int tmp2 = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp2;
                    }
                }
            }
            String mins = "";
            for (int f = 0; f < arr.length; f++) {
                mins += arr[f];
            }


            int max = Integer.valueOf(maxs);
            int min = Integer.valueOf(mins);
            profit = max - min;
        }
        return profit;
    }
}
