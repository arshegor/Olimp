package HarryPotter;

import java.util.Scanner;

public class Chess {
    /**
     * размерность доски
     */
    private int dimension;
    /**
     * хранит растоновку ферзей. каждый ферзь находится на отдельной линии, на
     * одной линии находится не могут так как бъют друг друга. Пример: state[3] ==
     * 5; - значит ферзь третей линии находится на пятой позиции.
     */
    private int[] state;
    /**
     * Порядковый номер комбинации
     */
    private int index = 1;
    private int posx ;
    private int posy ;
    /*
     * n - размерность доски и количество ферзей
     */
    public Chess(int n, int x, int y) {
        dimension = n;
        state = new int[n];
        posx = x;
        posy = y;
        // init state
        for (int i = 0; i < state.length; i++) {
            state[i] = 0;
        }
    }

    /*
     * генерирует следующую комбинацию(расстоновку фигур)
     */
    public boolean next() {
        index++;
        return move(dimension - 1);
    }

    /*
     * Двигает фигуру в указаной линии на одну клетку вправо и возвращает true.
     * Если фигура находится в крайнем положении, то фигура устанавливается в
     * первое положение и двигается фигура находящаяся на линии выше и так далее.
     * Если линий выше не осталось возвращает false.
     */
    private boolean move(int index) {
        if (state[index] < dimension - 1) {


            state[index]++;
            return true;
        }

        state[index] = 0;
        if (index == 0) {
            return false;
        } else {
            return move(index - 1);
        }
    }



    public boolean isPeace() {
        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                // бъет ли по вертикали
                if (state[i] == state[j]) {
                    return false;
                }
                // бъет ли по диагонали
                if (Math.abs(i - j) == Math.abs(state[i] - state[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Распечатывает доску с фигурами. Исключительно для наглядности. Чтобы понять
     * как генерируются комбинации.
     */


    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);
        int n = ns.nextInt();
        Scanner coord = new Scanner(System.in);
        String[] s = coord.nextLine().split(" ");
        int x = Integer.valueOf(s[0]);
        int y = Integer.valueOf(s[1]);

        Chess c = new Chess(n, x, y);
        int counter = 0;
        do {
            if (c.isPeace()) {
                counter ++;
            }
        } while (c.next());

        System.out.println("Итого: " + counter);
    }
}