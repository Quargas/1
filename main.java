import uk.co.caprica.vlcj.discovery.NativeDiscovery;


public class main {


    public static void main(String args[]) {

        boolean found = new NativeDiscovery().discover();                                //VLC megkeresése
        final INIT init = new INIT();                                                    //Server,Zene változók létrehozása,beolvasása
        init.readData();                                                                 //
        MediaPlayer mediaPlayer = new MediaPlayer(init.MUSIC_PATH());                    //VLC mediaplyer
        DataHandLer dh = new DataHandLer(mediaPlayer, init);                                   //Kezeli a bejövő parancsokat
        Connection c = new Connection(init.SERVER_ADDRESS(), init.SERVER_PORT(), dh);     //MEgadott címre,porton csatlakozik, DH-nak adja a parancsot
        System.out.println("k");


    }


}




