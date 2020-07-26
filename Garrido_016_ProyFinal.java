import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;

public class Garrido_016_ProyFinal extends JFrame implements ActionListener {
    public final String PREI = "inicio";
    public final String PAM = "pacienteM";
    public final String DOCM = "doctoresM";
    public final String PAR = "pacientesR";
    public final String DOCR = "doctoresR";

    private final pacientePanel pacientes = new pacientePanel();
    private final doctorPanel doctores = new doctorPanel();
    private final reporteMEPA reportes = new reporteMEPA();
    private final reporteDOCR reporteDocs = new reporteDOCR();
    private final presentacion presentacionPanel = new presentacion();
    private menu menuPanel;
    private final JPanel mainPane = new JPanel();
    private final CardLayout cLayout = new CardLayout();

    public Garrido_016_ProyFinal() {
        super("COVID19...");
        menuPanel = new menu(this);
        initComponents();
        setSize(1000, 600);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
    }

    protected void initComponents() {

        // pacientes.setVisible(false);
        // doctores.setVisible(false);
        // reportes.setVisible(false);
        // presentacionPanel.setVisible(true);

        menuPanel.setVisible(true);
        mainPane.setPreferredSize(new Dimension(250,150));
        mainPane.setLayout(cLayout);

        mainPane.add(PREI, presentacionPanel);
        mainPane.add(DOCM, doctores);
        mainPane.add(PAM, pacientes);
        mainPane.add(PAR, reportes);
        mainPane.add(DOCR, reporteDocs);
        showPrePane();

        add(menuPanel, BorderLayout.WEST);
        // mainPane.add(pacientes, BorderLayout.CENTER);
        // mainPane.add(doctores, BorderLayout.CENTER);
        // mainPane.add(reportes, BorderLayout.CENTER);
        add(mainPane, BorderLayout.CENTER);
    }

    void showPrePane() {
        cLayout.show(mainPane, PREI);
        menuPanel.inicioMenu.setSelected(true);
        menuPanel.smallMenu();
        menuPanel.pacienteMButton.setSelected(false);
        menuPanel.doctoresMButton.setSelected(false);
        menuPanel.pacienteRButton.setSelected(false);
        menuPanel.doctoresRButton.setSelected(false);
    }
    void showPacientePane() {
        cLayout.show(mainPane, PAM);
        menuPanel.pacienteMButton.setSelected(true);
        menuPanel.doctoresMButton.setSelected(false);
        menuPanel.pacienteRButton.setSelected(false);
        menuPanel.doctoresRButton.setSelected(false);
    }

    void showDoctorPane() {
        cLayout.show(mainPane, DOCM);
        menuPanel.pacienteMButton.setSelected(false);
        menuPanel.doctoresMButton.setSelected(true);
        menuPanel.pacienteRButton.setSelected(false);
        menuPanel.doctoresRButton.setSelected(false);
    }
    void showDoctorReportePane() {
        cLayout.show(mainPane, DOCR);
        menuPanel.pacienteMButton.setSelected(false);
        menuPanel.doctoresMButton.setSelected(false);
        menuPanel.pacienteRButton.setSelected(false);
        menuPanel.doctoresRButton.setSelected(true);
    }
    void showPacienteReportePane() {
        cLayout.show(mainPane, PAR);
        menuPanel.pacienteMButton.setSelected(false);
        menuPanel.doctoresMButton.setSelected(false);
        menuPanel.pacienteRButton.setSelected(true);
        menuPanel.doctoresRButton.setSelected(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton botonMenu =(JToggleButton)e.getSource();
        String Name= botonMenu.getName();
        System.out.println(Name);
        switch (Name) {
            case "pacienteM":
            showPacientePane();
            break;
            case "doctoresM":
            showDoctorPane();
            break;
            case "pacientesR":
            showPacienteReportePane();
             break;
            case "doctoresR":
            showDoctorReportePane();
            break;
            case "inicio":
            showPrePane();
            break;
        }
        
    }
}