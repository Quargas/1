

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class indit {

    int valtozo;
    private String address;
    private Connection conn;
    private String userName;
    private boolean connected = false;
    private String error = "";

    indit(String url_) {
        address = url_;
    }

    public boolean startConnection(String us, String pw) {
        //String url = "jdbc:mysql://db.multipixel.hu/";
        String url = "jdbc:mysql://" + address + "/";
        String dbName = "video";
        String driver = "com.mysql.jdbc.Driver";
        userName = us;
        try {
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(url + dbName + "?useUnicode=yes&characterEncoding=UTF-8", us, pw);//csatlakozás
            System.out.println("Connected to the database");
            connected = true;
            return true;
        } catch (Exception e) {
            System.out.println("NO CONNECTION =(" + e + ")");
            error = e.toString();
            connected = false;
            return false;
        }
    }

    public boolean conn() {
        return connected;
    }


    public ResultSet leker(String sql, int a) throws SQLException {
        ResultSet rs;
        // create the java statement
        java.sql.Statement st = this.conn.createStatement();
        if (a == 0) {
            rs = st.executeQuery(sql);
            return rs;
        } else {
            st.executeUpdate(sql);

        }
        return null;
    }

    public String getUsername() {
        return userName;
    }

}
