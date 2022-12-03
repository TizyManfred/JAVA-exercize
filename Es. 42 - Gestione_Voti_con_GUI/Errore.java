import javax.swing.*;

public class Errore extends JFrame {
    private JPanel pnlPanel;
    private JLabel lblErrore;
    private JLabel lblTestoErrore;

    public Errore(Exception er) {

        setContentPane(pnlPanel);
        setTitle("\tඞ: sus");
        setSize(600, 300);
        setLocation(550, 380);
        setVisible(true);

        lblErrore.setText(" (ノಠ益ಠ)ノ彡┻━┻ Hai fallito!");
        lblTestoErrore.setText(er.getMessage());

    }

}
