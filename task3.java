// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга и вывести доску.

public class task3 {
    static int[] chessboard = { 0, 0, 0, 0, 0, 0, 0, 0 };
    static int index = 0;
    static int version = 1;

    public static void printBoard(int[] arr) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[j] == i) {
                    System.out.printf("%s", "|0|");
                } else {
                    System.out.printf("%s", "| |");
                }
            }
            System.out.println();
        }
    }

    public static boolean checking() {
        if (index == 0) {
            return true;
        }

        if (chessboard[index] > 7) {
            chessboard[index] = 0;
            index--;
            return false;
        }

        for (int i = 0; i < index; i++) {
            if ((chessboard[index] == chessboard[i]) | ((Math.abs(chessboard[index] - chessboard[i])) == (index - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        do {
            if (checking()) {
                if (index == 7) {
                    System.out.println("Вариант: " + version++);
                    printBoard(chessboard);
                    chessboard[index]++;
                    break; // можно убрать, тогда будут все варианты
                } else {
                    index++;
                }
            } else {
                chessboard[index]++;
            }
        } while (chessboard[0] < 8);
    }
}