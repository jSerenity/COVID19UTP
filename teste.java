import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class teste {

   public static void main(String[] args) {
      createWindow();
   }

   private static void createWindow() {    
      JFrame frame = new JFrame("Swing Tester");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      createUI(frame);
      frame.setSize(560, 200);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }

   private static void createUI(JFrame frame){
      //Create a border
      Border blackline = BorderFactory.createTitledBorder("Title");
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(null);       

      JPanel panel1 = new JPanel();
      panel.setLayout(null); 
      String spaces = "                   ";

      panel1.add(new JLabel(spaces + "Title border to JPanel" + spaces));  
      panel1.setLocation(0,150);
      panel1.setPreferredSize(new Dimension(500, 500));
      panel1.setBorder(blackline);

      panel.add(panel1);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }
}