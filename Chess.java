//Author Name: Kylie Fauquher
//Date: 03/2022

package chessgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Chess {
   public static LinkedList<ChessPiece> ps = new LinkedList<>();
   public static ChessPiece selectedChessPiece = null;

    public static void main(String[] args) throws IOException {
        //This will read the image we are using for our chess pieces and cut them out.
        BufferedImage all = ImageIO.read(new File("INSERT 'piece.png' FILE LOCATION"));
        Image img[] = new Image[12];
        int ind = 0;
        for(int y = 0;y < 400;y += 200){
        for(int x = 0;x < 1200;x += 200){
            img[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH);
            ind++;
        }   
        }
        //All the chess pieces and their position on the board.
        ChessPiece brook1 = new ChessPiece(0, 0, false, "Rook", ps);
        ChessPiece bkinght1 = new ChessPiece(1, 0, false, "Knight", ps);
        ChessPiece bbishop1 = new ChessPiece(2, 0, false, "Bishop", ps);
        ChessPiece bqueen = new ChessPiece(3, 0, false, "Queen", ps);
        ChessPiece bking = new ChessPiece(4, 0, false, "King", ps);
        ChessPiece bbishop2 = new ChessPiece(5, 0, false, "Bishop", ps);
        ChessPiece bkight2 = new ChessPiece(6, 0, false, "Knight", ps);
        ChessPiece brook2 = new ChessPiece(7, 0, false, "Rook", ps);
        ChessPiece bpawn1 = new ChessPiece(1, 1, false, "Pawn", ps);
        ChessPiece bpawn2 = new ChessPiece(2, 1, false, "Pawn", ps);
        ChessPiece bpawn3 = new ChessPiece(3, 1, false, "Pawn", ps);
        ChessPiece bpawn4 = new ChessPiece(4, 1, false, "Pawn", ps);
        ChessPiece bpawn5 = new ChessPiece(5, 1, false, "Pawn", ps);
        ChessPiece bpawn6 = new ChessPiece(6, 1, false, "Pawn", ps);
        ChessPiece bpawn7 = new ChessPiece(7, 1, false, "Pawn", ps);
        ChessPiece bpawn8 = new ChessPiece(0, 1, false, "Pawn", ps);
        
        ChessPiece wrook1 = new ChessPiece(0, 7, true, "Rook", ps);
        ChessPiece wkinght1 = new ChessPiece(1, 7, true, "Knight", ps);
        ChessPiece wbishop1 = new ChessPiece(2, 7, true, "Bishop", ps);
        ChessPiece wqueen = new ChessPiece(3, 7, true, "Queen", ps);
        ChessPiece wking = new ChessPiece(4, 7, true, "King", ps);
        ChessPiece wbishop2 = new ChessPiece(5, 7, true, "Bishop", ps);
        ChessPiece wkight2 = new ChessPiece(6, 7, true, "Knight", ps);
        ChessPiece wrook2 = new ChessPiece(7, 7, true, "Rook", ps);
        ChessPiece wpawn1 = new ChessPiece(1, 6, true, "Pawn", ps);
        ChessPiece wpawn2 = new ChessPiece(2, 6, true, "Pawn", ps);
        ChessPiece wpawn3 = new ChessPiece(3, 6, true, "Pawn", ps);
        ChessPiece wpawn4 = new ChessPiece(4, 6, true, "Pawn", ps);
        ChessPiece wpawn5 = new ChessPiece(5, 6, true, "Pawn", ps);
        ChessPiece wpawn6 = new ChessPiece(6, 6, true, "Pawn", ps);
        ChessPiece wpawn7 = new ChessPiece(7, 6, true, "Pawn", ps);
        ChessPiece wpawn8 = new ChessPiece(0, 6, true, "Pawn", ps);
        
        JFrame frame = new JFrame();
        frame.setBounds(10,10,525,550);
        JPanel panel = new JPanel() {
            
            //This is creating the checkered pattern and colors on the board.
            @Override
            public void paint(Graphics g) {
            boolean LIGHT_GRAY = true;
            //A standard chess board is 8x8, probably don't adjust this.
            for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                if(LIGHT_GRAY) {
                    g.setColor(Color.LIGHT_GRAY);
                }else{
                    g.setColor(Color.DARK_GRAY);
                }
                //Play around with these numbers if you wish to adjust the size of the board to a panel size.
                g.fillRect(x*64, y*64, 64, 64);
                LIGHT_GRAY = !LIGHT_GRAY;
            }
            //Checks the value of white.
            LIGHT_GRAY = !LIGHT_GRAY;
            }
                //This will add our pieces to the board.
                for(ChessPiece p: ps) {
                    int ind = 0;
                    if(p.name.equalsIgnoreCase("King")){
                        ind = 0;
                    }
                    if(p.name.equalsIgnoreCase("Queen")){
                        ind = 1;
                    }
                    if(p.name.equalsIgnoreCase("Bishop")){
                        ind = 2;
                    }
                    if(p.name.equalsIgnoreCase("Knight")){
                        ind = 3;
                    }
                    if(p.name.equalsIgnoreCase("Rook")){
                        ind = 4;
                    }
                    if(p.name.equalsIgnoreCase("Pawn")){
                        ind = 5;
                    }
                    if(!p.isWhite) {
                        ind += 6;                                          
                    }
                    g.drawImage(img[ind], p.x, p.y, this);
                }
            }
    };
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
               if(selectedChessPiece != null){
                   selectedChessPiece.x = e.getX() - 50;
                   selectedChessPiece.y = e.getY() - 50;
                   frame.repaint();
               }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
            
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
               selectedChessPiece = getChessPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedChessPiece.move(e.getX()/64, e.getY()/64);
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }
        });
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
    public static ChessPiece getChessPiece(int x, int y){
        int xp = x/64;
        int yp = y/64;
        
        for(ChessPiece p: ps) {
            if(p.xp == xp && p.yp == yp) {
                return p;
            }
        }
        return null;
         
        
    }
}
