import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addAluno extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            addAluno dialog = new addAluno();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public addAluno() {
        setTitle("Adicionar Aluno");
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
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                        //fechar janela Marina v1
                        System.exit(0);
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
