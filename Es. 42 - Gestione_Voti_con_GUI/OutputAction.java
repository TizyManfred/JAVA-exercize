import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputAction extends JFrame {
    private JPanel pnlPanell;
    private JLabel lblInfo;
    private JLabel lblStupendo;
    private JButton btnExit;
    private JList list1;

    public OutputAction() {
        setContentPane(pnlPanell);
        setTitle("(-(-_-(-_(-_(-_-)_-)-_-)_-)_-)-)");
        setSize(800, 400);
        setLocation(500, 300);
        setVisible(true);

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


    public JLabel getLblStupendo() {
        return lblStupendo;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

}
