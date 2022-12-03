import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Errore extends JFrame{
    private JPanel pnlErrore;
    private JTextField scriviErrore;
    private JLabel txtErrore;

    public Errore(String er) {
        setContentPane(pnlErrore);
        setTitle("Errore");
        setSize(960,600);
        setLocation(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        scriviErrore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scriviErrore.setText(er);
            }
        });
    }
}
