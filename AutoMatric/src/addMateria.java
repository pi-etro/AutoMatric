import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class addMateria extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField codigo;
    private JTextField nome;

    public addMateria() {
        setTitle("Adicionar materia");
        setResizable(false);
        setForeground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setAlwaysOnTop(true);
        setBounds(100, 100, 500, 350);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel materiaLabel = new JLabel("Mat\u00E9ria");
        materiaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        materiaLabel.setBounds(12, 13, 56, 16);
        contentPanel.add(materiaLabel);
        
        JLabel codLabel = new JLabel("C\u00F3digo ");
        codLabel.setBounds(12, 42, 56, 16);
        contentPanel.add(codLabel);
        
        codigo = new JTextField();
        codigo.addFocusListener(new FocusAdapter() {
        	public void focusGained(FocusEvent e) {
        		 codigo.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                codigo.setText("Digite aqui..."); 
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
        		 nome.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                nome.setText("Digite aqui..."); 
        	}
        });
        nome.setText("Digite aqui...");
        nome.setColumns(10);
        nome.setBounds(80, 71, 326, 22);
        contentPanel.add(nome);
        
        JLabel obrigLabel = new JLabel("Obrigat\u00F3ria para");
        obrigLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        obrigLabel.setBounds(12, 115, 134, 16);
        contentPanel.add(obrigLabel);
        
        JLabel limitLabel = new JLabel("Limitada para ");
        limitLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        limitLabel.setBounds(12, 157, 108, 16);
        contentPanel.add(limitLabel);
        
        JLabel livreLabel = new JLabel("Livre para ");
        livreLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        livreLabel.setBounds(12, 199, 134, 16);
        contentPanel.add(livreLabel);
        
        JCheckBox obgBct = new JCheckBox("BCT");
        obgBct.setBounds(134, 111, 56, 25);
        contentPanel.add(obgBct);
        
        JCheckBox obgBcc = new JCheckBox("BCC");
        obgBcc.setBounds(194, 111, 56, 25);
        contentPanel.add(obgBcc);
        
        JCheckBox obgInfo = new JCheckBox("INFO");
        obgInfo.setBounds(254, 111, 56, 25);
        contentPanel.add(obgInfo);
        
        JCheckBox limBct = new JCheckBox("BCT");
        limBct.setBounds(134, 153, 56, 25);
        contentPanel.add(limBct);
        
        JCheckBox limBcc = new JCheckBox("BCC");
        limBcc.setBounds(194, 153, 56, 25);
        contentPanel.add(limBcc);
        
        JCheckBox limInfo = new JCheckBox("INFO");
        limInfo.setBounds(254, 153, 56, 25);
        contentPanel.add(limInfo);
        
        JCheckBox livreBct = new JCheckBox("BCT");
        livreBct.setBounds(134, 195, 56, 25);
        contentPanel.add(livreBct);
        
        JCheckBox livreBcc = new JCheckBox("BCC");
        livreBcc.setBounds(194, 195, 56, 25);
        contentPanel.add(livreBcc);
        
        JCheckBox livreInfo = new JCheckBox("INFO");
        livreInfo.setBounds(254, 195, 56, 25);
        contentPanel.add(livreInfo);
        
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        
                        // passar dados ao menu !
                        
                        new menu().setVisible(true);
                        dispose();
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
