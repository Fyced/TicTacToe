import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TicTacToe extends JPanel{
    //Variables of the size of the window
    private int HEIGHT;
    private int WIDTH;

    //Constants of the size of each square
    private final int squareY;
    private final int squareX;

    //Variable that controls if there is a win
    private boolean gameOver = false;

    //Constructor of the class that stores the size values and starts a mouse listener
    public TicTacToe(int height, int width) {

        //Storing the values of the size in their respectives variables
        HEIGHT = height;
        WIDTH = width;
        squareY = HEIGHT/3;
        squareX = WIDTH/3;

        //Creating a listener for the mouse
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!gameOver){
                int x = e.getX();
                int y = e.getY();
                System.out.println("Click en coordenadas: (" + x + ", " + y + ")"); //Get the coordenates of the mouse
                playerSquare(x, y); //Changing the matrix when there is a click
                }
            }
        });
    }

    public int[][] boardMatrix = {{0,0,0},
                                  {0,0,0},   //Matrix that stores the plays by both players
                                  {0,0,0}};

    public int turn = 1;    //Variable that counts the turn
    private int squaresUsed = 0;

    //Method that changes the matrix of the game based on where was the click
    public void playerSquare(int x, int y){
        int i = playerSquareX(x);
        int e = playerSquareY(y);

        if(boardMatrix[e][i] == 0){
            if(turn % 2 != 0){
                boardMatrix[e][i] = 1;
            } else {
                boardMatrix[e][i] = 2;
            }
            squaresUsed++;
        }

        if(squaresUsed == 9){
            squaresUsed = 0;
            for(int r = 0; r < 3; r++){
                for(int t = 0; t < 3; t++){
                    boardMatrix[r][t] = 0;
                }
            }
        }
        repaint();  //Method that repaints the screen after determining where has been clicked in order to paint the piece
        turn++;
        
        if(checkWin(e, i)){
            gameOver = true;
            JOptionPane.showMessageDialog(this, "You won");
        }
    }
    private int playerSquareX(int x){
        if(turn % 2 != 0){
            for(int i = 0; i < 3; i++){
                if(x < squareX * (i+1)){
                    return i;
                }
            }
        } else {
            for(int i = 0; i < 3; i++){
                if(x < squareX * (i+1)){
                    return i;
                }
            }
        }
        return -1;
    }

    private int playerSquareY(int y){
        if(turn % 2 != 0){
            for(int i = 0; i < 3; i++){
                if(y < squareY * (i+1)){
                    return i;
                }
            }
        } else {
            for(int i = 0; i < 3; i++){
                if(y < squareY * (i+1)){
                    return i;
                }
            }
        }
        return -1;
    }

    //Method that paints both the board and the pieces
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Paints the board lines
        for(int i = 1; i < 3; i++){
            g.setColor(Color.black);
            g.drawLine((WIDTH / 3) * i, 0, (WIDTH / 3) * i, HEIGHT);
            g.drawLine(0,(HEIGHT/3)*i, WIDTH, (HEIGHT/3)*i);

        }

        //Paints the pieces
        for(int i = 0; i < 3; i++){
            for(int e = 0; e < 3; e++){
                if(boardMatrix[i][e] == 1){
                Piece imageX = new Piece(1);
                g.drawImage(imageX.getImage(), e*squareX, i*squareY, squareX, squareY, this);
                } else if(boardMatrix[i][e] == 2){
                Piece imageX = new Piece(2);
                g.drawImage(imageX.getImage(), e*squareX, i*squareY, squareX, squareY, this);
                }
            }
        }

    }

    public boolean checkWin(int row, int column){
            if(boardMatrix[row][0] == boardMatrix[row][1] && boardMatrix[row][0]== boardMatrix[row][2]){
                return true;
            }

            if(boardMatrix[0][column] == boardMatrix[1][column] && boardMatrix[0][column]== boardMatrix[2][column]){
                return true;
            }

            if(boardMatrix[1][1] != 0){
                if(boardMatrix[0][0] == boardMatrix[1][1] && boardMatrix[1][1] == boardMatrix[2][2]){
                    return true;
                }
    
                if((boardMatrix[2][0] == boardMatrix[1][1] && boardMatrix[1][1] == boardMatrix[0][2])){
                    return true;
                }
            }
        return false;
    }

}
