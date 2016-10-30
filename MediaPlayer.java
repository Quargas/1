import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;

import javax.swing.*;

/**
 * Created by MI on 2016. 10. 30..
 */
public class MediaPlayer {

    private final String MUSIC_PATH;
    EmbeddedMediaPlayerComponent mediaPlayerComponent;
    int musicCounter;
    private JFrame frame;
    private Zenek zenek;

    MediaPlayer(String Music_Path) {
        MUSIC_PATH = Music_Path;
        frame = new JFrame("RadioPlayer");
        frame.setBounds(1, 1, 6, 4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventListener() {
            public void mediaChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, libvlc_media_t libvlc_media_t, String s) {

            }

            public void opening(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void buffering(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, float v) {

            }

            public void playing(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void paused(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void stopped(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void forward(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void backward(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void finished(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {
                lul();
            }

            public void timeChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, long l) {

            }

            public void positionChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, float v) {

            }

            public void seekableChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void pausableChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void titleChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void snapshotTaken(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, String s) {

            }

            public void lengthChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, long l) {

            }

            public void videoOutput(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void scrambledChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void elementaryStreamAdded(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i, int i1) {

            }

            public void elementaryStreamDeleted(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i, int i1) {

            }

            public void elementaryStreamSelected(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i, int i1) {

            }

            public void corked(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, boolean b) {

            }

            public void muted(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, boolean b) {

            }

            public void volumeChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, float v) {

            }

            public void audioDeviceChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, String s) {

            }

            public void chapterChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void error(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void mediaMetaChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void mediaSubItemAdded(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, libvlc_media_t libvlc_media_t) {

            }

            public void mediaDurationChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, long l) {

            }

            public void mediaParsedChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void mediaFreed(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void mediaStateChanged(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void mediaSubItemTreeAdded(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, libvlc_media_t libvlc_media_t) {

            }

            public void newMedia(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }

            public void subItemPlayed(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void subItemFinished(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer, int i) {

            }

            public void endOfSubItems(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

            }
        });

        frame.setContentPane(mediaPlayerComponent);
        frame.setVisible(true);
        getZenek();


    }

    public void play(String source) {
        try {
            mediaPlayerComponent.getMediaPlayer().playMedia(MUSIC_PATH + "\\" + source);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getZenek() {
        try {
            zenek = new Zenek(MUSIC_PATH);
            musicCounter = zenek.Lejre.size();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void lul() {
        play();
    }

    public void play() {
        try {
            mediaPlayerComponent.getMediaPlayer().playMedia(zenek.Lejre.get(musicCounter - 1).eleresi_ut);

            System.out.println(musicCounter);
            musicCounter--;
            if (musicCounter == 0) {
                musicCounter = zenek.Lejre.size();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stop() {
        try {
            mediaPlayerComponent.getMediaPlayer().stop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void pause() {
        try {
            mediaPlayerComponent.getMediaPlayer().pause();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
