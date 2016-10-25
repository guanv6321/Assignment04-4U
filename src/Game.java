
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guanv6321
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12, 12);
        Doctor doctor = new Doctor(0, 0);
        Dalek dalek1 = new Dalek(4,7);
        Dalek dalek2 = new Dalek(1,3);
        Dalek dalek3 = new Dalek(2,6);
        
               
        // put a coloured peg at row, col
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        board.putPeg(Color.YELLOW, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.YELLOW, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.YELLOW, dalek3.getRow(), dalek3.getCol());
        
        // remove the peg at row, col
        
       
        // put a message on the board
        board.displayMessage("Please click the board");

        while (true) {
            // get a click on the board
            Coordinate click = board.getClick();

            int row = click.getRow();
            int col = click.getCol();
                     
            doctor.move(row, col);
            
        }
    }
}
