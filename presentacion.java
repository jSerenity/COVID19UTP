import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.*;

public class presentacion  extends JPanel{
    private static String[] presentation = { "Universidad Tecnologica de Panama",
    "Facultad de Ing. de Sistemas Computacionales", "Carrera: Desarrollo de Software", "Profesor: Ricardo Chan",
    "Estudiante: Alba Garrido", "Cedula: 7-709-2016", "Grupo: ILS222", "Fecha: 28 de Julio de 2020" };
    presentacion(){
        initComponents();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
    }

    protected void initComponents() {
        int y =0;
        for (final String text : presentation) {
            int x =300-(text.length()*2);
            final JLabel label = new JLabel();
            label.setText(text);
            label.setBounds(x, y * 50, 500, 50);
            add(label);
            y++;
        }
    }
}

