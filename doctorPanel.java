import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalDesktopIconUI;
import javax.swing.table.DefaultTableModel;

import java.util.*;
 

public class doctorPanel extends JPanel {
    private medico dataMedico = new medico();
    private JLabel iconLabel;
    private JButton limpiar;
    private JButton buscar;
    private JButton modificar;
    private JButton eliminar;
    private JButton adicionar;
    private JTextField tsearch;
    private String[] tipos ={"Cedula","Codigo"};
    private JButton search;
    private JLabel tipoB; 
    private JComboBox idB; 
    private JLabel res; 
    private ButtonGroup searchGroup;
    private Container c; 
    private JLabel titulo; 
    private JLabel nombre;
    private JTextField tname; 
    private JLabel apellido;
    private JTextField tlastname; 
    private JLabel cedula;
    private JTextField tid; 
    private JLabel add;
    private JTextArea tadd; 
    private JLabel pames;
    private JSpinner tpames;
    private JLabel panos;
    private JSpinner tpanos;
    private JLabel tel;
    private JTextField ttel; 
    private JLabel codigo; 
    private JTextField tcodigo;
    private JLabel especialidad;
    private JComboBox tespecialidad;
    JButton listar;
    JTable table;
    JScrollPane sp_pacientes;    
    DefaultTableModel dtm_paciente;
    String[] columnNames = {"Nombre",
                        "Apellido",
                        "Cedula"};
    Object[][] data;
    ClassLoader cldr = this.getClass().getClassLoader();
    ImageIcon imageIcon1;
    ImageIcon imageIcon2;
    ImageIcon imageIcon3;
    ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clickGeneral(e);
        }
    };
    public doctorPanel(){
        setBackground(Color.blue);
        
        initComponents();

    }
    protected void initComponents() {
        java.net.URL imageURL   = cldr.getResource("iconos/buscando3.gif");
        imageIcon1 = new ImageIcon(imageURL);
        java.net.URL imageURL2   = cldr.getResource("iconos/encontrado2.gif");
         imageIcon2 = new ImageIcon(imageURL2);
        java.net.URL imageURL3   = cldr.getResource("iconos/nosearch2.gif");
        imageIcon3 = new ImageIcon(imageURL3);
    body(); 
    add(mandos());
    add(c);
    enable(false);
    }
    public JPanel mandos(){
        JPanel panelMandos = new JPanel(new FlowLayout());
        titulo = new JLabel("Mantenimento de Pacientes"); 
        titulo.setFont(new Font("Arial", Font.PLAIN, 20)); 
        titulo.setSize(300, 20); 
        titulo.setLocation(50, 10); 
        panelMandos.add(titulo); 
        
        limpiar= new JButton("Limpiar");
        limpiar.setEnabled(false);
        limpiar.addActionListener(buttonListener);
        limpiar.setBounds(50,350,100,30);

        adicionar= new JButton("Adicionar");
        adicionar.setEnabled(false);
        adicionar.addActionListener(buttonListener);
        adicionar.setBounds(170,350,100,30);

        modificar= new JButton("Modificar");
        modificar.setEnabled(false);
        modificar.addActionListener(buttonListener);
        modificar.setBounds(290,350,100,30);

        eliminar= new JButton("Eliminar");
        eliminar.setEnabled(false);
        eliminar.addActionListener(buttonListener);
        eliminar.setBounds(410,350,100,30);

        buscar= new JButton("Volver");
        buscar.addActionListener(buttonListener);
        buscar.setBounds(430,40,100,30);
        buscar.setVisible(false);
        listar= new JButton("Listar");
        listar.addActionListener(buttonListener);
        listar.setBounds(550,40,100,30);

        c.add(limpiar);
        c.add(buscar);
        c.add(adicionar);
        c.add(modificar);
        c.add(eliminar);
        c.add(listar);
        return panelMandos;
    }

    public void body(){
        c = new JPanel(); 
        c.setLayout(null);
        c.setPreferredSize(new Dimension(810, 500)); 
     
       
        ClassLoader cldr = this.getClass().getClassLoader();
         java.net.URL imageURL   = cldr.getResource("iconos/buscando3.gif");
         ImageIcon imageIcon = new ImageIcon(imageURL);
        iconLabel = new JLabel();
        iconLabel.setIcon(imageIcon);
        imageIcon.setImageObserver(iconLabel);
        iconLabel.setBounds(750,0,100,100);
        iconLabel.setVisible(false);
        c.add(iconLabel);
        
      

        JPanel panelsearch = new JPanel();
        panelsearch.setLayout(null);
        panelsearch.setPreferredSize(new Dimension(100, 500));
        Border blackline = BorderFactory.createTitledBorder("Busqueda");
        

        tipoB = new JLabel("Tipo de busqueda"); 
        tipoB.setFont(new Font("Arial", Font.PLAIN, 20)); 
        tipoB.setSize(200, 30); 
        tipoB.setLocation(50, 40); 
        //tipoB.setVisible(false);
        idB = new JComboBox(tipos); 
        idB.setFont(new Font("Arial", Font.PLAIN, 15)); 
        idB.setSize(90, 30); 
        idB.setLocation(220, 40);
        //idB.setVisible(false); 
        tsearch = new JTextField(); 
        tsearch.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tsearch.setSize(100, 30); 
        tsearch.setLocation(320, 40);
        //tsearch.setVisible(false); 
        search = new JButton("buscar");
        search.setLocation(430, 40);
        search.setSize(100, 30);
        //search.setVisible(false);
        search.addActionListener(buttonListener);

        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setForeground(Color.RED);
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
        // search.setBorder(new RoundedBorder(10));
        //ImageIcon icon = createImageIcon("iconos/search-icon.png", "Busqueda");
        //search.setIcon(icon);
        c.add(tipoB);
        c.add(idB);
        c.add(tsearch);
        c.add(search);

        //panelsearch.setLocation(50,150);
        c.add(panelsearch);

        nombre = new JLabel("Nombre"); 
        nombre.setFont(new Font("Arial", Font.PLAIN, 15)); 
        nombre.setBounds(50,100,100,30);
        c.add(nombre);

        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setBounds(150,100,190,30);
        c.add(tname); 

        apellido = new JLabel("Apellido"); 
        apellido.setFont(new Font("Arial", Font.PLAIN, 15)); 
        apellido.setBounds(50,150,100,30);
        c.add(apellido);
        tlastname = new JTextField(); 
        tlastname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tlastname.setBounds(150,150,190,30);
        c.add(tlastname); 

        cedula = new JLabel("Cedula"); 
        cedula.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cedula.setBounds(50,200,100,30);
        c.add(cedula);
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tid.setBounds(150,200,190,30);
        c.add(tid);

        pames = new JLabel("Paciente al mes"); 
        pames.setFont(new Font("Arial", Font.PLAIN, 15)); 
        pames.setBounds(360,100,190,30);
        c.add(pames); 
        tpames = new JSpinner(); 
        tpames.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpames.setBounds(480,100,190,30);
        c.add(tpames);
        
        panos = new JLabel("Pacientes anuales"); 
        panos.setFont(new Font("Arial", Font.PLAIN, 15)); 
        panos.setBounds(360,150,110,30);
        c.add(panos); 
        tpanos = new JSpinner(); 
        tpanos.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpanos.setBounds(480,150,190,30);
        c.add(tpanos);
        
        tel = new JLabel("Telefono"); 
        tel.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tel.setBounds(360,200,100,30);//
        c.add(tel);
        ttel = new JTextField(); 
        ttel.setFont(new Font("Arial", Font.PLAIN, 15)); 
        ttel.setBounds(480,200,190,30);//
        c.add(ttel);


        especialidad = new JLabel("Especialidad"); 
        especialidad.setFont(new Font("Arial", Font.PLAIN, 15)); 
        especialidad.setBounds(50,250,100,30);
        c.add(especialidad); 
        tespecialidad = new JComboBox(); 
        tespecialidad.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tespecialidad.setBounds(150,250,190,30);
        c.add(tespecialidad); 
        getespecialidad();

        codigo = new JLabel("Codigo"); 
        codigo.setFont(new Font("Arial", Font.PLAIN, 15)); 
        codigo.setBounds(50,300,100,30);//
        c.add(codigo);
        tcodigo = new JTextField(); 
        tcodigo.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tcodigo.setBounds(150,300,190,30);//
        c.add(tcodigo);

        add = new JLabel("Direccion"); 
        add.setFont(new Font("Arial", Font.PLAIN, 15)); 
        add.setBounds(360,250,100,30);
        c.add(add); 
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setBounds(480,250,190,75);
        tadd.setLineWrap(true); 
        c.add(tadd); 
        dtm_paciente = new DefaultTableModel();

        table = new JTable(dtm_paciente);
        // table.setLocation(50, 50); 
        // table.setSize(700, 400); 
        sp_pacientes = new JScrollPane(table);
        sp_pacientes.setBounds(50,100,700,400);
        sp_pacientes.setVisible(false);
        c.add(sp_pacientes);
    }

    public void clickGeneral(ActionEvent e) {

        if (e.getSource() == limpiar) { 
            limpiar();
        }else if(e.getSource()==buscar){
            limpiar();
            visible(true);
            tsearch.setText("");
            buscar.setVisible(false);
            sp_pacientes.setVisible(false);
            modificar.setEnabled(false);
            eliminar.setEnabled(false);
            adicionar.setEnabled(false);
            iconLabel.setVisible(false);
            limpiar.setEnabled(false);
            tid.setEnabled(true);
            enable(false);

        }else if(e.getSource() == listar){
            visible(false);
            sp_pacientes.setVisible(true);
            buscar.setVisible(true);
            search.setVisible(false);
            dataMedico.listar(dtm_paciente);

        }else if(e.getSource() == search){
            limpiar();
            System.out.println(tsearch.getText().length());
           if(tsearch.getText().length()>0)
           {    
                enable(true);
                iconLabel.setIcon(imageIcon1); 
                iconLabel.setVisible(true);
                try
                {
                    if (dataMedico.buscar(tsearch.getText(), idB.getSelectedItem().toString()))   
                    {  
                        tname.setText(dataMedico.getNombre());
                        tlastname.setText(dataMedico.getApellido());
                        tid.setText(dataMedico.getCedula());
                        tadd.setText(dataMedico.getDireccion());
                        tpames.setValue(dataMedico.getPames());
                        tpanos.setValue(dataMedico.getPano());
                        ttel.setText(dataMedico.getTelefono());
                        tcodigo.setText(dataMedico.getcodigo());                                  
                        tespecialidad.getModel().setSelectedItem(new ComboItem(dataMedico.getespecodigo(),dataMedico.getespecialidad()));
                        
                        limpiar.setEnabled(true);
                        modificar.setEnabled(true);
                        eliminar.setEnabled(true);
                        adicionar.setEnabled(false);
                        iconLabel.setIcon(imageIcon2); 
                        iconLabel.setVisible(true);
                    }else{
                        limpiar.setEnabled(true);
                        modificar.setEnabled(false);
                        eliminar.setEnabled(false);
                        adicionar.setEnabled(true);
                        iconLabel.setIcon(imageIcon3); 
                        iconLabel.setVisible(true);
                        if(idB.getSelectedItem().equals("Cedula")){
                            tid.setText(tsearch.getText());
                            tsearch.setText("");
                            tid.setEnabled(false);
                        }else{
                            tid.setEnabled(true);
                        }
                        
                       

                    }
                }
                catch(Exception ex)
                { 
                    System.out.println("Error2 "+ex.toString());
                }
           }
           else{
            JOptionPane.showMessageDialog(null, "Campo de busqueda en blanco");
           }
        }else if(e.getSource() == modificar){
            iconLabel.setIcon(imageIcon1); 
            dataMedico.setNombre(tname.getText());
            dataMedico.setApellido(tlastname.getText());
            dataMedico.setCedula(tid.getText());
            dataMedico.setDireccion(tadd.getText());
            dataMedico.setPames(Integer.parseInt(tpames.getValue().toString()));
            dataMedico.setPano(Integer.parseInt(tpanos.getValue().toString()));
            dataMedico.setTelefono(ttel.getText());
            dataMedico.setcodigo(tcodigo.getText());
           var p =(ComboItem)tespecialidad.getModel().getSelectedItem();

           dataMedico.setespecodigo(p.getValue());
           int r =dataMedico.modificar();
           if(r==1)
           {
               iconLabel.setIcon(imageIcon2); 
               JOptionPane.showMessageDialog(null, "Registro modificado");
           }else{
               iconLabel.setIcon(imageIcon3); 
               iconLabel.setVisible(true);
               JOptionPane.showMessageDialog(null, "Registro no modificado");
           }
          
      }else if(e.getSource() == adicionar){
        
        iconLabel.setIcon(imageIcon1); 
        dataMedico.setNombre(tname.getText());
        dataMedico.setApellido(tlastname.getText());
        dataMedico.setCedula(tid.getText());
        dataMedico.setDireccion(tadd.getText());
        dataMedico.setPames(Integer.parseInt(tpames.getValue().toString()));
        dataMedico.setPano(Integer.parseInt(tpanos.getValue().toString()));
        dataMedico.setTelefono(ttel.getText());
        dataMedico.setcodigo(tcodigo.getText());
        var p =(ComboItem)tespecialidad.getModel().getSelectedItem();
        System.out.println(p.getValue());
       dataMedico.setespecodigo(p.getValue());
       int r =dataMedico.adicionar();
       if(r==1)
        {   limpiar();
            limpiar.setEnabled(false);
            modificar.setEnabled(false);
            eliminar.setEnabled(false);
            adicionar.setEnabled(false);
            iconLabel.setIcon(imageIcon2); 
            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        }else{
            iconLabel.setIcon(imageIcon3); 
            iconLabel.setVisible(true);
            JOptionPane.showMessageDialog(null, "Registro no insertado");
        }
      }else if(e.getSource()==eliminar){
        int r =dataMedico.eliminar();
        if(r==1)
        {   limpiar();
            limpiar.setEnabled(false);
            modificar.setEnabled(false);
            eliminar.setEnabled(false);
            adicionar.setEnabled(false);
            iconLabel.setIcon(imageIcon2); 
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
        }else{
            iconLabel.setIcon(imageIcon3); 
            iconLabel.setVisible(true);
            JOptionPane.showMessageDialog(null, "Registro no eliminado");
        }
      }
    }
    protected ImageIcon createImageIcon(String path, String description) 
    {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public Vector<String> getespecialidad(){
        conection con = new conection();
        Vector<String> result = new Vector<String>();
        String sql = "select descripcion, codigo from especialidad";

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = con.OpenConnection();
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                tespecialidad.addItem(new ComboItem(rs.getString("codigo"), rs.getString("descripcion")));
                // result.add(rs.getString("descripcion"));
                System.out.println(rs.getString("descripcion"));
            }
            con.CloseConnection();
        }
        catch(Exception ex)
        { 
            System.out.println("Error2 "+ex.toString());
        }
        return result;
    }

    public void limpiar(){
        String def = ""; 
        tname.setText(def); 
        tlastname.setText(def);
        tid.setText(def);
        tadd.setText(def);
        tpames.setValue(0);
        tpanos.setValue(0);
        tcodigo.setText(def);
        ttel.setText(def); 
        tespecialidad.setSelectedIndex(0);
    }

    public void visible(boolean value){
            tsearch.setVisible(value);
            search.setVisible(value);
            tipoB.setVisible(value); 
            idB.setVisible(value); 
            sp_pacientes.setVisible(value);//****/
            nombre.setVisible(value);
            tname.setVisible(value); 
            apellido.setVisible(value);
            tlastname.setVisible(value);
            cedula.setVisible(value);
            tid.setVisible(value);
            add.setVisible(value);
            tadd.setVisible(value);
            pames.setVisible(value);
            tpames.setVisible(value);
            panos.setVisible(value);
            tpanos.setVisible(value);
            tel.setVisible(value);
            ttel.setVisible(value);
            codigo.setVisible(value);
            tcodigo.setVisible(value);
            especialidad.setVisible(value);
            tespecialidad.setVisible(value);
            iconLabel.setVisible(value);
    }

    public void enable(boolean value){
        tname.setEnabled(value);
        tlastname.setEnabled(value);
        tid.setEnabled(value);
        tadd.setEnabled(value);
        tpames.setEnabled(value);
        tpanos.setEnabled(value);
        ttel.setEnabled(value);
        tcodigo.setEnabled(value);                                         
        tespecialidad.setEnabled(value);
    }

}


