/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
*/

import com.github.axet.vget.VGet;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author MI
 */
public class Frissites {

    indit inn;
    String path;

    public Frissites(indit inn_, String path_) {
        inn = inn_;
        path = path_;
    }

    public void downLoadMusic() {
        try {
            String sql = "select video from videok where engedely = 1 and letoltve = 0;";
            ResultSet rs = inn.leker(sql, 0);
            while (rs.next()) {
                String url = rs.getString("video");
                new getMusic(url, path);
            }
        } catch (Exception e) {
            System.out.println("Error - Frissites.downLoadMusic " + e.getMessage());
        }
    }

    class getMusic extends Thread {

        String url, path;

        public getMusic(String url_, String path_) {
            url = url_;
            path = path_;

            System.out.println(url);
            start();
        }

        @Override
        public void run() {
            try {
                String urrl = "https://www.youtube.com/watch?v=nD3fR6YiYS4";


                System.out.println(urrl == url);
                URL uri = new URL(url);
                VGet vget = new VGet(new URL(url), new File(path));
                vget.download();
            } catch (Exception ex) {
                Logger.getLogger(Frissites.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
