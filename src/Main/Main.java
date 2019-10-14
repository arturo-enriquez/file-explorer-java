package Main;

import Frames.Frame;
import Frames.Internal;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
            Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
            insets.right = -1;
            UIManager.put("TabbedPane.contentBorderInsets", insets);
        }catch(Exception ex){
        }
        
        
        Frame frame = new Frame();
        
        frame.setVisible(true);
    }

}
