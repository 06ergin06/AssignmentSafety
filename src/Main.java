import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int column = scan.nextInt();
        scan.nextLine();
        int safeNumber = 0;
        if (column != 1) {
            for (int j = 0; j < row; j++) {
                String repData = scan.nextLine();
                String repDatUnSpace = repData.replace(" ", "");
                if (repDatUnSpace.charAt(0) == repDatUnSpace.charAt(1)) {
                    safeNumber += Equal(repDatUnSpace, column);
                } else if (repDatUnSpace.charAt(0) > repDatUnSpace.charAt(1) && ((repDatUnSpace.charAt(0) - repDatUnSpace.charAt(1)) <= 3)) {
                    safeNumber += Decrease(repDatUnSpace, column);
                } else if (repDatUnSpace.charAt(0) < repDatUnSpace.charAt(1) && ((repDatUnSpace.charAt(0) - repDatUnSpace.charAt(1)) <= 3)) {
                    safeNumber += Increase(repDatUnSpace, column);
                }
            }
        } else {
            safeNumber = row;
        }
        System.out.println(safeNumber);
    }

    public static int Decrease(String repDatUnSpace, int column) {
        int safety = 0;
        for (int i = 0; i < (column - 1) ; i++) {
            int firstIndex = repDatUnSpace.charAt(i);
            int nextIndex = repDatUnSpace.charAt(i + 1);
            if (firstIndex >= nextIndex && ((firstIndex - nextIndex) <= 3)) {
                if (i == (repDatUnSpace.length() - 2)) {
                    safety++;
                }
            } else {
                break;
            }
        }
        return safety;
    }

    public static int Increase(String repDatUnSpace, int column) {
        int safety = 0;
        for (int i = 0; i < (column - 1); i++) {
            int firstIndex = repDatUnSpace.charAt(i);
            int nextIndex = repDatUnSpace.charAt(i + 1);
            if (firstIndex <= nextIndex && ((nextIndex - firstIndex) <= 3)) {
                if (i == (repDatUnSpace.length() - 2)) {
                    safety++;
                }
            } else {
                break;
            }
        }
        return safety;
    }

    public static int Equal(String repDatUnSpace, int column) {
        int safety = 0;
        for (int i = 0; i < (column - 1); i++) {
            int firstIndex = repDatUnSpace.charAt(i);
            int nextIndex = repDatUnSpace.charAt(i + 1);
            if (firstIndex < nextIndex && ((nextIndex - firstIndex) <= 3)) {
                safety += Increase(repDatUnSpace, column);
                break;
            } else if (firstIndex > nextIndex && ((firstIndex - nextIndex) <= 3)) {
                safety += Decrease(repDatUnSpace, column);
                break;
            } else {
                if (i == (repDatUnSpace.length() - 2) && ((firstIndex - nextIndex) <= 3)) {
                    safety++;
                }
            }
        }
        return safety;
    }
}