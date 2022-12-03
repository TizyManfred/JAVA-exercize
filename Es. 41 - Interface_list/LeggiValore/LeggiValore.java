import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeggiValore extends JFrame{
    private JPanel pnlLeggi;
    private JLabel txtTitolo;
    private JTextField scriviPosizione;
    private JButton btnCerca;
    private JTextField scriviValore;
    private JLabel txtPosizione;
    private JLabel txtValore;

    public LeggiValore() {
        setContentPane(pnlLeggi);
        setTitle("Leggi valore");
        setSize(960,600);
        setLocation(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnCerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    scriviValore.setText(String.valueOf(MainGUI.lista.read(Integer.parseInt(scriviPosizione.getText()))));
                } catch (Exception ex) {
                    Errore err = new Errore(ex.getMessage());
                }
            }
        });
    }
}
