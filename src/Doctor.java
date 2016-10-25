/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guanv6321
 */
public class Doctor {
    private int row;
    private int col;
    private boolean captured;
      
    public Doctor(int theRow, int theCol){
        this.row = row;
        this.col = col;     
    }
    
    public void move(int newRow, int newCol){
        int randomRow = (int)(Math.random()*12);
        int randomCol = (int)(Math.random()*12);
        if(this.row - row <= 1 && this.col - col <= 1){
            this.row = row;
            this.col = col;
        }else{
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
