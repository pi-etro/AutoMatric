import java.awt.EventQueue;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AutoMatric {
    private JFrame frmAutomatric;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AutoMatric window = new AutoMatric();
                    window.frmAutomatric.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AutoMatric() {
        initialize();
    }

    private void initialize() {
        frmAutomatric = new JFrame();
        frmAutomatric.setResizable(false);
        frmAutomatric.getContentPane().setBackground(Color.GRAY);
        frmAutomatric.getContentPane().setLayout(null);
        
        JLabel logoLabel = new JLabel("");
        Image logo = new ImageIcon(this.getClass().getResource("/lg_matric.png")).getImage();
        logoLabel.setBounds(50, 40, 400, 103);
        logoLabel.setIcon(new ImageIcon(logo));
        frmAutomatric.getContentPane().add(logoLabel);
        
        // Iniciar
        JButton btnIni = new JButton("Iniciar !");
        btnIni.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //botao iniciar leva ao menu
                new menu().setVisible(true);
                frmAutomatric.dispose();
            }
        });
        btnIni.setBounds(200, 220, 100, 30);
        frmAutomatric.getContentPane().add(btnIni);
        frmAutomatric.setTitle("AutoMatric");
        frmAutomatric.setBackground(Color.DARK_GRAY);
        frmAutomatric.setBounds(100, 100, 500, 350);
        frmAutomatric.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //icone do programa
        try {
        frmAutomatric.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //centraliza janela
        frmAutomatric.setLocationRelativeTo(null);
    }
}
