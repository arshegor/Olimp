import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("введите день рождения Смауга в формате дд.мм.гггг");
        Scanner scanner1 = new Scanner(System.in);
        String fullDate = scanner1.nextLine();
        String[] arrFD= fullDate.split("\\.");
        int yyyy= Integer.valueOf(arrFD[2]);
        int mm= Integer.valueOf(arrFD[1])-1;
        int dd= Integer.valueOf(arrFD[0]);



        System.out.println("введите число на табло");
        Scanner scanner2 = new Scanner(System.in);
        double secd = scanner2.nextDouble();
        secd= secd/220752000;
        secd = Math.ceil(secd);
        int sec= Integer.valueOf((int) secd);
       // System.out.println(sec);


        Calendar calendar = new GregorianCalendar(yyyy,mm,dd);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String nameDay="";


        dayOfWeek+=sec;
        while (dayOfWeek>7){
            dayOfWeek-=7;
        }

        switch (dayOfWeek) {
            case 2:
                nameDay="Mon";
                break;
            case 3:
                nameDay="Tue";
                break;
            case 4:
                nameDay="Wed";
                break;
            case 5:
                nameDay="Thu";
                break;
            case 6:
                nameDay="Fri";
                break;
            case 7:
                nameDay="Sat";
                break;
            case 1:
                nameDay="Sun";
                break;
        }
        System.out.println(nameDay + dayOfWeek);
    }
}
