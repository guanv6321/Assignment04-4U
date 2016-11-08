
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
        // set condition of game to false
        boolean done = false;
        // create the game board
        Board board = new Board(12, 12);
        // variables for random coordinates 
        int random1 = (int)(Math.random()*12);
        int random2 = (int)(Math.random()*12);
        int random3 = (int)(Math.random()*12);
        int random4 = (int)(Math.random()*12);
        int random5 = (int)(Math.random()*12);
        int random6 = (int)(Math.random()*12);
        int random7 = (int)(Math.random()*12);
        int random8 = (int)(Math.random()*12);
        // randomly set initial position of doctor and daleks
        Doctor doctor = new Doctor(random1, random2);
        Dalek dalek1 = new Dalek(random3, random4);
        Dalek dalek2 = new Dalek(random5, random6);
        Dalek dalek3 = new Dalek(random7, random8);
        // draw the doctor and daleks
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

        // put a message on the board
        board.displayMessage("Please click the board");
        // while game is not done
        while (done == false) {
            // get a click on the board
            Coordinate click = board.getClick();
            // removes the initial position of doctor and daleks
            board.removePeg(doctor.getRow(), doctor.getCol());
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            board.removePeg(dalek3.getRow(), dalek3.getCol());
            // get coordinates for doctor
            int row = click.getRow();
            int col = click.getCol();
            // movement for doctor
            doctor.move(row, col);
            // draws new position of doctor
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            // movement for daleks
            dalek1.advancedTowards(doctor);
            dalek2.advancedTowards(doctor);
            dalek3.advancedTowards(doctor);
            // draws new position of daleks
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
            // if a dalek crashed another dalek
            if(dalek1.hasCrashed(dalek2)){
                dalek1.crash();
                dalek2.crash();
                // draws the site of the crash
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }
            
            if(dalek1.hasCrashed(dalek3)){
                dalek1.crash();
                dalek3.crash();
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            
            if(dalek2.hasCrashed(dalek3)){
                dalek2.crash();
                dalek3.crash();
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            // if a dalek captured the doctor
            if(dalek1.captured(doctor)){
                dalek1.captured();
                // draws the site of the capture
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());         
            }
            
            if(dalek2.captured(doctor)){
                dalek2.captured();
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());              
            }
            
            if(dalek3.captured(doctor)){
                dalek3.captured();
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                
            }
            // if all the daleks crashed
            if(dalek1.hasCrashed(dalek2) && dalek1.hasCrashed(dalek3) && dalek2.hasCrashed(dalek3)){
                // displays the message
                board.displayMessage("You win!");
                // end the game
                done = true;
            }
            // if doctor got captured
            if(dalek1.captured(doctor) || dalek2.captured(doctor) || dalek3.captured(doctor)){
                // display the message
                board.displayMessage("You lose!");
                // end the game
                done = true;
            }
        }
    }
}

