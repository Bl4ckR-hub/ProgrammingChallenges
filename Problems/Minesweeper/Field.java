public class Field {
    static int counter = -1; // First Node is always there
    int num;
    char[][] field;
    int[][] solution;
    int M, N;
    Field nextgame;     //Need a linked list for the following games

    public Field(int M, int N) {
        counter++;
        num = counter;
        this.M = M; 
        this.N = N;
        field = new char[M][N];
        solution = new int[M][N];
        nextgame = null;
    }

    public void setInField(int i, int j, char value) {
        field[i][j] = value;
    }

    public void printField() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveField() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] == '*') {
                    solution[i][j] = -1;
                    if (j+1 < N)                    //right
                        if (field[i][j+1] != '*')
                            solution[i][j+1]++;
                    
                    if (j-1 >= 0)                    //left
                        if (field[i][j-1] != '*')
                            solution[i][j-1]++;

                    if (i-1 >= 0) {                  
                        if (field[i-1][j] != '*')
                            solution[i-1][j]++;       //upper

                        if (j-1 >= 0)
                            if (field[i-1][j-1] != '*')     
                                solution[i-1][j-1]++;         //upper-left

                        if (j+1 < N)
                            if (field[i-1][j+1] != '*')
                                solution[i-1][j+1]++;         //upper-right
                    }
                
                    if (i+1 < M) {
                        if (field[i+1][j] != '*')
                            solution[i+1][j]++;               //down

                        if (j+1 < N)
                            if (field[i+1][j+1] != '*')
                                solution[i+1][j+1]++;     //down-right

                        if (j-1 >= 0)
                            if (field[i+1][j-1] != '*')
                                solution[i+1][j-1]++;     //down-left
                    }
                }
            }
        }
    }
}

