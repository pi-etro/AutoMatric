import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.opencsv.CSVWriter;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class addMateria extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField codigo;
    private JTextField nome;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public addMateria() {
        setTitle("Adicionar materia");
        setResizable(false);
        setForeground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 500, 350);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel materiaLabel = new JLabel("Materia");
        materiaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        materiaLabel.setBounds(12, 13, 56, 16);
        contentPanel.add(materiaLabel);
        
        JLabel codLabel = new JLabel("Codigo ");
        codLabel.setBounds(12, 42, 56, 16);
        contentPanel.add(codLabel);
        
        codigo = new JTextField();
        codigo.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(codigo.getText().equals("Digite aqui...")) codigo.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(codigo.getText().equals("")) codigo.setText("Digite aqui...");
            }
        });
        codigo.setText("Digite aqui...");
        codigo.setBounds(80, 39, 80, 22);
        contentPanel.add(codigo);
        codigo.setColumns(10);
        
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(12, 74, 56, 16);
        contentPanel.add(nomeLabel);
        
        nome = new JTextField();
        nome.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(nome.getText().equals("Digite aqui...")) nome.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(nome.getText().equals("")) nome.setText("Digite aqui...");
            }
        });
        nome.setText("Digite aqui...");
        nome.setColumns(10);
        nome.setBounds(80, 71, 326, 22);
        contentPanel.add(nome);
        
        JLabel obrigLabel = new JLabel("BCT");
        obrigLabel.setHorizontalAlignment(SwingConstants.CENTER);
        obrigLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        obrigLabel.setBounds(30, 126, 92, 16);
        contentPanel.add(obrigLabel);
        
        JLabel limitLabel = new JLabel("BCC");
        limitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        limitLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        limitLabel.setBounds(189, 126, 92, 16);
        contentPanel.add(limitLabel);
        
        JLabel livreLabel = new JLabel("Info");
        livreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        livreLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        livreLabel.setBounds(368, 126, 92, 16);
        contentPanel.add(livreLabel);
        
        final JComboBox bctBox = new JComboBox();
        bctBox.setBackground(SystemColor.inactiveCaptionBorder);
        bctBox.setModel(new DefaultComboBoxModel(new String[] {"-", "Obrigatoria", "Limitada", "Livre"}));
        bctBox.setBounds(30, 143, 92, 22);
        contentPanel.add(bctBox);
        
        final JComboBox bccBox = new JComboBox();
        bccBox.setBackground(SystemColor.inactiveCaptionBorder);
        bccBox.setModel(new DefaultComboBoxModel(new String[] {"-", "Obrigatoria", "Limitada", "Livre"}));
        bccBox.setBounds(368, 143, 92, 22);
        contentPanel.add(bccBox);
        
        final JComboBox infoBox = new JComboBox();
        infoBox.setBackground(SystemColor.inactiveCaptionBorder);
        infoBox.setModel(new DefaultComboBoxModel(new String[] {"-", "Obrigatoria", "Limitada", "Livre"}));
        infoBox.setBounds(189, 143, 92, 22);
        contentPanel.add(infoBox);
        
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @SuppressWarnings("deprecation")
                    public void actionPerformed(ActionEvent arg0) {
                        if(bctBox.getSelectedItem().toString().equals("-") || bccBox.getSelectedItem().toString().equals("-")|| infoBox.getSelectedItem().toString().equals("-")) {
                            JOptionPane.showMessageDialog(null, "Indique a relacao da materia com todos os cursos!");
                        }
                        else if(codigo.getText().equals("Digite aqui...")) {
                            JOptionPane.showMessageDialog(null, "Codigo nao digitado!");
                        }
                        else if(nome.getText().equals("Digite aqui...")) {
                            JOptionPane.showMessageDialog(null, "Nome da materia nao digitado!");
                        }
                        else {
                             try {
                                 String[] materia = new String[5];
                                 materia[0] = codigo.getText();
                                 materia[1] = nome.getText();
                                 materia[2] = bctBox.getSelectedItem().toString();
                                 materia[3] = bccBox.getSelectedItem().toString();
                                 materia[4] = infoBox.getSelectedItem().toString();
                                 
                                 CSVWriter escr = new CSVWriter(new FileWriter(menu.getCsvMaterias(), true), ';');
                                 escr.writeNext(materia);
                                 escr.close();
                                 JOptionPane.showMessageDialog(null, "Materia adicionada com sucesso!");
                                 new menu().setVisible(true);
                                 dispose();
                             }
                             catch(IOException ex) {
                                 JOptionPane.showMessageDialog(null, "Erro na escrita do arquivo!");
                             }
                             catch(NullPointerException e) {
                                 JOptionPane.showMessageDialog(null, "Arquivo do Banco de Materias nao selecionado!");
                             }
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