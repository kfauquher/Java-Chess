package chessgame;

import java.util.LinkedList;


public class ChessPiece {
    int xp;
    int yp;
    
    int x;
    int y;
    
    boolean isWhite;
    LinkedList<ChessPiece> ps;
    String name;
    
    //A list of all the pieces.
    public ChessPiece(int xp, int yp, boolean isWhite, String pname, LinkedList<ChessPiece> ps) {
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
        this.isWhite = isWhite;    
        this.ps = ps;
        name = pname;
        ps.add(this);
        
    }
    
    //Moving the pieces, if one piece lands on another enemy piece we remove that piece and replace it with the winner.
    public void move(int xp, int yp) {
        if(Chess.getChessPiece(xp*64, yp*64)!=null){
            if(Chess.getChessPiece(xp*64, yp*64).isWhite!=isWhite){
        Chess.getChessPiece(xp*64, yp*64).remove();
                
            }else{
                  x=this.xp*64;
        y=this.yp*64;
            return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
    }
    public void remove() {
        ps.remove(this);
    }
    
}
