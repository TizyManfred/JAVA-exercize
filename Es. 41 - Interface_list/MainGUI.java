import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private JPanel pnlMenu;
    private JLabel txtTitolo;
    private JButton btnInserisci;
    private JButton btnRimuovi;
    private JButton btnModifica;
    private JButton btnLeggi;
    private JButton btnElementi;
    private JButton btnStampaTutti;
    public static ListArray lista = new ListArray();


    public MainGUI() {
        setContentPane(pnlMenu);
        setTitle("Menù principale");
        setSize(960,600);
        setLocation(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnInserisci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InserisciValori inserisci = new InserisciValori();
            }
        });


        btnModifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaValore modifica = new ModificaValore();
            }
        });


        btnLeggi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeggiValore stampa = new LeggiValore();
            }
        });

        btnRimuovi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RimuoviValore rimuovi = new RimuoviValore();
            }
        });

        btnElementi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NumeroElementi calcola = new NumeroElementi();
            }
        });

        btnStampaTutti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StampaValori stampa = new StampaValori();
            }
        });
    }


    public static void main(String[] args){
        MainGUI interfaccia = new MainGUI();
    }
}
