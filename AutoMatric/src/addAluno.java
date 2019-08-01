import java.awt.BorderLayout;
import sistema.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class addAluno extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField ra;
    private JTextField cr;
    private JTextField CP1;
    private JTextField CP2;
    private JTextField CP3;

    public addAluno() {
        setTitle("Adicionar Aluno");
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
        		 ra.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                ra.setText("Digite aqui..."); 
        	}
        });
        ra.setText("Digite aqui...");
        ra.setBounds(48, 38, 116, 22);
        contentPanel.add(ra);
        ra.setColumns(10);
        
        JLabel crLabel = new JLabel("CR ");
        crLabel.setBounds(25, 70, 56, 16);
        contentPanel.add(crLabel);
        
        cr = new JTextField();
        cr.addFocusListener(new FocusAdapter() {
        	public void focusGained(FocusEvent e) {
        		 cr.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                cr.setText("Digite aqui..."); 
        	}
        });
        cr.setText("Digite aqui...");
        cr.setBounds(48, 67, 116, 22);
        contentPanel.add(cr);
        cr.setColumns(10);
        
        JLabel turnoLabel = new JLabel("Turno");
        turnoLabel.setBounds(236, 41, 56, 16);
        contentPanel.add(turnoLabel);
        
        JComboBox turnoBox = new JComboBox();
        turnoBox.setBackground(SystemColor.inactiveCaptionBorder);
        turnoBox.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Noturno"}));
        turnoBox.setBounds(285, 38, 116, 22);
        contentPanel.add(turnoBox);
        
        JLabel biLabel = new JLabel("BI");
        biLabel.setBounds(236, 70, 56, 16);
        contentPanel.add(biLabel);
        
        JComboBox biBox = new JComboBox();
        biBox.setBackground(SystemColor.inactiveCaptionBorder);
        biBox.setModel(new DefaultComboBoxModel(new String[] {"BCT", "BCH"}));
        biBox.setBounds(285, 70, 116, 22);
        contentPanel.add(biBox);
        
        JLabel posbiLabel = new JLabel("P\u00F3s Bacharelado");
        posbiLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        posbiLabel.setBounds(25, 144, 139, 16);
        contentPanel.add(posbiLabel);
        
        JCheckBox simbiCheck = new JCheckBox("Sim");
        simbiCheck.setSelected(true);
        simbiCheck.setBounds(179, 140, 113, 25);
        contentPanel.add(simbiCheck);
        
        JCheckBox naobiCheck = new JCheckBox("N\u00E3o");
        naobiCheck.setBounds(288, 140, 113, 25);
        contentPanel.add(naobiCheck);
        
        JLabel umLabel = new JLabel("1. ");
        umLabel.setBounds(25, 173, 56, 16);
        contentPanel.add(umLabel);
        
        JLabel doisLabel = new JLabel("2.");
        doisLabel.setBounds(25, 202, 56, 16);
        contentPanel.add(doisLabel);
        
        JLabel tresLabel = new JLabel("3. ");
        tresLabel.setBounds(25, 231, 56, 16);
        contentPanel.add(tresLabel);
        
        JComboBox curso1Box = new JComboBox();
        curso1Box.setBackground(SystemColor.inactiveCaptionBorder);
        curso1Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ci\u00EAncia da Computa\u00E7\u00E3o", "Engenharia de Informa\u00E7\u00E3o"}));
        curso1Box.setBounds(48, 170, 353, 22);
        contentPanel.add(curso1Box);
        
        JComboBox curso2Box = new JComboBox();
        curso2Box.setBackground(SystemColor.inactiveCaptionBorder);
        curso2Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ci\u00EAncia da Computa\u00E7\u00E3o", "Engenharia de Informa\u00E7\u00E3o"}));
        curso2Box.setBounds(48, 199, 353, 22);
        contentPanel.add(curso2Box);
        
        JComboBox curso3Box = new JComboBox();
        curso3Box.setEnabled(false);
        curso3Box.setEditable(true);
        curso3Box.setBackground(Color.LIGHT_GRAY);
        curso3Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ci\u00EAncia da Computa\u00E7\u00E3o", "Engenharia de Informa\u00E7\u00E3o"}));
        curso3Box.setBounds(48, 228, 353, 22);
        contentPanel.add(curso3Box);
        
        JLabel cpLabel = new JLabel("CP");
        cpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpLabel.setBounds(418, 142, 56, 16);
        contentPanel.add(cpLabel);
        
        CP1 = new JTextField();       
        CP1.addFocusListener(new FocusAdapter() {
        	public void focusGained(FocusEvent e) {
        		 CP1.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                CP1.setText("Digite aqui..."); 
        	}
        });
        CP1.setText("Digite aqui...");       
        CP1.setColumns(10);
        CP1.setBounds(409, 170, 74, 22);
        contentPanel.add(CP1);     
        
        CP2 = new JTextField();
        CP2.addFocusListener(new FocusAdapter() {
        	public void focusGained(FocusEvent e) {
        		 CP2.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                CP2.setText("Digite aqui..."); 
        	}
        });
        CP2.setText("Digite aqui...");
        CP2.setColumns(10);
        CP2.setBounds(409, 199, 74, 22);
        contentPanel.add(CP2);
        
        CP3 = new JTextField();
        CP3.addFocusListener(new FocusAdapter() {
        	public void focusGained(FocusEvent e) {
        		 CP3.setText(" "); 
        	}
        	public void focusLost(FocusEvent e) {
                CP3.setText("Digite aqui..."); 
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
