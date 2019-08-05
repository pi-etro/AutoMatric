import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.opencsv.*;
import sistema.*;

public class classificar extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField dirsalvar;

    public classificar(){
        setTitle("Classificar");
        setResizable(false);
        setForeground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 500, 350);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
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
        
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        menu.setCsvSaveFile(dirsalvar.getText());
                        if(menu.getCsvSaveFile()==null || menu.getCsvSaveFile().equals("Digite aqui...")) {
                            JOptionPane.showMessageDialog(null, "Adicione um local para salvar!");
                        }
                        else if(menu.getCsvAluno() == null) {
                            JOptionPane.showMessageDialog(null, "Adicione um Bando de Alunos!");
                        }
                        else if(menu.getCsvMaterias() == null) {
                            JOptionPane.showMessageDialog(null, "Adicione um Bando de Materias!");
                        }
                        else if(menu.getCsvOferta() == null) {
                            JOptionPane.showMessageDialog(null, "Adicione um Bando de Materias Ofertadas!");
                        }
                        else if(menu.getCsvMatriculados() == null) {
                            JOptionPane.showMessageDialog(null, "Adicione um Bando de Matriculados!");
                        }
                        else {                        
                        try (FileReader leitor = new FileReader(menu.getCsvOferta());) {
                            //adicionar o cabeçalho
                            @SuppressWarnings("deprecation")
                            CSVWriter escr = new CSVWriter(new FileWriter(menu.getCsvSaveFile(), true), ';');
                            String[] alunoMat = new String[5];
                            String[] header = {"RA", "Turma", "Matéria", "CR corte", "CP corte"};
                            escr.writeNext(header);

                            //leitor do csv de materias ofertadas
                            BufferedReader csvLeitor = new BufferedReader(leitor);
                            String tur;
                            boolean boo = true;
                            
                            // loop de leitura de turmasvlinha por linha
                            while ((tur = csvLeitor.readLine()) != null) {
                                //[0] Materia, [1] Codig Disc, [2] Codig Turm, [3] Turma, [4] Turno, [5] Campus, [6] Vagas
                                //cria turma atual
                                if(boo) {
                                    boo=false;
                                    continue;
                                }
                                String[] t = tur.split(";");
                                Turma turma = new Turma(t[0], t[1], t[2], t[4], t[6]);

                                //lista com ras dos matriculados na turma que esta sendo analisada
                                List<Integer> raMatriculados = new ArrayList<>();
                                try(FileReader l = new FileReader(menu.getCsvMatriculados());){
                                    BufferedReader csvL = new BufferedReader(l);
                                    String row;
                                    boolean bt = true;
                                    while ((row = csvL.readLine()) != null) {
                                        if(bt) {
                                            bt=false;
                                            continue;
                                        }
                                        String[] mat = row.split(";");
                                        if(mat[1].equals(turma.getCodTurma())) {
                                            raMatriculados.add(Integer.parseInt(mat[0].trim()));
                                        }
                                    }
                                }
                                
                                //lista com os objetos Alunos matriculados
                                Aluno[] matriculados = new Aluno[raMatriculados.size()];
                                int p=0;
                                while(p<raMatriculados.size()) {
                                    try(FileReader l = new FileReader(menu.getCsvAluno());){
                                        BufferedReader csvL = new BufferedReader(l);
                                        String row;
                                        boolean bt = true;
                                        while ((row = csvL.readLine()) != null) {
                                            if(bt) {
                                                bt=false;
                                                continue;
                                            }
                                            String[] alu = row.split(";");
                                            Integer a = Integer.valueOf(alu[0]);
                                            if(raMatriculados.get(p).equals(a)) {
                                                matriculados[p] = new Aluno(alu[0], alu[1], alu[2], alu[3], alu[4], alu[5], alu[6], alu[7], alu[8], alu[9], alu[10]);
                                            }
                                        }
                                    }
                                    p++;
                                }
                                
                                //gerar uma lista com a relação da materia atual com os cursos
                                try(FileReader l = new FileReader(menu.getCsvMaterias());){
                                    BufferedReader csvL = new BufferedReader(l);
                                    String row;
                                    boolean bt = true;
                                    while((row = csvL.readLine()) != null){
                                        if(bt) {
                                            bt=false;
                                            continue;
                                        }
                                        String[] materia = row.split(";");
                                        if(materia[0].equals(turma.getCodDis())) {
                                            String[] v = new String[materia.length-2];
                                            int j=0;
                                            for(int i=2; i<materia.length; i++) {
                                                v[j] = materia[i];
                                                j++;
                                            }
                                            ((Materia) turma).setRelacaoCurso(v);
                                            break;
                                        }
                                    }
                                }
                                
                                // variaveis para armazenas os selecionados e o valor do corte
                                Aluno[] selecionados = new Aluno[turma.getVagas()];
                                String tipo = null;
                                
                                //!!!!!!!!!!!!!!  INICIO DA CLASSIFICACAO  !!!!!!!!!!!!!!!!!!!!

                                //decidir se é do BI ou pos BI
                                if(turma.getRelacaoCurso()[1][0].equals("Obrigatoria")) {

                                    //decisão da seleçao a partir do turno
                                    String turno = turma.getTurno();
                                    // vespertino apenas ordenar por cr
                                    if(turno.equals("Verpertino")) {
                                        matriculados = Arrays.copyOf(turma.ordenarCr(matriculados), matriculados.length); 
                                    }
                                    else {
                                        // divisao de alunos noturnos e diurnos
                                        Aluno[] aluNoturnos = new Aluno[matriculados.length];
                                        Aluno[] aluDiurnos = new Aluno[matriculados.length];
                                        
                                        int j=0, h=0;
                                        for(int i=0; i<matriculados.length; i++) {
                                            if(matriculados[i] != null) {
                                                if(matriculados[i].getTurno().equals("Diurno")) {
                                                    aluDiurnos[j] = matriculados[i];
                                                    j++;
                                                }
                                                else if (matriculados[i].getTurno().equals("Noturno")){
                                                    aluNoturnos[h] = matriculados[i];
                                                    h++;
                                                }
                                            }
                                        }
                                        
                                        // ordenar vetores diurno e noturno
                                        Aluno[] aluDiord = Arrays.copyOf(turma.ordenarCr(aluDiurnos), matriculados.length);
                                        Aluno[] aluNoord = Arrays.copyOf(turma.ordenarCr(aluNoturnos), matriculados.length);
                                        
                                        // jogar de volta no vetor
                                        if(turma.getTurno().equals("Diurno")) {
                                            int i = 0;
                                            for(; i<matriculados.length && aluDiord[i]!=null; i++) {
                                                matriculados[i] = aluDiord[i];
                                            }
                                            //completar com o noturno
                                            int c = 0;
                                            for(; i<matriculados.length && aluNoord[c]!=null; i++) {
                                                matriculados[i] = aluNoord[c];
                                                c++;
                                            }
                                        }
                                        else if(turma.getTurno().equals("Noturno")) {
                                            int i = 0;
                                            for(; i<matriculados.length && aluNoord[i]!=null; i++) {
                                                matriculados[i] = aluNoord[i];
                                            }
                                            //completar com o diurno
                                            int c = 0;
                                            for(; i<matriculados.length && aluDiord[c]!=null; i++) {
                                                matriculados[i] = aluDiord[c];
                                                c++;
                                            }
                                        }
                                    }
                                    tipo = "cr";
                                }
                                //materias do pos bi
                                else{
                                    String turno = turma.getTurno();
                                    
                                    if(turno.equals("Verpertino")) {
                                        //ordenar por cp
                                        Aluno[] matriculadosOrd = Arrays.copyOf(turma.ordenarCp(matriculados), matriculados.length);

                                        // divisao de alunos obrig e limitadas
                                        Aluno[] aluObglim = new Aluno[matriculados.length];
                                        Aluno[] aluLivre = new Aluno[matriculados.length];
                                        
                                        int j=0, h=0;
                                        for(int i=0; i<matriculados.length; i++) {
                                            if(turma.temOblim(matriculadosOrd[i])) {
                                                aluObglim[j] = matriculadosOrd[i];
                                                j++;
                                            }
                                            else {
                                                aluLivre[h] = matriculadosOrd[i];
                                                h++;
                                            }
                                        }
                                        
                                        //unir em um unico vetor
                                        int i = 0;
                                        for(;aluObglim[i]!=null && i<matriculados.length; i++) {
                                            matriculados[i] = aluObglim[i];
                                        }
                                        int c = 0;
                                        for(;aluLivre[c]!=null && i<matriculados.length; i++) {
                                            matriculados[i] = aluLivre[c];
                                            c++;
                                        }
                                    }
                                    // semelhante ao anterior, porem com o turno
                                    else {
                                        //ordenar por cp
                                        Aluno[] matriculadosOrd = Arrays.copyOf(turma.ordenarCp(matriculados), matriculados.length);
                                        
                                        //divisao de alunos obrig e limitadas
                                        Aluno[] aluObglim = new Aluno[matriculados.length];
                                        Aluno[] aluLivre = new Aluno[matriculados.length];
                                        
                                        int j=0, h=0;
                                        for(int i=0; i<matriculados.length; i++) {
                                            if(turma.temOblim(matriculadosOrd[i])) {
                                                aluObglim[j] = matriculadosOrd[i];
                                                j++;
                                            }
                                            else {
                                                aluLivre[h] = matriculadosOrd[i];
                                                h++;
                                            }
                                        }
                                        
                                        //ordenar em 4 vetores para turnos e obrigatorios
                                        Aluno[] obgDiurno = new Aluno[matriculados.length];
                                        Aluno[] obgNoturno = new Aluno[matriculados.length];
                                        Aluno[] livDiurno = new Aluno[matriculados.length];
                                        Aluno[] livNoturno = new Aluno[matriculados.length];
                                        
                                        int a=0, b=0;
                                        for(int i=0; i<matriculados.length; i++) {
                                            //aqui
                                            if(aluObglim[i] != null) {
                                                if(aluObglim[i].getTurno().equals("Diurno")) {
                                                    obgDiurno[a] = aluObglim[i];
                                                    a++;
                                                }
                                                else {
                                                    obgNoturno[b] = aluObglim[i];
                                                    b++;
                                                }
                                            }
                                        }
                                        
                                        a=0;
                                        b=0;
                                        for(int i=0; i<matriculados.length; i++) {
                                            if(aluLivre[i] != null) {
                                                if(aluLivre[i].getTurno().equals("Diurno")) {
                                                    livDiurno[a] = aluLivre[i];
                                                    a++;
                                                }
                                                else {
                                                    livNoturno[b] = aluLivre[i];
                                                    b++;
                                                }
                                            }
                                        }
                                        
                                        //unir em um unico vetor
                                        if(turma.getTurno().equals("Diurno")) {
                                            int i = 0, c=0;
                                            for(;obgDiurno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = obgDiurno[c];
                                                c++;
                                            }
                                            //completar com os noturno obrigatorio
                                            c = 0;
                                            for(;obgNoturno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = obgNoturno[c];
                                                c++;
                                            }
                                            //completar com diurno livre
                                            c = 0;
                                            for(;livDiurno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = livDiurno[c];
                                                c++;
                                            }
                                            //completar com noturno livre
                                            c = 0;
                                            for(;livNoturno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = livNoturno[c];
                                                c++;
                                            }
                                        }
                                        else {
                                            int i = 0, c=0;
                                            for(;obgNoturno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = obgNoturno[c];
                                                c++;
                                            }
                                            //completar com os diurno obrigatorio
                                            c = 0;
                                            for(;obgDiurno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = obgDiurno[c];
                                                c++;
                                            }
                                            //completar com noturno livre
                                            c = 0;
                                            for(;livNoturno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = livNoturno[c];
                                                c++;
                                            }
                                            //completar com diurno livre
                                            c = 0;
                                            for(;livDiurno[c]!=null && i<matriculados.length; i++) {
                                                matriculados[i] = livDiurno[c];
                                                c++;
                                            }
                                        }
                                        tipo = "cp";
                                    }
                                }
                                for(int i=0; i<matriculados.length && i<turma.getVagas(); i++) {
                                    selecionados[i] = matriculados[i];
                                }
                                
                                //escrita no arquivo
                                for(int i=0; i<selecionados.length; i++) {
                                    alunoMat[0] = String.valueOf(selecionados[i].getRa());
                                    alunoMat[1] = turma.getCodTurma();
                                    alunoMat[2] = turma.getNomeDis();
                                    if (tipo.equals("cr") && i==selecionados.length-1) alunoMat[3] = String.format("%.2f", selecionados[i].getCr());
                                    else alunoMat[3] = "-";
                                    if (tipo.equals("cp") && i==selecionados.length-1) alunoMat[4] = String.format("%.2f", Turma.maiorCp(selecionados[i]));
                                    else alunoMat[4] = "-";
                                    escr.writeNext(alunoMat);
                                }
                            }
                            escr.close();
                        } catch (FileNotFoundException e) {
                            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado!");
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "Nao foi possivel abrir o arquivo!");
                        }
                        JOptionPane.showMessageDialog(null, "Classificação feita com sucesso!");
                        new menu().setVisible(true);
                        dispose();
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
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        setLocationRelativeTo(null);
    }
}
