import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StampaValori extends JFrame{
    private JPanel pnlStampa;
    private JLabel txtTitolo;
    private JTextField scriviValori;

    public StampaValori() {
        setContentPane(pnlStampa);
        setTitle("Stampa valori");
        setSize(900,600);
        setLocation(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        scriviValori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scriviValori.setText(MainGUI.lista.toString());
            }
        });
    }
}
