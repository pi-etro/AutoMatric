import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class addMateria extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField codigo;
    private JTextField nome;
    private ButtonGroup obrigatorias = new ButtonGroup();
    private ButtonGroup limitadas = new ButtonGroup();
    private ButtonGroup livres = new ButtonGroup();

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
        
        JRadioButton obrigBct = new JRadioButton("BCT");
        obrigBct.setBounds(134, 111, 56, 24);
        contentPanel.add(obrigBct);
        
        JRadioButton obrigBcc = new JRadioButton("BCC");
        obrigBcc.setBounds(194, 111, 56, 24);
        contentPanel.add(obrigBcc);
        
        JRadioButton obrigInfo = new JRadioButton("INFO");
        obrigInfo.setBounds(254, 111, 56, 24);
        contentPanel.add(obrigInfo);
        
        JRadioButton limBct = new JRadioButton("BCT");
        limBct.setBounds(134, 153, 56, 24);
        contentPanel.add(limBct);
        
        JRadioButton limBcc = new JRadioButton("BCC");
        limBcc.setBounds(194, 153, 56, 24);
        contentPanel.add(limBcc);
        
        JRadioButton limInfo = new JRadioButton("INFO");
        limInfo.setBounds(254, 153, 56, 24);
        contentPanel.add(limInfo);
        
        JRadioButton livreBct = new JRadioButton("BCT");
        livreBct.setBounds(134, 195, 56, 24);
        contentPanel.add(livreBct);
        
        JRadioButton livreBcc = new JRadioButton("BCC");
        livreBcc.setBounds(194, 195, 56, 24);
        contentPanel.add(livreBcc);
        
        JRadioButton livreInfo = new JRadioButton("INFO");
        livreInfo.setBounds(254, 195, 56, 24);
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
            
            //adicionar ao ButtonList obrigatoria os radioButton respectivos           
            obrigatorias.add(obrigBct);            
            obrigatorias.add(obrigBcc);           
            obrigatorias.add(obrigInfo);
          //adicionar ao ButtonList limitada os radioButton respectivos
            limitadas.add(limBct);            
            limitadas.add(limBcc);           
            limitadas.add(limInfo);
          //adicionar ao ButtonList livres os radioButton respectivos
            livres.add(livreBct);            
            livres.add(livreBcc);           
            livres.add(livreInfo);
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
