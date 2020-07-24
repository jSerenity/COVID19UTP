import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** @see http://stackoverflow.com/a/14927280/230513 */
public class teste {

       public static void main(String[] args) {
           EventQueue.invokeLater(new Runnable() {

               @Override
               public void run() {
                   display();
               }
           });
       }

       private static void display() throws HeadlessException {
           JFrame frame = new JFrame("COVID19");
           JButton inicioButton = new JButton("Inicio");
           JButton mantenimeintoButton = new JButton("Mantenimiento");
           JButton reporteButton = new JButton("Reporte");

           //iconPanel settings
           Box iconPanel = new Box(BoxLayout.Y_AXIS);
           iconPanel.add(inicioButton);
           iconPanel.add(mantenimeintoButton);
           iconPanel.add(reporteButton);

           ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /// mover(e.getSource());
            }
        };

           iconPanel.setBackground(Color.gray);
           iconPanel.setVisible(true);
           frame.add(iconPanel, BorderLayout.WEST);

           //grid setting
           JPanel grid = new JPanel() {

               @Override
               // arbitrary placeholder size
               public Dimension getPreferredSize() {
                   return new Dimension(320, 230);
               }
           };
           grid.setBackground(Color.red);
           frame.add(grid, BorderLayout.CENTER);

           //frame setting
           frame.pack();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);

           
       }
       public void mover(Object b) {
           
    }
}