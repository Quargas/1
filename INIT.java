import javax.swing.*;
import java.io.*;

/**
 * Created by MI on 2016. 10. 30..
 */
public class INIT {
    private final String fileName = "variables";
    private String MUSIC_PATH;
    private PrintWriter pw;
    private BufferedReader in;
    private String SERVER_ADDRESS;
    private int SERVER_PORT;
    private String MYSQL_SERVER;
    private String MYSQL_PW;
    private String MYSQL_ACC;

    public void readData() {
        File f = new File(fileName);
        if (!f.exists()) {
            try {
                pw = new PrintWriter(f);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String music__loc = JOptionPane.showInputDialog(null, "Music location?");
            String server_addr = JOptionPane.showInputDialog(null, "Server address?");
            String server_port = JOptionPane.showInputDialog(null, "Server PORT?");
            String mysql_s = JOptionPane.showInputDialog(null, "MYSQL Server?");
            String mysql_a = JOptionPane.showInputDialog(null, "MYSQL Account?");
            String mysql_pw = JOptionPane.showInputDialog(null, "MYSQL Password?");


            pw.println("path=" + music__loc);
            pw.println("address=" + server_addr);
            pw.println("port=" + server_port);

            pw.println("mysql_loc=" + mysql_s);
            pw.println("mysql_ac=" + mysql_a);
            pw.println("mysql_pw=" + mysql_pw);

            pw.flush();
            pw.close();
        }
        try {
            in = new BufferedReader(new FileReader(fileName));
            String tmp;
            while ((tmp = in.readLine()) != null) {
                if (tmp.contains("path=")) {
                    MUSIC_PATH = tmp.substring(tmp.indexOf("=") + 1);
                }
                if (tmp.contains("address=")) {
                    SERVER_ADDRESS = tmp.substring(tmp.indexOf("=") + 1);
                }

                if (tmp.contains("port=")) {             // '=' utáni rész
                    SERVER_PORT = Integer.parseInt(tmp.substring(tmp.indexOf("=") + 1));
                }

                if (tmp.contains("mysql_loc=")) {             // '=' utáni rész
                    MYSQL_SERVER = tmp.substring(tmp.indexOf("=") + 1);
                }
                if (tmp.contains("mysql_ac=")) {             // '=' utáni rész
                    MYSQL_ACC = tmp.substring(tmp.indexOf("=") + 1);
                }
                if (tmp.contains("mysql_pw=")) {             // '=' utáni rész
                    MYSQL_PW = tmp.substring(tmp.indexOf("=") + 1);
                }

            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error - INIt.INIT " + e.getMessage());
        }

    }

    public void resetData() {
        File f = new File(fileName);
        f.delete();
        readData();

    }

    public String MUSIC_PATH() {
        return MUSIC_PATH;
    }

    public String SERVER_ADDRESS() {
        return SERVER_ADDRESS;
    }

    public int SERVER_PORT() {
        return SERVER_PORT;
    }

    public String MYSQL_ADRESS() {
        return SERVER_ADDRESS;
    }

    public String MYSQL_ACCOUNT() {
        return MYSQL_ACC;
    }

    public String MYSQL_PW() {
        return MYSQL_PW;
    }

}


