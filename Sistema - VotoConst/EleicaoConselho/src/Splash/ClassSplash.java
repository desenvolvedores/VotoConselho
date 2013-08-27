package Splash;

import ClassFactory.ConnectionFactory;
import Form.FormCadastroEleitor;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ClassSplash extends JWindow {

    AbsoluteLayout absoluto;
    AbsoluteConstraints absImagem, absBarra, absTexto;
    ImageIcon imagem;
    JLabel jlabel, jlabel2;
    JProgressBar barra;

    public ClassSplash() {

        absoluto = new AbsoluteLayout();
        absImagem = new AbsoluteConstraints(0, 0);
        absBarra = new AbsoluteConstraints(2, 240);
        absTexto = new AbsoluteConstraints(10, 260);
        imagem = new ImageIcon(this.getClass().getResource("splash02.jpg"));
        barra = new JProgressBar();
        //  barra.setBackground(new Color(228,153,13));
        barra.setForeground(Color.darkGray);
        barra.setPreferredSize(new Dimension(296, 18));
        jlabel = new JLabel();
        jlabel2 = new JLabel();
        jlabel2.setText("Carregando módulos. Aguarde...");
        jlabel2.setForeground(Color.BLACK);
        jlabel.setIcon(imagem);
        this.getContentPane().setLayout(absoluto);
        this.getContentPane().add(barra, absBarra);
        this.getContentPane().add(jlabel2, absTexto);
        this.getContentPane().add(jlabel, absImagem);
        final ConnectionFactory connection = new ConnectionFactory();


        /////////////////////// Formato - Localização - Ícone ///////////////////
        try {

            NimRODTheme nt = new NimRODTheme("hab.theme");
            NimRODLookAndFeel nf = new NimRODLookAndFeel();
            nf.setCurrentTheme(nt);
            UIManager.setLookAndFeel(nf);

            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////////////////////////////////////////////////////////////////////////////

        new Thread() {

            public void run() {
                int i = 0;
                while (i < 31) {
                    barra.setValue(i);
                    i++;
                    jlabel2.setText("Carregando módulos. Aguarde... " + i + "%");
                    try {
                        sleep(80);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClassSplash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    connection.getConnection();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                while (i < 51) {
                    barra.setValue(i);
                    i++;

                    jlabel2.setText("Carregando banco de dados. Aguarde... " + i + "%");

                    try {
                        sleep(150);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClassSplash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }


                while (i <= 99) {
                    barra.setValue(i);
                    i++;
                    jlabel2.setText("Abrindo sistema. Aguarde... " + i + "%");

                    try {
                        sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClassSplash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                dispose();
                FormCadastroEleitor C = new FormCadastroEleitor();
                C.setVisible(true);

            }
        }.start();

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new ClassSplash();

    }
}
