import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class selArch extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField alunoFile;
    private JTextField materiasFile;
    private JTextField matriculaFile;
    private JTextField ofertaFile;

    public selArch() {
        setTitle("Selecionar Arquivos");
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
        
        JLabel alunoLabel = new JLabel("Banco de Alunos");
        alunoLabel.setBounds(40, 30, 290, 14);
        contentPanel.add(alunoLabel);
        
        JLabel matLabel = new JLabel("Banco de Materias");
        matLabel.setBounds(40, 90, 290, 14);
        contentPanel.add(matLabel);
        
        JLabel oferLabel = new JLabel("Banco de Materias Ofertadas");
        oferLabel.setBounds(40, 150, 290, 14);
        contentPanel.add(oferLabel);
        
        JLabel matrLabel = new JLabel("Banco de Matriculados");
        matrLabel.setBounds(40, 210, 290, 14);
        contentPanel.add(matrLabel);
        
        JButton btnStud = new JButton("...");
        btnStud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
              JFileChooser fileStud = new JFileChooser();
              String[] csv = {"csv"};
              FileFilter filtStud = new FileNameExtensionFilter("CSV file", csv);
              fileStud.setFileFilter(filtStud);
              fileStud.setFileSelectionMode(JFileChooser.FILES_ONLY);
              int i= fileStud.showSaveDialog(null);		
              if (i!=1){
                  File arquivo = fileStud.getSelectedFile();
                  alunoFile.setText(arquivo.getPath());        
            }
            }
        });
        btnStud.setBounds(330, 50, 30, 25);
        contentPanel.add(btnStud);
        
        JButton btnSub = new JButton("...");
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser fileSub = new JFileChooser();
                String[] csv = {"csv"};
                FileFilter filtrSub = new FileNameExtensionFilter("CSV file", csv);
                fileSub.setFileFilter(filtrSub);
                fileSub.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int i= fileSub.showSaveDialog(null);		
                if (i!=1){
                    materiasFile.setText(fileSub.getSelectedFile().getPath());
                }
            }
        });
        btnSub.setBounds(330, 110, 30, 25);
        contentPanel.add(btnSub);
        
        JButton btnOfer = new JButton("...");
        btnOfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser file = new JFileChooser();
                String[] csv = {"csv"};
                FileFilter filtrOfer = new FileNameExtensionFilter("CSV file", csv);
                file.setFileFilter(filtrOfer);
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int i= file.showSaveDialog(null);		
                if (i!=1){
                    ofertaFile.setText(file.getSelectedFile().getPath());
                }
            }
        });
        btnOfer.setBounds(330, 170, 30, 25);
        contentPanel.add(btnOfer);
        
        JButton btnMatr = new JButton("...");
        btnMatr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser file = new JFileChooser();
                String[] csv = {"csv"};
                FileFilter filtro = new FileNameExtensionFilter("CSV file", csv);
                file.setFileFilter(filtro);
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int i= file.showSaveDialog(null);		
                if (i!=1){
                    matriculaFile.setText(file.getSelectedFile().getPath());
                }
            }
        });
        btnMatr.setBounds(330, 230, 30, 25);
        contentPanel.add(btnMatr);
        
        alunoFile = new JTextField();
        alunoFile.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(alunoFile.getText().equals("Digite aqui...")) alunoFile.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(alunoFile.getText().equals("")) alunoFile.setText("Digite aqui...");
            }
        });
        if(menu.getCsvAluno() != null) alunoFile.setText(menu.getCsvAluno());
        else alunoFile.setText("Digite aqui...");
        alunoFile.setBounds(40, 50, 290, 25);
        contentPanel.add(alunoFile);
        alunoFile.setColumns(10);
        
        materiasFile = new JTextField();
        materiasFile.setDropMode(DropMode.INSERT);
        materiasFile.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(materiasFile.getText().equals("Digite aqui...")) materiasFile.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(materiasFile.getText().equals("")) materiasFile.setText("Digite aqui...");
            }
        });
        if(menu.getCsvMaterias() != null) materiasFile.setText(menu.getCsvMaterias());
        else materiasFile.setText("Digite aqui...");
        materiasFile.setBounds(40, 110, 290, 25);
        contentPanel.add(materiasFile);
        materiasFile.setColumns(10);
        
        ofertaFile = new JTextField();
        //apagar e voltar o texto quando TextField for selecionado
        ofertaFile.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if(ofertaFile.getText().equals("Digite aqui...")) ofertaFile.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(ofertaFile.getText().equals("")) ofertaFile.setText("Digite aqui...");
            }
        });
        if(menu.getCsvOferta() != null) ofertaFile.setText(menu.getCsvOferta());
        else ofertaFile.setText("Digite aqui...");
        ofertaFile.setBounds(40, 170, 290, 25);
        contentPanel.add(ofertaFile);
        ofertaFile.setColumns(10);

        matriculaFile = new JTextField();
        matriculaFile.setBounds(40, 230, 290, 25);
        contentPanel.add(matriculaFile);
        matriculaFile.setColumns(10);
        matriculaFile.addFocusListener(new FocusAdapter() {
        //apagar mensagem "Digite aqui..." quando caixa de texto for selecionada
        	public void focusGained(FocusEvent e) {
                if(matriculaFile.getText().equals("Digite aqui...")) matriculaFile.setText(""); 
            }
            public void focusLost(FocusEvent e) {
                if(matriculaFile.getText().equals("")) matriculaFile.setText("Digite aqui...");
            }
        });
        if(menu.getCsvMatriculados() != null) matriculaFile.setText(menu.getCsvMatriculados());
        else matriculaFile.setText("Digite aqui...");
        
        // OK Cancel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        menu.setCsvAluno(alunoFile.getText());
                        menu.setCsvMaterias(materiasFile.getText());
                        menu.setCsvOferta(ofertaFile.getText());
                        menu.setCsvMatriculados(matriculaFile.getText());
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
