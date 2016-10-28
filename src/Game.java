
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
        boolean done = false;
        // create the game board
        Board board = new Board(12, 12);       
        
        
        Doctor doctor = new Doctor((int)(Math.random()*12), (int)(Math.random()*12));
        Dalek dalek1 = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
        Dalek dalek2 = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
        Dalek dalek3 = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
        
        // put a message on the board
        board.displayMessage("Please click the board");

        while (!done) {
            // get a click on the board
            Coordinate click = board.getClick();
                      
            board.removePeg(doctor.getRow(), doctor.getCol());
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            board.removePeg(dalek3.getRow(), dalek3.getCol());

            int row = click.getRow();
            int col = click.getCol();
            
            doctor.move(row, col);
            
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            
            dalek1.advancedTowards(doctor);
            dalek2.advancedTowards(doctor);
            dalek3.advancedTowards(doctor);
                       
            board.putPeg(Color.black, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.black, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.black, dalek3.getRow(), dalek3.getCol());

            
        }
    }
}
