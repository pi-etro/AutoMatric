import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class selArch extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField alunoFile;
    private JTextField materiasFile;
    private JTextField matriculaFile;

    public selArch() {
        setTitle("Selecionar Arquivos");
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
        
        JLabel studLabel = new JLabel("Banco de Alunos");
        studLabel.setBounds(40, 30, 290, 14);
        contentPanel.add(studLabel);
        
        JLabel subLabel = new JLabel("Banco de Matérias");
        subLabel.setBounds(40, 90, 290, 14);
        contentPanel.add(subLabel);
        
        JLabel matrLabel = new JLabel("Banco de Matrículas");
        matrLabel.setBounds(40, 150, 290, 14);
        contentPanel.add(matrLabel);
        
        JButton btnStud = new JButton("...");
        btnStud.setBounds(330, 50, 30, 25);
        contentPanel.add(btnStud);
        
        JButton btnSub = new JButton("...");
        btnSub.setBounds(330, 110, 30, 25);
        contentPanel.add(btnSub);
        
        JButton btnMatr = new JButton("...");
        btnMatr.setBounds(330, 170, 30, 25);
        contentPanel.add(btnMatr);
        
        alunoFile = new JTextField();
        alunoFile.setBounds(40, 50, 290, 25);
        contentPanel.add(alunoFile);
        alunoFile.setColumns(10);
        
        materiasFile = new JTextField();
        materiasFile.setBounds(40, 110, 290, 25);
        contentPanel.add(materiasFile);
        materiasFile.setColumns(10);
        
        matriculaFile = new JTextField();
        matriculaFile.setBounds(40, 170, 290, 25);
        contentPanel.add(matriculaFile);
        matriculaFile.setColumns(10);
        
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
