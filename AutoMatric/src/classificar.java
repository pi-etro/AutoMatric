import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class classificar extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField dirsalvar;
    private JTextField txtStatus;

    public classificar() {
        setTitle("Classificar");
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
        
        JLabel salveremLabel = new JLabel("Salvar Arquivos em");
        salveremLabel.setBounds(40, 30, 290, 14);
        contentPanel.add(salveremLabel);
        
        JButton btnSalvar = new JButton("...");
        btnSalvar.setBounds(330, 50, 30, 25);
        contentPanel.add(btnSalvar);
        
        dirsalvar = new JTextField();
        dirsalvar.setBounds(40, 50, 290, 25);
        contentPanel.add(dirsalvar);
        dirsalvar.setColumns(10);
        
        JLabel statusLabel = new JLabel("Status...");
        statusLabel.setVerticalAlignment(SwingConstants.TOP);
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusLabel.setBounds(40, 113, 410, 117);
        contentPanel.add(statusLabel);
        statusLabel.setForeground(Color.GREEN);
        
        txtStatus = new JTextField();
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
        
        try {
            super.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (Exception e) {
                e.printStackTrace();
        }
        setLocationRelativeTo(null);
    }
}
