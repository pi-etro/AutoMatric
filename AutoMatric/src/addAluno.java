import java.awt.BorderLayout;
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


public class addAluno extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtRA;
    private JTextField txtCR;
    private JTextField txtCA;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            addAluno dialog = new addAluno();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
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
        
        JLabel lblAluno = new JLabel("Aluno");
        lblAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAluno.setBounds(25, 13, 56, 16);
        contentPanel.add(lblAluno);
        
        JLabel lblRa = new JLabel("RA");
        lblRa.setBounds(25, 41, 56, 16);
        contentPanel.add(lblRa);
        
        txtRA = new JTextField();
        txtRA.setText("Digite aqui...");
        txtRA.setBounds(48, 38, 116, 22);
        contentPanel.add(txtRA);
        txtRA.setColumns(10);
        
        JLabel lblCr = new JLabel("CR ");
        lblCr.setBounds(25, 70, 56, 16);
        contentPanel.add(lblCr);
        
        txtCR = new JTextField();
        txtCR.setText("Digite aqui...");
        txtCR.setBounds(48, 67, 116, 22);
        contentPanel.add(txtCR);
        txtCR.setColumns(10);
        
        JLabel lblTurno = new JLabel("Turno");
        lblTurno.setBounds(236, 41, 56, 16);
        contentPanel.add(lblTurno);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(SystemColor.inactiveCaptionBorder);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Noturno"}));
        comboBox.setBounds(285, 38, 116, 22);
        contentPanel.add(comboBox);
        
        txtCA = new JTextField();
        txtCA.setText("Digite aqui...");
        txtCA.setColumns(10);
        txtCA.setBounds(48, 99, 116, 22);
        contentPanel.add(txtCA);
        
        JLabel lblCa = new JLabel("CA");
        lblCa.setBounds(25, 102, 56, 16);
        contentPanel.add(lblCa);
        
        JLabel lblBi = new JLabel("BI");
        lblBi.setBounds(236, 70, 56, 16);
        contentPanel.add(lblBi);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBackground(SystemColor.inactiveCaptionBorder);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BCT", "BCH"}));
        comboBox_1.setBounds(285, 70, 116, 22);
        contentPanel.add(comboBox_1);
        
        JLabel lblPsBacharelado = new JLabel("P\u00F3s Bacharelado");
        lblPsBacharelado.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPsBacharelado.setBounds(25, 144, 139, 16);
        contentPanel.add(lblPsBacharelado);
        
        JCheckBox chckbxSim = new JCheckBox("Sim");
        chckbxSim.setBounds(179, 140, 113, 25);
        contentPanel.add(chckbxSim);
        
        JCheckBox chckbxNo = new JCheckBox("N\u00E3o");
        chckbxNo.setBounds(288, 140, 113, 25);
        contentPanel.add(chckbxNo);
        
        JLabel label = new JLabel("1. ");
        label.setBounds(25, 173, 56, 16);
        contentPanel.add(label);
        
        JLabel label_1 = new JLabel("2.");
        label_1.setBounds(25, 202, 56, 16);
        contentPanel.add(label_1);
        
        JLabel label_2 = new JLabel("3. ");
        label_2.setBounds(25, 231, 56, 16);
        contentPanel.add(label_2);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBackground(SystemColor.inactiveCaptionBorder);
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Bacharelado em Ci\u00EAncia da Computa\u00E7\u00E3o", "Engenharia de Informa\u00E7\u00E3o"}));
        comboBox_2.setBounds(48, 170, 353, 22);
        contentPanel.add(comboBox_2);
        
        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setBackground(SystemColor.inactiveCaptionBorder);
        comboBox_4.setBounds(48, 228, 353, 22);
        contentPanel.add(comboBox_4);
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setBackground(SystemColor.inactiveCaptionBorder);
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Engenharia da Informa\u00E7\u00E3o ", "Bacharelado em Ci\u00EAncia da Computa\u00E7\u00E3o"}));
        comboBox_3.setBounds(48, 199, 353, 22);
        contentPanel.add(comboBox_3);
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
