import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class menu extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private static String csvAluno;
    private static String csvOferta;
    private static String csvMaterias;
    private static String csvMatriculados;
    
    public menu() {
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        setTitle("AutoMatric");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel logoLabel = new JLabel("");
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Image logo = new ImageIcon(this.getClass().getResource("/lg.png")).getImage();
        logoLabel.setBounds(40, 68, 175, 175);
        logoLabel.setIcon(new ImageIcon(logo));
        contentPane.add(logoLabel);
        
        // Classificar
        JButton btnClas = new JButton("Classificar");
        btnClas.setBounds(280, 67, 153, 26);
        contentPane.add(btnClas);
        btnClas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new classificar().setVisible(true);
                dispose();
            }    
        });
        
        // Selecionar Arquivos 
        JButton btnFiles = new JButton("Selecionar Arquivos");
        btnFiles.setBounds(280, 117, 153, 26);
        contentPane.add(btnFiles);
        btnFiles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new selArch().setVisible(true);
                dispose();
            }    
        });
        
        // Adicionar Aluno
        JButton btnStud = new JButton("Adicionar Aluno");
        btnStud.setBounds(280, 167, 153, 26);
        contentPane.add(btnStud);
        btnStud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new addAluno().setVisible(true);
                dispose();
            }    
        });
        
        // Adicionar Materia
        JButton btnSub = new JButton("Adicionar Matéria");
        btnSub.setBounds(280, 217, 153, 26);
        contentPane.add(btnSub);
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new addMateria().setVisible(true);
                dispose();
            }    
        });
        
        //icone do programa
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        //centralizar
        setLocationRelativeTo(null);
    }
    
    public static void setCsvAluno(String adrss) {
        csvAluno = adrss;
    }
    public static String getCsvAluno() {
        return csvAluno;
    }
    
    public static void setCsvOferta(String adrss) {
        csvOferta = adrss;
    }
    public static String getCsvOferta() {
        return csvOferta;
    }
    
    public static void setCsvMaterias(String adrss) {
        csvMaterias = adrss;
    }
    public static String getCsvMateria() {
        return csvMaterias;
    }
    
    public static void setCsvMatriculados(String adrss) {
        csvMatriculados = adrss;
    }
    public static String getCsvMatriculados() {
        return csvMatriculados;
    }
}
