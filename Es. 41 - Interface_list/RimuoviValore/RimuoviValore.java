import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RimuoviValore extends JFrame{
    private JPanel pnlRimuovi;
    private JLabel txtTitolo;
    private JTextField scriviPosizione;
    private JButton btnRimuovi;
    private JLabel txtInserisci;

    public RimuoviValore() {
        setContentPane(pnlRimuovi);
        setTitle("Inserisci valori");
        setSize(960,600);
        setLocation(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnRimuovi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainGUI.lista.remove(Integer.parseInt(scriviPosizione.getText()));
                } catch (Exception ex) {
                    Errore err = new Errore(ex.getMessage());
                }
            }
        });
    }
}
