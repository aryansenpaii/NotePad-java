package notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Notepad extends JFrame {

    Notepad(){
        setTitle("Notepad");//set the title of the notepad app
        //creating and setting the application icon
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image icon= notepadIcon.getImage();
        setIconImage(icon);
        
        //creating the menubar 
        JMenuBar menuBar= new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        
        JMenu file= new JMenu("File"); //Creating File menu
        file.setFont(new Font("Aerial",Font.PLAIN, 14)); //setting font size
        //File MENU Options
        JMenuItem newDoc= new JMenuItem("New");
        newDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem open= new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem save= new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem print= new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem exit= new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        //ADDING OPTIONS TO THE FILE MENU
        file.add(newDoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        
        //CREATING EDIT MENU
        JMenu edit= new JMenu("Edit"); //Creating Edit menu
        edit.setFont(new Font("Aerial",Font.PLAIN, 14)); //setting font size
        //Edit MENU Options
        JMenuItem copy= new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem paste= new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem cut= new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem selectAll= new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        
        //ADDING OPTIONS TO THE EDIT MENU
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectAll);
        
        //CREATING HELP MENU
        JMenu helpMenu= new JMenu("Help"); //Creating Help menu
        helpMenu.setFont(new Font("Aerial",Font.PLAIN, 14)); //setting font size
        //HELP MENU OPTIONS
        JMenuItem help= new JMenuItem("Help");
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK)); //setting mnemonics
        //ADDING OPTIONS TO helpMenu
        helpMenu.add(help);
        
        //ADDING TABS TO MENUBAR
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(helpMenu);
        
        
        setJMenuBar(menuBar);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Notepad();
    }
    
}
