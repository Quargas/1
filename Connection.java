import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by MI on 2016. 10. 30..
 */
public class Connection {
    final private String address;
    final private int port;
    private Socket s;
    private String order;
    private DataHandLer dh;

    Connection(final String address_, int port_, DataHandLer dh_) {
        this.address = address_;
        this.port = port_;
        this.dh = dh_;

        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {

                        s = new Socket(address, port);
                        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

                        while (true) {
                            String command = in.readLine();
                            System.out.println(" " + command);
                            dh.handle(command);
                        }
                    } catch (IOException e) {
                        System.out.println("Error - Connection.Connection --->" + e.getMessage());
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t.start();
    }


}
