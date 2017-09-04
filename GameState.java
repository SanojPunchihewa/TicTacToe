/*	
	Author : Sanoj Punchihewa 	E/14/262
	CO225 Lab3 TicTacToe
*/

public class GameState {

    private int usedBlocks = 0;
    private static Integer matrix[] = new Integer[9];
    private int currentPlayer = 1;
    private final int winningPaths[][] = new int[][]{
                                            {0, 1, 2},
                                            {3, 4, 5},
                                            {6, 7, 8},
                                            {0, 3, 6},
                                            {1, 4, 7},
                                            {2, 5, 8},
                                            {0, 4, 8},
                                            {2, 4, 6}
                                       };

    public GameState(){
        for(int i = 0; i < 9; i++){
            matrix[i] = 0;
        }
        setCurrentPlayer(1);
    }

    public void setMatrixValue(int pos, int value){
        matrix[pos] = value;
        usedBlocks++;
    }

    public int getMatrixValueAt(int pos){
        return matrix[pos];
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isFull(){
        return usedBlocks == 9;
    }

    public int getWinner(){

        for(int i = 0; i < 8; i++){
            if(matrix[winningPaths[i][0]] !=0 && (matrix[winningPaths[i][0]] == matrix[winningPaths[i][1]]) &&
                    (matrix[winningPaths[i][0]] == matrix[winningPaths[i][2]])){
                    return matrix[winningPaths[i][0]];
            }
        }

        return 0;
    }
}
