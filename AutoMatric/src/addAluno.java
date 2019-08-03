import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.opencsv.CSVWriter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;


public class addAluno extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField ra;
    private JTextField cr;
    private JTextField CP1;
    private JTextField CP2;
    private JTextField CP3;
    private ButtonGroup posBI = new ButtonGroup();

    public addAluno() {
        ArrayList agenda = new ArrayList();
        agenda.add("a");
        agenda.add("b");
        setTitle("Adicionar Aluno");
        setResizable(false);
        setForeground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 500, 350);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel alunoLabel = new JLabel("Aluno");
        alunoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        alunoLabel.setBounds(25, 13, 56, 16);
        contentPanel.add(alunoLabel);
        
        JLabel raLabel = new JLabel("RA");
        raLabel.setBounds(25, 41, 56, 16);
        contentPanel.add(raLabel);
        
        ra = new JTextField();
        ra.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(ra.getText().equals("Digite aqui...")) ra.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(ra.getText().equals("")) ra.setText("Digite aqui...");
            }
        });
        ra.setText("Digite aqui...");
        ra.getText();
        ra.setBounds(48, 38, 116, 22);
        contentPanel.add(ra);
        ra.setColumns(10);
        
        JLabel crLabel = new JLabel("CR ");
        crLabel.setBounds(25, 70, 56, 16);
        contentPanel.add(crLabel);
        
        cr = new JTextField();
        cr.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(cr.getText().equals("Digite aqui...")) cr.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(cr.getText().equals("")) cr.setText("Digite aqui...");
            }
        });
        cr.setText("Digite aqui...");
        cr.getText();
        cr.setBounds(48, 67, 116, 22);
        contentPanel.add(cr);
        cr.setColumns(10);
        
        JLabel turnoLabel = new JLabel("Turno");
        turnoLabel.setBounds(236, 41, 56, 16);
        contentPanel.add(turnoLabel);
        
        final JComboBox turnoBox = new JComboBox();
        turnoBox.setBackground(SystemColor.inactiveCaptionBorder);
        turnoBox.setModel(new DefaultComboBoxModel(new String[] {"Diurno", "Noturno"}));
        turnoBox.setBounds(285, 38, 116, 22);
        contentPanel.add(turnoBox);
        
        JLabel biLabel = new JLabel("BI");
        biLabel.setBounds(236, 70, 56, 16);
        contentPanel.add(biLabel);
        
        final JComboBox biBox = new JComboBox();
        biBox.setBackground(SystemColor.inactiveCaptionBorder);
        biBox.setModel(new DefaultComboBoxModel(new String[] {"BCT", "BCH"}));
        biBox.setBounds(285, 70, 116, 22);
        contentPanel.add(biBox);
        
        JLabel posbiLabel = new JLabel("Pos Bacharelado");
        posbiLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        posbiLabel.setBounds(25, 144, 139, 16);
        contentPanel.add(posbiLabel);
        
        final JRadioButton naobirb = new JRadioButton("Nao");        
        naobirb.setBounds(250, 139, 56, 23);
        contentPanel.add(naobirb);
        
        final JRadioButton simbirb = new JRadioButton("Sim");
        simbirb.setBounds(170, 139, 56, 23);
        contentPanel.add(simbirb);   
        
        posBI.add(simbirb);
        posBI.add(naobirb);
       
        JLabel umLabel = new JLabel("1. ");
        umLabel.setBounds(25, 173, 56, 16);
        contentPanel.add(umLabel);
        
        JLabel doisLabel = new JLabel("2.");
        doisLabel.setBounds(25, 202, 56, 16);
        contentPanel.add(doisLabel);
        
        JLabel tresLabel = new JLabel("3. ");
        tresLabel.setBounds(25, 231, 56, 16);
        contentPanel.add(tresLabel);
        
        final JComboBox curso1Box = new JComboBox();
        curso1Box.setBackground(SystemColor.inactiveCaptionBorder);
        curso1Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ciencia da Computacao", "Engenharia de Informacao"}));
        curso1Box.setBounds(48, 170, 353, 22);
        contentPanel.add(curso1Box);
        
        final JComboBox curso2Box = new JComboBox();
        curso2Box.setBackground(SystemColor.inactiveCaptionBorder);
        curso2Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ciencia da Computacao", "Engenharia de Informacao"}));
        curso2Box.setBounds(48, 199, 353, 22);
        contentPanel.add(curso2Box);
        
        final JComboBox curso3Box = new JComboBox();
        curso3Box.setBackground(SystemColor.inactiveCaptionBorder);
        curso3Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ciencia da Computacao", "Engenharia de Informacao"}));
        curso3Box.setBounds(48, 228, 353, 22);
        contentPanel.add(curso3Box);
        
        JLabel cpLabel = new JLabel("CP");
        cpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpLabel.setBounds(418, 142, 56, 16);
        contentPanel.add(cpLabel);
        
        CP1 = new JTextField();
        CP1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(CP1.getText().equals("Digite aqui...")) CP1.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(CP1.getText().equals("")) CP1.setText("Digite aqui...");
            }
        });
        CP1.setText("Digite aqui..."); 
        CP1.getText();
        CP1.setColumns(10);
        CP1.setBounds(409, 170, 74, 22);
        contentPanel.add(CP1);     
        
        CP2 = new JTextField();
        CP2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(CP2.getText().equals("Digite aqui...")) CP2.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(CP2.getText().equals("")) CP2.setText("Digite aqui...");
            }
        });
        CP2.setText("Digite aqui...");
        CP2.getText();
        CP2.setColumns(10);
        CP2.setBounds(409, 199, 74, 22);
        contentPanel.add(CP2);
        
        CP3 = new JTextField();
        CP3.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(CP3.getText().equals("Digite aqui...")) CP3.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(CP3.getText().equals("")) CP3.setText("Digite aqui...");
            }
        });
        CP3.setText("Digite aqui...");
        CP3.setColumns(10);
        CP3.setBounds(409, 228, 74, 22);
        contentPanel.add(CP3);
       
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                         try {
                             if(ra.getText().equals("Digite aqui...")) {
                                 JOptionPane.showMessageDialog(null, "RA nao digitado!");
                             }
                             else if(cr.getText().equals("Digite aqui...")) {
                                 JOptionPane.showMessageDialog(null, "CP nao digitado!");
                             }
                             else if(!simbirb.isSelected() && !naobirb.isSelected()) {
                                 JOptionPane.showMessageDialog(null, "Aluno possui pos bacharelado?");
                             }
                             else if(!curso1Box.getSelectedItem().toString().equals("-") &&  CP1.getText().equals("Digite aqui...")) {
                                 JOptionPane.showMessageDialog(null, "CP do curso 1 esta faltando!");
                             }
                             else if(!curso2Box.getSelectedItem().toString().equals("-") &&  CP2.getText().equals("Digite aqui...")) {
                                 JOptionPane.showMessageDialog(null, "CP do curso 2 esta faltando!");
                             }
                             else if(!curso3Box.getSelectedItem().toString().equals("-") &&  CP3.getText().equals("Digite aqui...")) {
                                 JOptionPane.showMessageDialog(null, "CP do curso 3 esta faltando!");
                             }
                             else {
                                 String[] aluno = new String[11];
                                 aluno[0] = ra.getText();
                                 aluno[1] = cr.getText();
                                 aluno[2] = turnoBox.getSelectedItem().toString();
                                 aluno[3] = biBox.getSelectedItem().toString();
                                 if(simbirb.isSelected()) aluno[4] = "true";
                                 else aluno[4] = "false";
                                 aluno[5] = curso1Box.getSelectedItem().toString();
                                 if(aluno[5].equals("-")) aluno[6] = "0";
                                 else aluno[6] = CP1.getText();;
                                 aluno[7] = curso1Box.getSelectedItem().toString();
                                 if(aluno[7].equals("-")) aluno[8] = "0";
                                 else aluno[8] = CP2.getText();
                                 aluno[9] = curso1Box.getSelectedItem().toString();
                                 if(aluno[9].equals("-")) aluno[10] = "0";
                                 else aluno[10] = CP3.getText();;
                                 
                                 CSVWriter escr = new CSVWriter(new FileWriter(menu.getCsvAluno(), true));
                                 escr.writeNext(aluno);
                                 escr.close();
                                 JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
                                 new menu().setVisible(true);
                                 dispose();
                             }
                         }
                         catch(IOException ex) {
                             JOptionPane.showMessageDialog(null, "Erro na escrita do arquivo!");
                         }
                         catch(NullPointerException e) {
                             JOptionPane.showMessageDialog(null, "Arquivo do Banco de Alunos nao selecionado!");
                         }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        new menu().setVisible(true);
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
        //icone do programa
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        //centralizar
        setLocationRelativeTo(null);
    }
}