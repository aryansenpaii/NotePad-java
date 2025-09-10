package notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;
public class Notepad extends JFrame implements ActionListener{
    JTextArea textArea;
    String copiedText;
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
        newDoc.addActionListener(this);
        newDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem open= new JMenuItem("Open");
        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem save= new JMenuItem("Save");
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem print= new JMenuItem("Print");
        print.addActionListener(this);
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem exit= new JMenuItem("Exit");
        exit.addActionListener(this);
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
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem paste= new JMenuItem("Paste");
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem cut= new JMenuItem("Cut");
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); //setting mnemonics
        
        JMenuItem selectAll= new JMenuItem("Select All");
        selectAll.addActionListener(this);
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
        JMenuItem about= new JMenuItem("About");
        about.addActionListener(this);
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK)); //setting mnemonics
        //ADDING OPTIONS TO helpMenu
        helpMenu.add(about);
        
        //ADDING TABS TO MENUBAR
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
        
        //CREATE TEXT AREA
        textArea= new JTextArea();
        textArea.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        textArea.setLineWrap(true);//SETTING WORD-WRAP
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane= new JScrollPane(textArea);//ENABLE SCROLLBAR
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        //RESET THE TEXT EDITOR TO MAKE A NEW FILE
        if(ae.getActionCommand().equals("New")){
            textArea.setText("");
        }
        //OPEN FILES
        else if(ae.getActionCommand().equals("Open")){
            JFileChooser chooser = new JFileChooser();
            //TO ONLY ACCEPT TXT FILES
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");
            chooser.addChoosableFileFilter(restrict);
            //To show open dialog box based on the parent class
            int action = chooser.showOpenDialog(this);
            //what if we didn't choose any file and just close,(go back to parent screen)
            if(action!= JFileChooser.APPROVE_OPTION){
                return;
            }
            //File Handling to read the file
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader= new BufferedReader(new FileReader(file));
                textArea.read(reader,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Save")){
            //SAVE FUNCTIONALITY
            JFileChooser saveAs = new JFileChooser();
            saveAs.setApproveButtonText("Save");
            int action = saveAs.showSaveDialog(this);
            //what if we didn't choose any file and just close,(go back to parent screen)
            if(action!= JFileChooser.APPROVE_OPTION){
                return;
            }
            File fileName= new File(saveAs.getSelectedFile()+".txt");
            BufferedWriter outFile= null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                textArea.write(outFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Print")){
            try {
                textArea.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        else if(ae.getActionCommand().equals("Copy"))
            copiedText= textArea.getSelectedText();
        else if(ae.getActionCommand().equals("Paste"))
            textArea.insert(copiedText, textArea.getCaretPosition());
        else if(ae.getActionCommand().equals("Cut")){
            copiedText = textArea.getSelectedText();
            textArea.replaceRange("", textArea.getSelectionStart(),textArea.getSelectionEnd());
        }else if(ae.getActionCommand().equals("Select All"))
            textArea.selectAll();
        else if(ae.getActionCommand().equals("About")){
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Notepad();
    }
    
}
