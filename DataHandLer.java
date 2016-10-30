
/**
 * Created by MI on 2016. 10. 30..
 */
public class DataHandLer {
    private MediaPlayer mediaPlayer;
    private Frissites frissites;
    private INIT init;
    private indit inn;

    DataHandLer(MediaPlayer mediaPlayer_, INIT init_) {
        this.mediaPlayer = mediaPlayer_;
        this.init = init_;
        inn = new indit(init.MYSQL_ADRESS());
        inn.startConnection(init.MYSQL_ACCOUNT(), init.MYSQL_PW());
        frissites = new Frissites(inn, init.MUSIC_PATH());
    }


    public void handle(String command) {
        System.out.println(command);
        if (!command.equals("") || command.equals(" ") || command.equals(null)) {
            if (command.contains("play")) {
                if (command.contains("=")) {
                    mediaPlayer.play("");
                } else {
                    mediaPlayer.play();
                }

            }

            if (command.contains("stop")) {
                mediaPlayer.stop();
            }

            if (command.contains("pause")) {
                mediaPlayer.pause();
            }
            if (command.contains("next")) {

            }

            if (command.contains("previous")) {

            }

            if (command.contains("download")) {
                frissites.downLoadMusic();
                mediaPlayer.getZenek();
            }
            if (command.contains("refresh")) {
                mediaPlayer.getZenek();
            }

        }

    }
}
