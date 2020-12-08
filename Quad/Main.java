import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("введите список размеров деталей");
        Scanner scanner= new Scanner(System.in);
        String stringScan = scanner.nextLine();
        String[] arrStr = stringScan.split(" ");
        int[] arr = new int[arrStr.length];
        int num=0;
        for (int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
            num ++;
        }
        System.out.println(num);
        int result=0;

        while (num>0){
            for (int i=0; i<arr.length; i++){
                if (arr[i]==4){
                    result++;
                    num--;
                    continue;
                }
                for (int j=0; j<arr.length; j++){
                    if(arr[i]+arr[j]==4){
                        arr[i]=0;
                        arr[j]=0;
                        result++;
                        num-=2;
                        i=0;
                        j=0;
                    }
                }
            }
        }
        result = result/4;
        System.out.println(result);
    }
}
