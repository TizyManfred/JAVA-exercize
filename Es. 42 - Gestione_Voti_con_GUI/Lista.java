import javax.swing.*;

public class Lista extends JFrame {
    private JList<String> stud;
    private JPanel pnlPanel;
    private JButton btnExit;
    private JList lstStudenti;
    private DefaultListModel listModel;
    public Lista(String[] el) {
        //create the model and add elements
        listModel = new DefaultListModel();
        for(int i = 0;i < el.length;i++) {
            listModel.addElement(el[i] + " | Indice: " + (i + 1));
        }


        lstStudenti.setModel(listModel);
        setContentPane(pnlPanel);
        setTitle("( . Y . )");
        setSize(400,400);
        setVisible(true);
    }

    public JButton getBtnExit() {
        return btnExit;
    }
}
