import javax.swing.JFrame;

public class TicTacToeRunner {
    public static void main(String[] args) {
        final int WIDTH = 1480;
        final int HEIGHT = 900;

        //Creation of the window and setting all the pertinent attributes
        JFrame window = new JFrame("Tic Tac Toe");
        window.setResizable(false);
        window.setSize(WIDTH,HEIGHT+35);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        //Creation of the board, the listener and the pieces
        TicTacToe GUI = new TicTacToe(HEIGHT, WIDTH);

        window.add(GUI);
        window.setVisible(true);
    }
}
