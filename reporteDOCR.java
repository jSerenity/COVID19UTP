import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.util.*;

public class reporteDOCR extends JPanel {
    private paciente dataPaciente ;
    private JRadioButton nombre;
    private JRadioButton cedula;
    private JRadioButton edad;
    private ButtonGroup gengp;
    private Container c;
    private JLabel titulo;
    private JButton listar;
    private JTable table;
    private JScrollPane sp_pacientes;
    private DefaultTableModel dtm_paciente;

    ActionListener buttonListener;
    ChangeListener changeListener;

    reporteDOCR() {
        setBackground(Color.BLUE);
        dataPaciente = new paciente();
        dtm_paciente = new DefaultTableModel();
        //dataPaciente.listar(dtm_paciente,"nombre");
        initComponents();

    }

    protected void initComponents() {
        buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickGeneral(e);
            }
        };
        changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onchange(e);
            }
        };

        c = new JPanel(); 
        c.setLayout(null);
        c.setPreferredSize(new Dimension(810, 500));
        add(mandos());

        nombre = new JRadioButton("Apellido"); 
        nombre.setFont(new Font("Arial", Font.PLAIN, 15)); 
        nombre.setSelected(true); 
        nombre.setBounds(50,40,100,30);
        // nombre.addChangeListener(new ChangeListener() {
        //     public void stateChanged(ChangeEvent e) {
        //         onchange(e);
        //     }
        //   });
        c.add(nombre); 
        cedula = new JRadioButton("Cedula"); 
        cedula.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cedula.setSelected(false); 
        cedula.setBounds(150,40,100,30);
        // cedula.addChangeListener(new ChangeListener() {
        //     public void stateChanged(ChangeEvent e) {
        //         onchange(e);
        //     }
        //   });
        c.add(cedula); 
        edad = new JRadioButton("Especialidad"); 
        edad.setFont(new Font("Arial", Font.PLAIN, 15)); 
        edad.setSelected(false); 
        edad.setBounds(250,40,150,30);
        // edad.addChangeListener(new ChangeListener() {
        //     public void stateChanged(ChangeEvent e) {
        //         onchange(e);
        //     }
        //   });
        c.add(edad); 
        gengp = new ButtonGroup(); 
        gengp.add(nombre); 
        gengp.add(cedula); 
        gengp.add(edad); 


        // table = new JTable(dtm_paciente);
        // // table.setLocation(50, 50); 
        // // table.setSize(700, 400); 
        // sp_pacientes = new JScrollPane(table);
        // sp_pacientes.setBounds(50,100,700,400);
        // c.add(sp_pacientes);

        add(c);
        
    }
    public JPanel mandos(){
        JPanel panelMandos = new JPanel(new FlowLayout());
        titulo = new JLabel("Reporte de Medicos"); 
        titulo.setFont(new Font("Arial", Font.PLAIN, 20)); 
        titulo.setSize(300, 20); 
        titulo.setLocation(50, 10); 

        panelMandos.add(titulo); 
        
        listar= new JButton("Crear reporte");
        listar.addActionListener(buttonListener);
        listar.setBounds(400,40,150,30);


        c.add(listar);
        return panelMandos;
    }
    public void clickGeneral(ActionEvent e) {
        String order;
        
        if (e.getSource() == listar) { 
            if(nombre.isSelected()){
                System.out.println("nombre");
                order="apellido";
            }else if(cedula.isSelected()){
                System.out.println("cedula");
                order="cedula";
            }
            else{
                System.out.println("esad");
                order="especialidad";
            }
            reporte(order);
        }
    }

    public void onchange(ChangeEvent e){
       
        if(e.getSource()== nombre)
        {
            System.out.println("nombre");
            dataPaciente.listar(dtm_paciente,"apellido");
        }
        else
        if(e.getSource()== cedula){
            System.out.println("cedula");
            dataPaciente.listar(dtm_paciente,"cedula");
        }
        else
        if(e.getSource()== edad){
            System.out.println("esad");
            dataPaciente.listar(dtm_paciente, "especialidad");
        }
    }
    
        
    public void reporte(String orden)
    {

        try
        {      
            conection db = new conection();   
            db.OpenConnection();  
            // String orden;
            // orden = "nombre";
            Map<String,Object> parametro = new HashMap<String,Object>();
            parametro.put("order",orden);
             //parametro.put("titulo","Listado de Clientes ordenado por "+orden);
            JasperPrint jasperPrint = JasperFillManager.fillReport("R_medicos.jasper",parametro,db.getCon());        
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);

            db.CloseConnection();
        }
        catch(Exception e)
        {
            System.out.println("error "+e.toString());
        }

    }
}
