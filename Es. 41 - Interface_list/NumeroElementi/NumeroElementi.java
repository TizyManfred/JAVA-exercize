import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumeroElementi extends  JFrame{
    private JPanel pnlnElementi;
    private JTextField scriviNumElementi;
    private JLabel txtTitolo;
    private JButton btnCalcola;

    public NumeroElementi() {
        setContentPane(pnlnElementi);
        setTitle("Numero elementi");
        setSize(900, 600);
        setLocation(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnCalcola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scriviNumElementi.setText(String.valueOf(MainGUI.lista.nElements()));
            }
        });
    }
}
