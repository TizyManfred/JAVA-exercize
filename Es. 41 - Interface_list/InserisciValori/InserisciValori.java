import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciValori extends JFrame{
    private JPanel pnlInserisci;
    private JButton btnInserisci;
    private JTextField ScriviValore;
    private JLabel txtInserisci;
    private JLabel txtTitolo;

    public InserisciValori() {
        setContentPane(pnlInserisci);
        setTitle("Inserisci valori");
        setSize(960,600);
        setLocation(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnInserisci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.lista.add(Integer.parseInt(ScriviValore.getText()));
            }
        });
    }
}
