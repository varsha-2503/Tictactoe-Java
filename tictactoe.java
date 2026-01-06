import java.util.*;
public class tictactoe {

    static String[] board;
    static String turn;

    static String isWinner(){
        for(int i=0;i<8;i++){
            String line = null;
            switch(i){
                case 0:
                    line = board[0]+ board[1]+board[2];
                    break;
                case 1:
                    line = board[3]+ board[4]+board[5];
                    break;
                case 2:
                    line = board[6]+ board[7]+board[8];
                    break;
                case 3:
                    line = board[0]+ board[3]+board[6];
                    break;
                case 4:
                    line = board[1]+ board[4]+board[7];
                    break;
                case 5:
                    line = board[2]+ board[5]+board[8];
                    break;
                case 6:
                    line = board[0]+ board[4]+board[8];
                    break;
                case 7:
                    line = board[2]+ board[4]+board[6];
                    break;
            }

            if(line.equals("XXX")){
                return "X";
            }else if (line.equals("OOO")){
                return "O";
            }
        }
            
            for(int k=0;k<9;k++){
                if(!board[k].equals("X") && !board[k].equals("O")){
                    return null;
                }
            }
            return "draw";
    }

    static void printboard(){
        System.out.println("|---|---|---|");
        System.out.println("| " +  board[0]+ " | " +board[1] + " | " + board[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " +  board[3]+ " | " +board[4] + " | " + board[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " +  board[6]+ " | " +board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");


    }
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    board = new String[9];
    turn = "X";
    for(int i=0;i<9;i++){
        board[i] = String.valueOf(i+1);
    }   

    String winner = null;
    System.out.println("WELCOME TO TIC-TAC-TOE");
    System.out.println("X plays first");
    printboard();

    while(winner==null){
        System.out.println(turn +"'s turn. Enter the no. of block to place "+turn+ " in");

        int block_num;
        try {
            
            block_num=sc.nextInt();
            
            if(block_num>9 || block_num<=0){
                System.out.println("Invalid input\nPlease enter block no. again!!");
                continue;
            }
                if(board[block_num-1].equals(String.valueOf(block_num))){
                    board[block_num-1] = turn;

                turn = turn.equals("X")?"O" : "X";

                printboard();
                winner = isWinner();

                }else{
                    System.out.println("Block already taken");
                    printboard();
                }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input\nEnter block no. again");
                sc.nextLine(); // Consume invalid input to prevent infinite loop
        }
    }

    if(winner.equals("draw")){

        System.out.println("MATCH DRAW!!");
        System.out.println("THANKS FOR PLAYING");
    }else{
        System.out.println(winner+ " WINS!!!");
        System.out.println("Congratulations!!!");
        System.out.println("THANKS FOR PLAYING");
    }
    sc.close();
    }
}

