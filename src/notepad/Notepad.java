package notepad;
import javax.swing.*;
import java.awt.*;
public class Notepad extends JFrame {

    Notepad(){
        setTitle("Notepad");
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image icon= notepadIcon.getImage();
        setIconImage(icon);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Notepad();
    }
    
}
