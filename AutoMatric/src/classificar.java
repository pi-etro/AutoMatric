import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.opencsv.*;
import javax.swing.SwingConstants;
import java.awt.Font;
import sistema.*;
import com.opencsv.CSVReader;

public class classificar extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField dirsalvar;
    private JTextField txtStatus;

    public classificar(){
        setTitle("Classificar");
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
        
        JLabel statusLabel = new JLabel("Status...");
        statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        statusLabel.setVerticalAlignment(SwingConstants.TOP);
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusLabel.setBounds(40, 119, 410, 117);
        contentPanel.add(statusLabel);
        statusLabel.setForeground(Color.GREEN);
        statusLabel.setVisible(true);
        
        JLabel salveremLabel = new JLabel("Salvar Arquivos em");
        salveremLabel.setBounds(40, 30, 290, 14);
        contentPanel.add(salveremLabel);
        
        JButton btnSalvar = new JButton("...");
        btnSalvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	              JFileChooser fileSave = new JFileChooser();
        	              String[] csv = {"csv"};
        	              FileFilter filtroSave = new FileNameExtensionFilter("CSV file", csv);
        	              fileSave.setFileFilter(filtroSave);
        	              fileSave.setFileSelectionMode(JFileChooser.FILES_ONLY);
        	              int i= fileSave.showSaveDialog(null);		
        	              if (i!=1){
        	            	  dirsalvar.setText(fileSave.getSelectedFile().getPath());   
        	            }
        	}
        });
        btnSalvar.setBounds(330, 50, 30, 25);
        contentPanel.add(btnSalvar);
        
        dirsalvar = new JTextField();
        dirsalvar.setBounds(40, 50, 290, 25);
        contentPanel.add(dirsalvar);
        dirsalvar.setColumns(10);
        dirsalvar.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(dirsalvar.getText().equals("Escolha o local...")) dirsalvar.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(dirsalvar.getText().equals("")) dirsalvar.setText("Escolha o local...");
            }
        });
        if(menu.getCsvSaveFile() != null) dirsalvar.setText(menu.getCsvSaveFile());
        else dirsalvar.setText("Escolha o local...");
        
        txtStatus = new JTextField();
        txtStatus.setEnabled(false);
        txtStatus.setEditable(false);
        txtStatus.setForeground(Color.GREEN);
        txtStatus.setBackground(Color.BLACK);
        txtStatus.setHorizontalAlignment(SwingConstants.LEFT);
        txtStatus.setBounds(30, 103, 420, 127);
        contentPanel.add(txtStatus);
        txtStatus.setColumns(10);
        
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        menu.setCsvAluno("/home/pi/Documents/csvs/Alunos.csv");
                        menu.setCsvMaterias("/home/pi/Documents/csvs/Materia.csv");
                        menu.setCsvOferta("/home/pi/Documents/csvs/Ofertas.csv");
                        menu.setCsvMatriculados("/home/pi/Documents/csvs/Matricula.csv");
                        
                        try (FileReader leitor = new FileReader(menu.getCsvOferta());) { 
                            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
                            CSVReader csvLeitor = new CSVReaderBuilder(leitor).withCSVParser(parser).withSkipLines(1).build();
                            String[] t;
                            //while de leitura de turmas, linha por linha ate acabar
                            while ((t = csvLeitor.readNext()) != null) { 
                                //[0] Materia, [1] Codig Disc, [2] Codig Turm, [3] Turma, [4] Turno, [5] Campus, [6] Vagas
                                Turma turma = new Turma(t[0], t[1], t[2], t[4], t[6]);
                                
                                //lista com ras dos matriculados na turma que está sendo analisada
                                List<Integer> raMatriculados = new ArrayList<>();
                                try(FileReader l = new FileReader(menu.getCsvMatriculados());){
                                    CSVReader csvL = new CSVReaderBuilder(l).withCSVParser(parser).withSkipLines(1).build();
                                    String[] mat;
                                    while ((mat = csvL.readNext()) != null) {
                                        if(mat[1].equals(turma.getCodTurma())) {
                                            raMatriculados.add(Integer.parseInt(mat[0]));
                                        }
                                    }
                                }
                                
                                //lista com os objetos alunos matriculados
                                List<Aluno> matriculados = new ArrayList<>();
                                try(FileReader l = new FileReader(menu.getCsvAluno());){
                                    CSVReader csvL = new CSVReaderBuilder(l).withCSVParser(parser).withSkipLines(1).build();
                                    String[] alu;
                                    int i=0, a;
                                    while ((alu = csvL.readNext()) != null && i < raMatriculados.size()) {
                                        a = Integer.parseInt(alu[0]);
                                        if(a == raMatriculados.get(i)) {
                                             matriculados.add(new Aluno(alu[0], alu[1], alu[2], alu[3], alu[4], alu[5], alu[6], alu[7], alu[8], alu[9], alu[10]));
                                        }
                                        i++;
                                    }
                                }
                                
                                //gerar uma lista com a relação da materia atual com os cursos
                                try(FileReader l = new FileReader(menu.getCsvMaterias());){
                                    CSVReader csvL = new CSVReaderBuilder(l).withCSVParser(parser).withSkipLines(1).build();
                                    String[] materia;
                                    while((materia = csvL.readNext()) != null){
                                        if(materia[0].equals(turma.getCodDis())) {
                                            String[] v = new String[materia.length-2];
                                            int j=0;
                                            for(int i=2; i<materia.length; i++) {
                                                v[j] = materia[i];
                                                j++;
                                            }
                                            System.out.println();
                                            ((Materia) turma).setRelacaoCurso(v);
                                            break;
                                        }
                                    }
                                }
                                
                                //inicio da classificação
                                
                                
                                
                                
                                
                                
                                
                            }
                        } catch (FileNotFoundException e) {
                            
                        } catch (IOException e) {
                            
                        }
                        
                        menu.setCsvSaveFile(dirsalvar.getText());                     
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
        
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        setLocationRelativeTo(null);
    }

	private void setDragable(boolean b) {
		
	}


	
}
