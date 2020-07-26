import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menu extends JPanel{
    private static JPanel iniPanel = new JPanel();
    private static JPanel mantePanel = new JPanel();
    private static JPanel reporPanel = new JPanel();
    JToggleButton inicioMenu = new JToggleButton("INICIO");
    JToggleButton manteMenu = new JToggleButton("MANTENIMIENTO");
    JToggleButton repoMenu = new JToggleButton("REPORTES");
    
    JToggleButton pacienteMButton = new JToggleButton("Pacientes");
    JToggleButton doctoresMButton = new JToggleButton("Doctores");
    JToggleButton pacienteRButton = new JToggleButton("Pacientes");
    JToggleButton doctoresRButton = new JToggleButton("Doctores");
    ActionListener repoListener ;
    ActionListener manteListener ;
    public Garrido_016_ProyFinal parentB;

    menu(Garrido_016_ProyFinal parent){
        parentB=parent;
        setLayout(null);
        setPreferredSize(new Dimension(160, 500));
        initComponents();
        smallMenu();
    }
    protected void initComponents() {
        
         manteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jToggleButtonMenu1ActionPerformed(e);
            }
        };
         repoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jToggleButtonMenu2ActionPerformed(e);
            }
        };
        
        inicioMenu.setPreferredSize(new Dimension(150, 50));
        inicioMenu.setSelected(true); 
        inicioMenu.setName("inicio");
        inicioMenu.addActionListener(parentB);
        iniPanel.add(inicioMenu);
        add(iniPanel);

        pacienteMButton.setName("pacienteM");
        pacienteMButton.setBackground(Color.white);
        pacienteMButton.setBorderPainted(false);
        pacienteMButton.setPreferredSize(new Dimension(150, 40));
        pacienteMButton.addActionListener(parentB);

        
        doctoresMButton.setName("doctoresM");
        doctoresMButton.setBackground(Color.white);
        doctoresMButton.setBorderPainted(false);
        doctoresMButton.setPreferredSize(new Dimension(150, 40));
        doctoresMButton.addActionListener(parentB);


        manteMenu.setPreferredSize(new Dimension(150, 50));
        manteMenu.addActionListener(manteListener);
        mantePanel.add(manteMenu);
        mantePanel.add(pacienteMButton);
        mantePanel.add(doctoresMButton);
        add(mantePanel);

  
        pacienteRButton.setName("pacientesR");
        pacienteRButton.setBackground(Color.white);
        pacienteRButton.setBorderPainted(false);
        pacienteRButton.setPreferredSize(new Dimension(150, 40));
        pacienteRButton.addActionListener(parentB);

        
        doctoresRButton.setName("doctoresR");
        doctoresRButton.setBackground(Color.white);
        doctoresRButton.setBorderPainted(false);
        doctoresRButton.setPreferredSize(new Dimension(150, 40));
        doctoresRButton.addActionListener(parentB);

        repoMenu.setPreferredSize(new Dimension(150, 50));    
        repoMenu.addActionListener(repoListener);
        reporPanel.add(repoMenu);
        reporPanel.add(pacienteRButton);
        reporPanel.add(doctoresRButton);
        add(reporPanel);
        
    }
    private void jToggleButtonMenu1ActionPerformed(ActionEvent evt) {
        if (manteMenu.isSelected()) {
            //Menu 1
            mantePanel.setSize(160, 145);
            //Menu 2
            reporPanel.setLocation(0, 205);
            reporPanel.setSize(160, 60);          
            repoMenu.setSelected(false); 
            inicioMenu.setSelected(false);          
        }
        else {
            smallMenu();
        }
      }
    private void jToggleButtonMenu2ActionPerformed(ActionEvent evt) {                                                  
         if (repoMenu.isSelected()) {
             //Menu 1
             mantePanel.setSize(160, 60);
             manteMenu.setSelected(false);
             inicioMenu.setSelected(false); 
             //Menu 2
             reporPanel.setLocation(0, 120);
             reporPanel.setSize(160, 145); 
         }
         else {
             smallMenu();
         }
      } 
    public void smallMenu() {
        //menu inicio
        iniPanel.setSize(160, 60);
        //Menu 1
        mantePanel.setLocation(0, 60);
        mantePanel.setSize(160, 60);
        manteMenu.setSelected(false); 
        //Menu 2
        reporPanel.setLocation(0, 120);
        reporPanel.setSize(160, 60);           
        repoMenu.setSelected(false);
        
     }
}