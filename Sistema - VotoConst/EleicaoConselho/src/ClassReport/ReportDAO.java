package ClassReport;

import ClassFactory.ConnectionFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportDAO {

    private String parametro1;
    private String parametro2;
    private String parametro3;
    private String parametro4;
    public ConnectionFactory conn;
    public java.sql.Connection connection;
    public static String caminhoSubReport = (ReportDAO.class.getResource("").getPath().toString());
    public static final String IMAGES_DIR = "/Relatorios";
    public static final String IMAGE_CANDIDATO_DEFAULT = IMAGES_DIR + "/user_icon";
    public static final String REPORT_EXTENSION_IMAGES = ".gif";
    
    private final String imagePath = ReportDAO.IMAGE_CANDIDATO_DEFAULT
            + ReportDAO.REPORT_EXTENSION_IMAGES;

  
    public String getParametro1() {
        return this.parametro1;
    }

    public void setParametro1(String parametro1) {
        this.parametro1 = parametro1;
    }

    public String getParametro2() {
        return this.parametro2;
    }

    public void setParametro2(String parametro2) {
        this.parametro2 = parametro2;
    }
    
     public String getParametro3() {
        return this.parametro3;
    }

    public void setParametro3(String parametro3) {
        this.parametro3 = parametro3;
    }
    
      public String getParametro4() {
        return this.parametro4;
    }

    public void setParametro4(String parametro4) {
        this.parametro4 = parametro4;
    }

    public void createConnection() {
        conn = new ConnectionFactory();
        connection = conn.useConnection();
    }

    //Gerar cédula
    public void gerarCedulaEleitoral1() {
        try {
            
            HashMap parametro = new HashMap();
            
            parametro.put("NOME", parametro1);
            parametro.put("SALA", parametro2);
            //parametro.put("IMAGE_CANDIDATO", readImageAsByteArray(imagePath));

            JasperReport report = (JasperReport) JRLoader.loadObject(ReportDAO.class.getResource("/Relatorios/Cedula1.jasper"));
            JasperPrint print = JasperFillManager.fillReport(report, parametro, connection);
            
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setTitle("Eleição Conselho Tutelar");
    
           // URL url = this.getClass().getResource("arquivo.png");
           // Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
           // viewer.setIconImage(imagemTitulo);
            
            viewer.setVisible(true);

        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e.getLocalizedMessage());
                    
            
        }
        

    }
    
     //Gerar cédula
    public void gerarCedulaEleitoral2() {
        try {
            
            HashMap parametro2 = new HashMap();
            
            parametro2.put("NOME", parametro3);
            parametro2.put("SALA", parametro4);
            //parametro.put("IMAGE_CANDIDATO", readImageAsByteArray(imagePath));

            JasperReport report2 = (JasperReport) JRLoader.loadObject(ReportDAO.class.getResource("/Relatorios/Cedula2.jasper"));
            JasperPrint print2 = JasperFillManager.fillReport(report2, parametro2, connection);
            
            JasperViewer viewer2 = new JasperViewer(print2, false);
            viewer2.setTitle("Eleição Conselho Tutelar");
    
           // URL url = this.getClass().getResource("arquivo.png");
           // Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
           // viewer.setIconImage(imagemTitulo);
            
            viewer2.setVisible(true);

        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e.getLocalizedMessage());
                    
            
        }
        

    }
    
    public byte[] readImageAsByteArray(String filename) throws IOException {   
        byte[] buffer = new byte[1024];   
        InputStream is = this.getClass().getResourceAsStream(filename);   
        ByteArrayOutputStream out = new ByteArrayOutputStream();   
        while (is.read(buffer) != -1)
            out.write(buffer);     
        return out.toByteArray();         
    }
}
