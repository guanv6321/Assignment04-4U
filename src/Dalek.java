/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guanv6321
 */
public class Dalek {

    private int row;
    private int col;
    private boolean crashed;

    public Dalek(int theRow, int theCol) {
        this.row = row;
        this.col = col;
    }

    public void advancedTowards(Doctor doc) {
        int docRow = doc.getRow();
        int docCol = doc.getCol();
        
        if(crashed==false){
            if(this.row - docRow <= 0){
                this.row++;
            }
            if(this.row - docRow >= 0){
                this.row--;
            }
            if(this.col - docCol <= 0){
                this.col++;
            }
            if(this.col - docCol >= 0){
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
        crashed = true;
    }
    public boolean hasCrashed(Dalek d){
        if(this.row == d.getRow() && this.col == d.getCol()){
            return true;
        }else{
            return false;
        }
    }
    
}
