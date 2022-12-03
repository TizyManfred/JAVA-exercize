import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexAction extends JFrame {
    private JPanel pnlPanell;
    private JButton btnConferma;
    private JLabel lblInfo;
    private JTextField txtIndex;
    private JLabel lblIndex;
    private JLabel lblStupendo;
    private JButton btnExit;

    public IndexAction() {
        setContentPane(pnlPanell);
        setTitle("(-(-_-(-_(-_(-_-)_-)-_-)_-)_-)-)");
        setSize(800, 400);
        setLocation(500, 300);
        setVisible(true);

        btnConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lblStupendo.setText("Il voto è " + MainGui.gestore.leggiVoto(txtIndex.getText()));
                }
                catch (Exception er) {
                    Errore errore = new Errore(er);
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

    public JLabel getLblIndex() {
        return lblIndex;
    }

    public JButton getBtnConferma() {
        return btnConferma;
    }

    public JTextField getTxtIndex() {
        return txtIndex;
    }


    public JLabel getLblStupendo() {
        return lblStupendo;
    }

    public JButton getBtnExit() {
        return btnExit;
    }
}
