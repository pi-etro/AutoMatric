import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
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
	private static String arquivo = "cadastroAluno.csv";


    public addAluno() {
        setTitle("Adicionar Aluno");
        setResizable(false);
        setDragable(true);
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
        ra.setText("Digite aqui...");
        ra.getText();
        ra.setBounds(48, 38, 116, 22);
        contentPanel.add(ra);
        ra.setColumns(10);
        
        JLabel crLabel = new JLabel("CR ");
        crLabel.setBounds(25, 70, 56, 16);
        contentPanel.add(crLabel);
        
        cr = new JTextField();
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
        
        JLabel posbiLabel = new JLabel("P\u00F3s Bacharelado");
        posbiLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        posbiLabel.setBounds(25, 144, 139, 16);
        contentPanel.add(posbiLabel);         
       
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
        curso3Box.setEnabled(false);
        curso3Box.setBackground(Color.LIGHT_GRAY);
        curso3Box.setModel(new DefaultComboBoxModel(new String[] {"-", "Bacharelado em Ciencia da Computacao", "Engenharia de Informacao"}));
        curso3Box.setBounds(48, 228, 353, 22);
        contentPanel.add(curso3Box);
        
        JLabel cpLabel = new JLabel("CP");
        cpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpLabel.setBounds(418, 142, 56, 16);
        contentPanel.add(cpLabel);
        
        CP1 = new JTextField();     
        CP1.setText("Digite aqui..."); 
        CP1.getText();
        CP1.setColumns(10);
        CP1.setBounds(409, 170, 74, 22);
        contentPanel.add(CP1);     
        
        CP2 = new JTextField(); 	
        CP2.setText("Digite aqui...");
        CP2.getText();
        CP2.setColumns(10);
        CP2.setBounds(409, 199, 74, 22);
        contentPanel.add(CP2);
        
        CP3 = new JTextField();
        CP3.setEnabled(false);
        CP3.setEditable(false);       
        CP3.setText("Digite aqui...");
        CP3.setColumns(10);
        CP3.setBounds(409, 228, 74, 22);
        contentPanel.add(CP3);
        
        final JRadioButton naobirb = new JRadioButton("Nao");        
        naobirb.setBounds(250, 139, 56, 23);
        contentPanel.add(naobirb);
        
        final JRadioButton simbirb = new JRadioButton("Sim");
        simbirb.setBounds(170, 139, 56, 23);
        contentPanel.add(simbirb);   
        
        posBI.add(simbirb);
        posBI.add(naobirb);
       
               
        
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	// The name of the file to open.
                    	 String fileName = arquivo;    
                         try {
                             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo, true));
                             // Note that write() does not automatically
                             // append a newline character.
                             bufferedWriter.write(ra.getText() + ";");
                             bufferedWriter.write(cr.getText() + ";");   
                             
                             //verificar turno
                             if(turnoBox.getSelectedItem().toString().equals("Diurno")) 
                            	 bufferedWriter.write("Diurno" + ";");                            	 
                             else
                                 bufferedWriter.write("Noturno" + ";");
                            
                             //verificar BI
                            if(biBox.getSelectedItem().toString().equals("BCT"))
                            	 bufferedWriter.write("BCT" + ";");    
                            else
                            	 bufferedWriter.write("BCH" + ";");
                            
                             //verificar pos BI - 1
                             if(curso1Box.getSelectedItem().toString().equals("Bacharelado em Ciencia da Computacao"))
                            	 bufferedWriter.write("Bacharelado em Ciencia da Computacao" + ";");    
                             else
                            	 bufferedWriter.write("Engenharia de Informacao" + ";");
                             
                             bufferedWriter.write(CP1.getText() + ";");
                             
                             //verificar pos BI - 2
                             if(curso2Box.getSelectedItem().toString().equals("Bacharelado em Ciencia da Computacao"))
                            	 bufferedWriter.write("Bacharelado em Ciencia da Computacao" + ";");    
                             else
                            	 bufferedWriter.write("Engenharia de Informacao" + ";");
                             
                             bufferedWriter.write(CP2.getText() + ";");    
                             
                             bufferedWriter.newLine();
                             bufferedWriter.close();
                             JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
                         }
                         catch(IOException ex) {
                             System.out.println( "Error writing to file '" + fileName + "'");
                         }

                        
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


	private void setDragable(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
