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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class addMateria extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtDigiteAqui;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            addMateria dialog = new addMateria();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public addMateria() {
        setTitle("Adicionar matéria");
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
        
        JLabel lblMatria = new JLabel("Mat\u00E9ria");
        lblMatria.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMatria.setBounds(12, 13, 56, 16);
        contentPanel.add(lblMatria);
        
        JLabel lblCdigo = new JLabel("C\u00F3digo ");
        lblCdigo.setBounds(12, 42, 56, 16);
        contentPanel.add(lblCdigo);
        
        txtDigiteAqui = new JTextField();
        txtDigiteAqui.setText("Digite aqui...");
        txtDigiteAqui.setBounds(80, 39, 80, 22);
        contentPanel.add(txtDigiteAqui);
        txtDigiteAqui.setColumns(10);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(12, 74, 56, 16);
        contentPanel.add(lblNome);
        
        textField = new JTextField();
        textField.setText("Digite aqui...");
        textField.setColumns(10);
        textField.setBounds(80, 71, 326, 22);
        contentPanel.add(textField);
        
        JLabel lblObrigatriaPara = new JLabel("Obrigat\u00F3ria para");
        lblObrigatriaPara.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblObrigatriaPara.setBounds(12, 115, 134, 16);
        contentPanel.add(lblObrigatriaPara);
        
        JCheckBox chckbxBct = new JCheckBox("BCT");
        chckbxBct.setBounds(134, 111, 56, 25);
        contentPanel.add(chckbxBct);
        
        JCheckBox chckbxBcc = new JCheckBox("BCC");
        chckbxBcc.setBounds(194, 111, 56, 25);
        contentPanel.add(chckbxBcc);
        
        JCheckBox chckbxInfo = new JCheckBox("INFO");
        chckbxInfo.setBounds(254, 111, 56, 25);
        contentPanel.add(chckbxInfo);
        
        JLabel lblLimitadaPara = new JLabel("Limitada para ");
        lblLimitadaPara.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLimitadaPara.setBounds(12, 157, 108, 16);
        contentPanel.add(lblLimitadaPara);
        
        JLabel lblLivrePara = new JLabel("Livre para ");
        lblLivrePara.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLivrePara.setBounds(12, 199, 134, 16);
        contentPanel.add(lblLivrePara);
        
        JCheckBox checkBox_3 = new JCheckBox("BCT");
        checkBox_3.setBounds(134, 153, 56, 25);
        contentPanel.add(checkBox_3);
        
        JCheckBox checkBox_4 = new JCheckBox("BCC");
        checkBox_4.setBounds(194, 153, 56, 25);
        contentPanel.add(checkBox_4);
        
        JCheckBox checkBox_5 = new JCheckBox("INFO");
        checkBox_5.setBounds(254, 153, 56, 25);
        contentPanel.add(checkBox_5);
        
        JCheckBox checkBox = new JCheckBox("BCT");
        checkBox.setBounds(134, 195, 56, 25);
        contentPanel.add(checkBox);
        
        JCheckBox checkBox_1 = new JCheckBox("BCC");
        checkBox_1.setBounds(194, 195, 56, 25);
        contentPanel.add(checkBox_1);
        
        JCheckBox checkBox_2 = new JCheckBox("INFO");
        checkBox_2.setBounds(254, 195, 56, 25);
        contentPanel.add(checkBox_2);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                        //fechar janela Marina v1
                        System.exit(0);
                	}
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
        
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        setLocationRelativeTo(null);
    }
}
