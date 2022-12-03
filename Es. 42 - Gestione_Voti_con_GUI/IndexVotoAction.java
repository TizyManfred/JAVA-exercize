import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexVotoAction extends JFrame {

    private JPanel pnlPanell;
    private JLabel lblInfo;
    private JButton btnConferma;
    private JTextField txtIndex;
    private JTextField txtVoto;
    private JLabel lblIndex;
    private JLabel lblVoto;
    private JLabel lblStupendo;
    private JButton btnExit;

    public IndexVotoAction() {
        setContentPane(pnlPanell);
        setTitle("(-(-_-(-_(-_(-_-)_-)-_-)_-)_-)-)");
        setSize(800, 400);
        setLocation(500, 300);
        setVisible(true);


        btnConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainGui.gestore.inseriscistudente(new Studente(txtIndex.getText(), Double.parseDouble(txtVoto.getText())));
                    lblStupendo.setText("STUPEFACENTE! (⌐ ͡■ ͜ʖ ͡■)");

                }
                catch (Exception er) {
                    Errore err = new Errore(er);
                }

            }


        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();//chiede la scheda
            }
        });
    }

    public JLabel getLblInfo() {
        return lblInfo;
    }

    public JLabel getLblVoto() {
        return lblVoto;
    }

    public JLabel getLblIndex() {
        return lblIndex;
    }

    public JButton getBtnConferma() {
        return btnConferma;
    }

    public JTextField getTxtIndex() {
        return txtIndex;
    }

    public JTextField getTxtVoto() {
        return txtVoto;
    }

    public JLabel getLblStupendo() {
        return lblStupendo;
    }

    public JButton getBtnExit() {
        return btnExit;
    }
}
