import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

    private JPanel contentPane;

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
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Image logo2 = new ImageIcon(this.getClass().getResource("/lg.png")).getImage();
        lblNewLabel.setBounds(40, 68, 175, 175);
        lblNewLabel.setIcon(new ImageIcon(logo2));
        contentPane.add(lblNewLabel);
        
        JButton btnClassificar = new JButton("Selecionar Arquivos");
        btnClassificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                contentPane.setVisible(false);
                selArch sel = new selArch();
                sel.setVisible(true);
            }    
        });
        btnClassificar.setBounds(280, 117, 153, 26);
        contentPane.add(btnClassificar);
        
        JButton button = new JButton("Classificar");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                contentPane.setVisible(false);
                classificar sel = new classificar();
                sel.setVisible(true);
            }    
        });
        button.setBounds(280, 67, 153, 26);
        contentPane.add(button);
        
        JButton button_1 = new JButton("Adicionar Aluno");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                contentPane.setVisible(false);
                addAluno sel = new addAluno();
                sel.setVisible(true);
            }    
        });
        button_1.setBounds(280, 167, 153, 26);
        contentPane.add(button_1);
        
        JButton button_2 = new JButton("Adicionar Matéria");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                contentPane.setVisible(false);
                addMateria sel = new addMateria();
                sel.setVisible(true);
            }    
        });
        button_2.setBounds(280, 217, 153, 26);
        contentPane.add(button_2);
        
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        setLocationRelativeTo(null);
    }
}
