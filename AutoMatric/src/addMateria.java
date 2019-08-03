import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class addMateria extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField codigo;
    private JTextField nome;
    private ButtonGroup colBcc = new ButtonGroup();
    private ButtonGroup colBct = new ButtonGroup();
    private ButtonGroup colInfo = new ButtonGroup();

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
        
        JLabel obrigLabel = new JLabel("Obrigatoria para");
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
        
        final JRadioButton obrigBct = new JRadioButton("BCT");
        obrigBct.setBounds(134, 111, 56, 24);
        contentPanel.add(obrigBct);
        
        final JRadioButton obrigBcc = new JRadioButton("BCC");
        obrigBcc.setBounds(194, 111, 56, 24);
        contentPanel.add(obrigBcc);
        
        final JRadioButton obrigInfo = new JRadioButton("INFO");
        obrigInfo.setBounds(254, 111, 56, 24);
        contentPanel.add(obrigInfo);
        
        final JRadioButton limBct = new JRadioButton("BCT");
        limBct.setBounds(134, 153, 56, 24);
        contentPanel.add(limBct);
        
        final JRadioButton limBcc = new JRadioButton("BCC");
        limBcc.setBounds(194, 153, 56, 24);
        contentPanel.add(limBcc);
        
        final JRadioButton limInfo = new JRadioButton("INFO");
        limInfo.setBounds(254, 153, 56, 24);
        contentPanel.add(limInfo);
        
        final JRadioButton livreBct = new JRadioButton("BCT");
        livreBct.setBounds(134, 195, 56, 24);
        contentPanel.add(livreBct);
        
        final JRadioButton livreBcc = new JRadioButton("BCC");
        livreBcc.setBounds(194, 195, 56, 24);
        contentPanel.add(livreBcc);
        
        final JRadioButton livreInfo = new JRadioButton("INFO");
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
                         try {
                             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(menu.getCsvMaterias(), true));
                             
                             bufferedWriter.write(codigo.getText() + ";");
                             bufferedWriter.write(nome.getText() + ";");   
                             
                             String[] opt = {"false","false","false"};
                             
                             //verificar obrigatoria - selecionar apenas uma opcao
                             if(!obrigBct.isSelected() && !obrigBcc.isSelected() && !obrigInfo.isSelected()) //nenhum selecionado
                    			JOptionPane.showMessageDialog(null, "Selecione ao menos uma opcao obrigatoria!");
                             else {
                             if(obrigBct.isSelected())
                            	 bufferedWriter.write("true" + ";"+"-"+";"+"-"+";");                            	 
                             else if(obrigBcc.isSelected())
                                 bufferedWriter.write("-"+";"+"true"+";"+"-"+";");
                             else
                                 bufferedWriter.write("-"+";" +"-"+ ";" + "true"+";");
                             }
                            
                             //verificar limitada - mais de uma possibilidade, mas excluir a escolha de limitada quando a mesma obrigatoria for selecionada
                            if (!limBct.isSelected() && !limBcc.isSelected() && !limInfo.isSelected()) // nenhum selecionado
                                bufferedWriter.write("-" + ";" + "-" + ";" + "-" + ";");
                            else {
                                if (obrigBct.isSelected()) {
                                    if (limBcc.isSelected() && limInfo.isSelected())
                                        bufferedWriter.write("-" + ";" + "SIM" + ";" + "SIM" + ";");
                                    else if (limBcc.isSelected() || limInfo.isSelected()) {
                                        if (limBcc.isSelected()) {
                                            bufferedWriter.write("-" + ";" + "SIM" + ";" + "-" + ";");
                                        } else {
                                            bufferedWriter.write("-" + ";" + "-" + ";" + "SIM" + ";");
                                        }
                                    }
                                }
                                if (obrigBcc.isSelected()) {
                                    if (limBct.isSelected() && limInfo.isSelected())
                                        bufferedWriter.write("SIM" + ";" + "-" + ";" + "SIM" + ";");
                                    else if (limBct.isSelected() || limInfo.isSelected()) {
                                        if (limBct.isSelected()) {
                                            bufferedWriter.write("SIM" + ";" + "-" + ";" + "-" + ";");
                                        } else {
                                            bufferedWriter.write("-" + ";" + "-" + ";" + "SIM" + ";");
                                        }
                                    }
                                }
                                if (obrigInfo.isSelected()) {
                                    if (limBct.isSelected() && limBcc.isSelected())
                                        bufferedWriter.write("SIM" + ";" + "SIM" + ";" + "-" + ";");
                                    else if (limBct.isSelected() || limBcc.isSelected()) {
                                        if (limBct.isSelected()) {
                                            bufferedWriter.write("SIM" + ";" + "-" + ";" + "-" + ";");
                                        } else {
                                            bufferedWriter.write("-" + ";" + "SIM" + ";" + "-" + ";");
                                        }
                                    }
                                }
                            }

                           //verificar livre - mais de uma possibilidade, mas excluir a escolha de livre quando a mesma obrigatoria OU limitada for selecionada
                             if(!livreBct.isSelected() && !livreBcc.isSelected() && !livreInfo.isSelected()) //nenhum selecionado
                    			 bufferedWriter.write("-"+";" +"-"+ ";" + "-"+";"); 
                           //pelo menos um selecionado
                             else{		
                             if(obrigBct.isSelected() || limBct.isSelected()) { 
                            		 if(livreBcc.isSelected() && livreInfo.isSelected())
                            	 bufferedWriter.write("-" + ";"+"SIM"+";"+"SIM"+";");  
                            		 if(livreBcc.isSelected() || livreInfo.isSelected()) { 
                            			 if(livreBcc.isSelected()) 
                            				 bufferedWriter.write("-"+";"+"SIM"+";"+"-"+";");
                            			 else if(livreInfo.isSelected())
                                        	 bufferedWriter.write("-"+";" +"-"+ ";" + "SIM"+";"); 
                            			 else
                            				 bufferedWriter.write("-"+";" +"-"+ ";" + "-"+";"); 
                            		 }  
                             }
                             if(obrigBcc.isSelected() || limBcc.isSelected() ) {
                            	 if(livreBct.isSelected() && livreInfo.isSelected())
                            		 bufferedWriter.write("SIM" + ";"+"-"+";"+"SIM"+";");
                            	 if(livreBct.isSelected() || livreInfo.isSelected()) {
                            		 if(livreBct.isSelected()) 
                            			 bufferedWriter.write("SIM"+";"+"-"+";"+"-"+";");
                            		 else if (livreInfo.isSelected())
                            			 bufferedWriter.write("-"+";" +"-"+ ";" + "SIM"+";");
                            		 else
                            			 bufferedWriter.write("-"+";" +"-"+ ";" + "-"+";"); 
                            		 } 
                             } if(obrigInfo.isSelected()|| limInfo.isSelected()) {
                            	 if(livreBct.isSelected() && livreBcc.isSelected())
                            		 bufferedWriter.write("SIM" + ";"+"SIM"+";"+"-"+";");
                            	 if(livreBct.isSelected() || livreBcc.isSelected()) {
                            		 if(livreBct.isSelected())
                            			 bufferedWriter.write("SIM"+";"+"-"+";"+"-"+";");
                            		 else if(livreBcc.isSelected())
                            			 bufferedWriter.write("-"+";" +"SIM"+ ";" + "-"+";");
                            		 else
                            			 bufferedWriter.write("-"+";" +"-"+ ";" + "-"+";"); 
                            		 } 
                             }
                             }
                             
                             
                             bufferedWriter.newLine();
                             bufferedWriter.close();
                             JOptionPane.showMessageDialog(null, "Mat�ria adicionado com sucesso!");
                         }
                         catch(IOException ex) {
                             System.out.println( "Error writing to file");
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
            
            //selecionar apenas uma op��o nas colunas
            colBct.add(obrigBct);
            colBct.add(limBct);
            colBct.add(livreBct);
            colBcc.add(obrigBcc);
            colBcc.add(limBcc);
            colBcc.add(livreBcc);
            colInfo.add(obrigInfo);
            colInfo.add(limInfo);
            colInfo.add(livreInfo);
         
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