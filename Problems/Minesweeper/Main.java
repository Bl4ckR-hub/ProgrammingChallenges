import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = 1, N = 1;
        Field starting_element = new Field(M, N);

        while (M > 0 && N > 0) {
            M = scanner.nextInt();      //Input m x n
            N = scanner.nextInt();

            Field game = new Field(M,N);
    


            String tmp;
            for (int i = 0; i < M; i++) {
                tmp = scanner.next();
                for (int j = 0; j < N; j++) {
                    game.field[i][j] = tmp.charAt(j);
                }
            }
            putInTheList(starting_element, game);
        }
        scanner.close();
        solveAllGames(starting_element);
        printIntMatrix(starting_element.nextgame);
    }

    private static void printIntMatrix(Field starting_element) {
        System.out.println();
        while (starting_element.nextgame != null) {
            System.out.println("Field #" + starting_element.num + ":");
            for (int i = 0; i < starting_element.solution.length; i++) {
                for (int j = 0; j < starting_element.solution[0].length; j++) {
                    if (starting_element.solution[i][j] < 0)
                        System.out.print("*");
                    else
                        System.out.print(starting_element.solution[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            starting_element = starting_element.nextgame;
        }
    }

    public static void putInTheList(Field starting_element, Field put) {
        while (starting_element.nextgame != null)
            starting_element = starting_element.nextgame;
        starting_element.nextgame = put;
    }

    public static void solveAllGames(Field starting_element) {
        while (starting_element.nextgame != null) {
            starting_element.solveField();
            starting_element = starting_element.nextgame;
        }
        starting_element.solveField();
    }
}
