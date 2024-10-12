import java.awt.Image;
import javax.swing.ImageIcon;

public class Piece {
    Image img;

    public Piece(int i){
        if(i == 1){
            img = new ImageIcon(getClass().getResource("/X.png")).getImage();
        } else {
            img = new ImageIcon(getClass().getResource("/O.png")).getImage();
        }
    }

    public Image getImage(){
        return img;
    }
}
