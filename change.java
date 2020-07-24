import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class change extends JFrame {

    public final String YELLOW_PAGE = "yellow page";
    public final String RED_PAGE = "red page";
    private final CardLayout cLayout;
    private final JPanel mainPane;
    boolean isRedPaneVisible;

    public change(){

        setTitle("Card Layout Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPane = new JPanel();
        mainPane.setPreferredSize(new Dimension(250,150));
        cLayout = new CardLayout();
        mainPane.setLayout(cLayout);

        JPanel yellowPane = new JPanel();
        yellowPane.setBackground(Color.YELLOW);
        JPanel redPane = new JPanel();
        redPane.setBackground(Color.RED);

        mainPane.add(YELLOW_PAGE, yellowPane);
        mainPane.add(RED_PAGE, redPane);
        showPacientePane();

        JButton button = new JButton("Switch Panes");
        button.addActionListener(e -> switchPanes() );

        setLayout(new BorderLayout());
        add(mainPane,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    void switchPanes() {
        if (isRedPaneVisible) {showDoctorPane();}
        else { showPacientePane();}
    }

    void showPacientePane() {
        cLayout.show(mainPane, RED_PAGE);
        isRedPaneVisible = true;
    }

    void showDoctorPane() {
        cLayout.show(mainPane, YELLOW_PAGE);
        isRedPaneVisible = false;
    }

    public static void main(String[] args) {
        new change();
    }
}