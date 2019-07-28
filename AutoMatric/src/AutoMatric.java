import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Canvas;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AutoMatric {

    private JFrame frmAutomatric;

    /**
     * Launch the application.
     */
    //teste.
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

    /**
     * Create the application.
     */
    public AutoMatric() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAutomatric = new JFrame();
        frmAutomatric.setResizable(false);
        frmAutomatric.getContentPane().setBackground(Color.GRAY);
        frmAutomatric.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        Image logo = new ImageIcon(this.getClass().getResource("/lg_matric.png")).getImage();
        lblNewLabel.setBounds(50, 40, 400, 103);
        lblNewLabel.setIcon(new ImageIcon(logo));
        frmAutomatric.getContentPane().add(lblNewLabel);
        
        JButton btnIni = new JButton("Iniciar !");
        btnIni.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frmAutomatric.dispose();
                menu menu = new menu();
                menu.setVisible(true);
            }
        });
        btnIni.setBounds(200, 220, 100, 30);
        frmAutomatric.getContentPane().add(btnIni);
        frmAutomatric.setTitle("AutoMatric");
        frmAutomatric.setBackground(Color.DARK_GRAY);
        frmAutomatric.setBounds(100, 100, 500, 350);
        frmAutomatric.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
        frmAutomatric.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        frmAutomatric.setLocationRelativeTo(null);
    }
}
