/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guanv6321
 */
public class Doctor {
    // instance variables for row and col
    private int row;
    private int col;
    
    // initializing doctor's location
    public Doctor(int row, int col){
        this.row = row;
        this.col = col;     
    }
    
    // method for movement of doctor
    public void move(int newRow, int newCol){
        // variable for random row and col
        int randomRow = (int)(Math.random()*12);
        int randomCol = (int)(Math.random()*12);
        // if difference between current row/col and new row/col is 1 or -1
        if(this.row - newRow <= 1 && this.col - newCol <= 1 && this.row - newRow >= -1 && this.col - newCol >= -1){
            this.row = newRow;
            this.col = newCol;
        }else{
            // new row/col is random
            this.row = randomRow;
            this.col = randomCol;
        }        
               
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
}
