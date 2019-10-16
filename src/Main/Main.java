package Main;

import Frames.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Main {

    public static void main(String[] args) {
        
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
            Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
            insets.right = -1;
            UIManager.put("TabbedPane.contentBorderInsets", insets);
            
            // tooltip
            UIManager.put("ToolTip.background", Color.white);
            UIManager.put("ToolTip.border",new LineBorder(Color.BLACK,1));
        }catch(Exception ex){
        }
        
        
        Frame frame = new Frame();
        Image i = new ImageIcon(ClassLoader.getSystemResource("Imgs/icon.png")).getImage();
        frame.setIconImage(i);
        frame.setVisible(true);
    }

}
