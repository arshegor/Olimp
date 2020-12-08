package Labirint;

import java.util.ArrayList;

public class Stepper {
    int x;
    int y;
    boolean b;
    ArrayList<Stepper> list = new ArrayList<>();
    public Stepper(int inx, int iny, boolean inb){
        x = inx;
        y = iny;
        b = inb;
        list.add(this);

    }
}
