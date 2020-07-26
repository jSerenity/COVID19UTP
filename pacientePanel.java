import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.util.*;
 

public class pacientePanel extends JPanel {
    private JButton limpiar;
    JButton buscar;
    private JTextField tsearch;
    private JButton search;
    private JLabel tipoB; 
    private JComboBox idB; 
 
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
    private JLabel edad;
    private JSpinner tedad;
    private JLabel tel;
    private JTextField ttel; 
    private JLabel sexo; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel provincia;
    private JComboBox tprovincia;
    JButton listar;
    JTable table;
    String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};
    Object[][] data = {
        {"Kathy", "Smith",
         "Snowboarding", new Integer(5), new Boolean(false)},
        {"John", "Doe",
         "Rowing", new Integer(3), new Boolean(true)},
        {"Sue", "Black",
         "Knitting", new Integer(2), new Boolean(false)},
        {"Jane", "White",
         "Speed reading", new Integer(20), new Boolean(true)},
        {"Joe", "Brown",
         "Pool", new Integer(10), new Boolean(false)}
    };
    public pacientePanel(){
        setBackground(Color.YELLOW);
        
        initComponents();

    }
    protected void initComponents() {
  
    body(); 
    add(mandos());
    add(c);
    }
    public JPanel mandos(){
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickGeneral(e);
            }
        };
        JPanel panelMandos = new JPanel(new FlowLayout());
        limpiar= new JButton("limpiar");
        limpiar.setEnabled(false);
        limpiar.addActionListener(buttonListener);
        buscar= new JButton("buscar");
        buscar.addActionListener(buttonListener);
        JButton adicionar= new JButton("adicionar");
        adicionar.setEnabled(false);
        JButton modificar= new JButton("modificar");
        modificar.setEnabled(false);
        JButton eliminar= new JButton("eliminar");
        eliminar.setEnabled(false);
        listar= new JButton("listar");
        listar.addActionListener(buttonListener);
        panelMandos.add(limpiar,BorderLayout.WEST);
        panelMandos.add(buscar,BorderLayout.WEST);
        panelMandos.add(adicionar,BorderLayout.WEST);
        panelMandos.add(modificar,BorderLayout.WEST);
        panelMandos.add(eliminar,BorderLayout.WEST);
        panelMandos.add(listar,BorderLayout.WEST);
        return panelMandos;
    }

    public void body(){
        c = new JPanel(); 
        c.setLayout(null);
       
        c.setPreferredSize(new Dimension(650, 500)); 
        titulo = new JLabel("Pacientes"); 
        titulo.setFont(new Font("Arial", Font.PLAIN, 20)); 
        titulo.setSize(300, 20); 
        titulo.setLocation(50, 10); 
        c.add(titulo); 

        JPanel panelsearch = new JPanel();
        panelsearch.setLayout(null);
        panelsearch.setPreferredSize(new Dimension(100, 500));
        Border blackline = BorderFactory.createTitledBorder("Busqueda");
        

        tipoB = new JLabel("Tipo de busqueda"); 
        tipoB.setFont(new Font("Arial", Font.PLAIN, 20)); 
        tipoB.setSize(200, 20); 
        tipoB.setLocation(50, 50); 
        tipoB.setVisible(false);
        idB = new JComboBox(); 
        idB.setFont(new Font("Arial", Font.PLAIN, 15)); 
        idB.setSize(60, 20); 
        idB.setLocation(220, 50);
        idB.setVisible(false); 
        tsearch = new JTextField(); 
        tsearch.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tsearch.setSize(100, 20); 
        tsearch.setLocation(290, 50);
        tsearch.setVisible(false); 
        search = new JButton();
        search.setLocation(400, 40);
        search.setSize(30, 30);
        search.setVisible(false);
        // search.setBorder(new RoundedBorder(10));
        ImageIcon icon = createImageIcon("iconos/search-icon.png",
                                 "Busqueda");
        search.setIcon(icon);
        c.add(tipoB);
        c.add(idB);
        c.add(tsearch);
        c.add(search);

        //panelsearch.setLocation(50,150);
        c.add(panelsearch);

        nombre = new JLabel("Nombre"); 
        nombre.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nombre.setSize(100, 20); 
        nombre.setLocation(50, 100); 
        c.add(nombre);
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(150, 100); 
        c.add(tname); 

        apellido = new JLabel("Apellido"); 
        apellido.setFont(new Font("Arial", Font.PLAIN, 20)); 
        apellido.setSize(100, 20); 
        apellido.setLocation(50, 130); 
        c.add(apellido);
        tlastname = new JTextField(); 
        tlastname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tlastname.setSize(190, 20); 
        tlastname.setLocation(150, 130); 
        c.add(tlastname); 

        cedula = new JLabel("Cedula"); 
        cedula.setFont(new Font("Arial", Font.PLAIN, 20)); 
        cedula.setSize(100, 20); 
        cedula.setLocation(50, 160); 
        c.add(cedula);
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tid.setSize(190, 20); 
        tid.setLocation(150, 160); 
        c.add(tid);

        edad = new JLabel("Edad"); 
        edad.setFont(new Font("Arial", Font.PLAIN, 20)); 
        edad.setSize(190, 20); 
        edad.setLocation(50, 190); 
        c.add(edad); 
        tedad = new JSpinner(); 
        tedad.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tedad.setSize(190, 20); 
        tedad.setLocation(150, 190); 
        c.add(tedad); 
        
        tel = new JLabel("Telefono"); 
        tel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        tel.setSize(100, 20); 
        tel.setLocation(50, 220); 
        c.add(tel);
        ttel = new JTextField(); 
        ttel.setFont(new Font("Arial", Font.PLAIN, 15)); 
        ttel.setSize(190, 20); 
        ttel.setLocation(150, 220); 
        c.add(ttel);

        sexo = new JLabel("Sexo"); 
        sexo.setFont(new Font("Arial", Font.PLAIN, 20)); 
        sexo.setSize(100, 20); 
        sexo.setLocation(50, 250); 
        c.add(sexo); 
        male = new JRadioButton("Hombre"); 
        male.setFont(new Font("Arial", Font.PLAIN, 15)); 
        male.setSelected(true); 
        male.setSize(80, 20); 
        male.setLocation(150, 250); 
        c.add(male); 
        female = new JRadioButton("Mujer"); 
        female.setFont(new Font("Arial", Font.PLAIN, 15)); 
        female.setSelected(false); 
        female.setSize(80, 20); 
        female.setLocation(250, 250); 
        c.add(female); 
        gengp = new ButtonGroup(); 
        gengp.add(male); 
        gengp.add(female); 

        provincia = new JLabel("Provincia"); 
        provincia.setFont(new Font("Arial", Font.PLAIN, 20)); 
        provincia.setSize(100, 20); 
        provincia.setLocation(50, 280); 
        c.add(provincia); 
        tprovincia = new JComboBox(); 
        tprovincia.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tprovincia.setSize(190, 20); 
        tprovincia.setLocation(150, 280); 
        c.add(tprovincia); 

        add = new JLabel("Dirección"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(100, 20); 
        add.setLocation(50, 310); 
        c.add(add); 
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(190, 75); 
        tadd.setLocation(150, 310); 
        tadd.setLineWrap(true); 
        c.add(tadd); 

        table = new JTable(data, columnNames);
        table.setLocation(50, 50); 
        table.setSize(400, 200); 
        table.setVisible(false);
        c.add(table);
    }

    public void clickGeneral(ActionEvent e) {
        System.out.println(e.getSource());
        if (e.getSource() == limpiar) { 
            String def = ""; 
            tname.setText(def); 
            tlastname.setText(def);
            tid.setText(def);
            tadd.setText(def);
            tedad.setValue(0);
            ttel.setText(def); 
            tprovincia.setSelectedIndex(0);
        }else if(e.getSource()==buscar){
            tsearch.setVisible(true);
            search.setVisible(true);
            tipoB.setVisible(true); 
            idB.setVisible(true); 
            table.setVisible(false);
            nombre.setVisible(true);
            tname.setVisible(true); 
            apellido.setVisible(true);
            tlastname.setVisible(true);
            cedula.setVisible(true);
            tid.setVisible(true);
            add.setVisible(true);
            tadd.setVisible(true);
            edad.setVisible(true);
            tedad.setVisible(true);
            tel.setVisible(true);
            ttel.setVisible(true);
            sexo.setVisible(true);
            male.setVisible(true);
            female.setVisible(true);
            provincia.setVisible(true);
            tprovincia.setVisible(true);
        }else if(e.getSource() == listar){
            tsearch.setVisible(false);
            search.setVisible(false);
            tipoB.setVisible(false); 
            idB.setVisible(false); 

            table.setVisible(true);
            nombre.setVisible(false);
            tname.setVisible(false); 
            apellido.setVisible(false);
            tlastname.setVisible(false);
            cedula.setVisible(false);
            tid.setVisible(false);
            add.setVisible(false);
            tadd.setVisible(false);
            edad.setVisible(false);
            tedad.setVisible(false);
            tel.setVisible(false);
            ttel.setVisible(false);
            sexo.setVisible(false);
            male.setVisible(false);
            female.setVisible(false);
            provincia.setVisible(false);
            tprovincia.setVisible(false);
        }

    }
    protected ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}

}