/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guanv6321
 */
public class Dalek {
    // instance variables for row, col, crashed, and captured
    private int row;
    private int col;
    private boolean crashed;
    private boolean captured;

    // initializing dalek's location
    public Dalek(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void advancedTowards(Doctor doc) {
        // variables for doctor's location
        int row = doc.getRow();
        int col = doc.getCol();
        
        // variable for difference between doctor and dalek's location
        int rowM = this.row - row;
        int colM = this.col - col;
        
        // if dalek did not crash and doctor did not get acptured
        if(!crashed && !captured){
            // movement of dalek towards doctor
            if(rowM <= 0){
                this.row++;
            }
            if(rowM >= 0){
                this.row--;
            }
            if(colM <= 0){
                this.col++;
            }
            if(colM >= 0){
                this.col--;
            }
        }            
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
    
    public void crash(){
        this.crashed = true;
    }
    
    public void captured(){
        this.captured = true;
    }
    
    public boolean hasCrashed(Dalek d){
        // if dalek crashed another dalek
        if(this.row == d.getRow() && this.col == d.getCol()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean captured(Doctor doc){
        // if dalek captured doctor 
        if(this.row == doc.getRow() && this.col == doc.getCol()){
            return true;
        }else{
            return false;
        }
    }
}
