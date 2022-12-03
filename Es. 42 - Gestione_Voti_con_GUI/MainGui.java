import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
public class MainGui extends JFrame {
    private JPanel pnlPanel;
    private JLabel lblInfo;
    private JLabel lblSfondo0;
    private JLabel lblSfondo00;
    private JLabel lblSfondo1;
    private JLabel lblSfondo2;
    private JLabel lblSfondo3;
    private JLabel lblSfondo4;
    private JButton btnInserisciStud;
    private JButton btnLeggiVoto;
    private JButton btnMedia;
    private JButton btnVotoMax;
    private JButton btnStampaStud;
    private JButton btnEliminaStud;
    private JButton btnModificaStud;
    private JButton btnElenco;
    public static GestoreVoti gestore;

    public MainGui() {
        setContentPane(pnlPanel);
        setTitle("Gestore voti (ㆆ _ ㆆ)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1024, 600);
        setLocation(448, 240);
        setVisible(true);
        gestore = new GestoreVoti(3);



        lblInfo.setText("Scegli tra le seguenti opzioni ( ͡° ͜ʖ ͡°)_/¯");
        lblSfondo0.setText("↓ ↓ ↓ ↓ ↓");
        lblSfondo00.setText("↓ ↓ ↓ ↓ ↓");
        lblSfondo1.setText("ԅ(≖‿≖ԅ)");
        lblSfondo2.setText("☜(⌒▽⌒)☞");
        lblSfondo3.setText("._.)/\\(._.");
        lblSfondo4.setText("\t╰( ͡° ͜ʖ ͡° )つ──☆*:・ﾟ");

        //inserisci studenti
        btnInserisciStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //ti apre la sezione per lo studente
                IndexVotoAction action = new IndexVotoAction();
                action.getLblInfo().setText("Inserisci i dati dello studente! (╯ •̀_•́)╯");
                action.getLblIndex().setText("NOME:");
                action.getLblVoto().setText("VOTO:");
                action.getLblStupendo().setText("");

                action.getBtnConferma().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            gestore.inseriscistudente(new Studente(action.getTxtIndex().getText(), Double.parseDouble(action.getTxtVoto().getText())));
                            action.getLblStupendo().setText("STUPEFACENTE! (⌐ ͡■ ͜ʖ ͡■)");

                        }
                        catch (Exception er) {
                            Errore err = new Errore(er);
                        }

                    }


                });


            }
        });


        //visualizza il voto di uno studente (nome)
        btnLeggiVoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexAction action = new IndexAction();
                action.getLblInfo().setText("Inserisci i dati dello studente! (╯ •̀_•́)╯");
                action.getLblIndex().setText("NOME:");
                action.getLblStupendo().setText("");

                action.getBtnConferma().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            action.getLblStupendo().setText("Il voto è " + gestore.leggiVoto(action.getTxtIndex().getText()));
                        }
                        catch (Exception er) {
                            Errore errore = new Errore(er);
                        }

                    }
                });

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });
            }
        });


        //visualizza media
        btnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputAction action = new OutputAction();
                try {

                    action.getLblStupendo().setText("");
                    action.getLblInfo().setText("La media dei voti è: ");
                    action.getLblStupendo().setText("" + gestore.media());
                }
                catch (Exception er) {
                    action.getLblStupendo().setText("¯\\_( ͡° ͜ʖ ͡°)_/¯");
                    Errore errore = new Errore(er);
                }

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });
            }
        });

        //voto massimo
        btnVotoMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputAction action = new OutputAction();
                try {

                    action.getLblStupendo().setText("");
                    action.getLblInfo().setText("Il voto massimo è: ");
                    action.getLblStupendo().setText("" + gestore.votoMaggiore());
                }
                catch (Exception er) {
                    action.getLblStupendo().setText("¯\\_( ͡° ͜ʖ ͡°)_/¯");
                    Errore errore = new Errore(er);
                }

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });
            }
        });

        //stampa stdente (indice)
        btnStampaStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexAction action = new IndexAction();
                action.getLblInfo().setText("Inserisci l'indice dello studente! (╯ •̀_•́)╯");
                action.getLblIndex().setText("INDICE:");
                action.getLblStupendo().setText("");

                action.getBtnConferma().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            action.getLblStupendo().setText(gestore.stampaStudente(Integer.parseInt(action.getTxtIndex().getText())));
                        }
                        catch (Exception er) {
                            Errore errore = new Errore(er);
                        }

                    }
                });

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });
            }
        });

        //elimina studente
        btnEliminaStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexAction action = new IndexAction();
                action.getLblInfo().setText("Inserisci l'indice dello studente! (╯ •̀_•́)╯");
                action.getLblIndex().setText("INDICE:");
                action.getLblStupendo().setText("");

                action.getBtnConferma().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            gestore.eliminaStudente(Integer.parseInt(action.getTxtIndex().getText()));
                            action.getLblStupendo().setText("STUPEFACENTE! (⌐ ͡■ ͜ʖ ͡■)");
                        }
                        catch (Exception er) {
                            Errore errore = new Errore(er);
                        }

                    }
                });

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });
            }
        });


        //modifica studente (inice - voto)
        btnModificaStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //ti apre la sezione per lo studente
                IndexVotoAction action = new IndexVotoAction();
                action.getLblInfo().setText("Inserisci i dati dello studente! (╯ •̀_•́)╯");
                action.getLblIndex().setText("INDICE:");
                action.getLblVoto().setText("NUOVO VOTO:");
                action.getLblStupendo().setText("");

                action.getBtnConferma().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            gestore.modificastudente(Double.parseDouble(action.getTxtVoto().getText()), Integer.parseInt( action.getTxtIndex().getText()));
                            action.getLblStupendo().setText("STUPEFACENTE! (⌐ ͡■ ͜ʖ ͡■)");

                        }
                        catch (Exception er) {
                            Errore err = new Errore(er);
                        }

                    }


                });

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });
            }
        });

        //lista studenti
        btnElenco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] studenti = new String[gestore.getnStudenti()];
                for(int i = 0;i < studenti.length;i++) {
                    studenti[i] = gestore.getStudenti()[i].toString();
                }
                Lista action = new Lista(studenti);
                /*
                try {
                    action.getLblStupendo().setText("");
                    action.getLblInfo().setText("Studenti: ");

                    //DefaultListModel<String> listModel = new DefaultListModel<>();

                }
                catch (Exception er) {
                    action.getLblStupendo().setText("¯\\_( ͡° ͜ʖ ͡°)_/¯");
                    Errore errore = new Errore(er);
                }

                action.getBtnExit().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        action.dispose();//chiede la scheda
                    }
                });

                 */
            }
        });


    }

    public static void main(String[] args) {
        try {//interfaccia di sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){

        }
        MainGui interfaccia = new MainGui();
    }

}
