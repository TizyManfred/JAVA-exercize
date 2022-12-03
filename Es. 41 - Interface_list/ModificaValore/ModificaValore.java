import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaValore extends JFrame{
    private JPanel pnlModifica;
    private JLabel txtTitolo;
    private JTextField scriviPosizione;
    private JButton btnConferma;
    private JLabel txtPosizione;
    private JLabel txtValore;
    private JTextField scriviValore;


    public ModificaValore() {
        setContentPane(pnlModifica);
        setTitle("Modifica valori");
        setSize(960,600);
        setLocation(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    MainGUI.lista.change(Integer.parseInt(scriviPosizione.getText()),Integer.parseInt(scriviValore.getText()));
                } catch (Exception ex){
                    Errore err = new Errore(ex.getMessage());
                }
            }
        });
    }
}
