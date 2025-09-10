package notepad;
import java.awt.*;
import javax.swing.*;

public class About extends JFrame {
    About() {
        setTitle("About");
        setBounds(400, 100, 900, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(251,253,254));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Load and scale banner image to fit width
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/banner.png"));
        Image scaledImg = originalIcon.getImage().getScaledInstance(900, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel headerIcon = new JLabel(scaledIcon);
        headerIcon.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerIcon, BorderLayout.NORTH);

        // ✅ Use JLabel with HTML for centered text
        JLabel aboutText = new JLabel(
            "<html><div style='text-align: center; padding: 10px;'>"
          + "<h2>Welcome to <i>Notepad: Slightly Better Edition 🚀</i></h2>"
          + "<b>Features:</b><br>"
          + "• Opens files (most of the time).<br>"
          + "• Closes files (if you're lucky).<br>"
          + "• Crashes only when you REALLY need it.<br>"
          + "• 100% bug-compatible with Windows XP.<br>"
          + "<b>Disclaimer:</b><br>"
          + "This app was powered by Caffeine and questionable Google searches.<br>"
          + "</div></html>"
        );
        aboutText.setFont(new Font("Serif", Font.PLAIN, 16));
        aboutText.setHorizontalAlignment(SwingConstants.CENTER);

        // Scrollable area 
        JScrollPane scrollPane = new JScrollPane(aboutText);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
