import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by MI on 2016. 10. 30..
 */
public class Zenek {
    public ArrayList<Zene> Lejre = new ArrayList<Zene>();

    Zenek(String path) {
        System.out.println(path);
        File[] f = new File(path).listFiles();
        Zene[] zene = new Zene[f.length];
        ArrayList<Integer> duplicated = new ArrayList<Integer>();
        for (int i = 0; i < f.length; i++) {
            String data[] = new String[3];
            String tmp = f[i].getName();


            data[0] = tmp.substring(0, tmp.lastIndexOf("."));      //név
            data[1] = tmp.substring(tmp.lastIndexOf("."));        //kiterjesztés
            data[2] = f[i].getAbsolutePath();                     //elérési útvonal

            zene[i] = new Zene(data);

        }

        for (int i = 0; i < zene.length; i++) {
            for (int j = 0; j < zene.length; j++) {
                //Nem tesztelt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (zene[i].cim.contains("video")) {
                    duplicated.add(i);
                }
                if (zene[i].cim.equals(zene[j].cim)) {

                    if (!zene[i].kiterjesztes.equals(zene[j].kiterjesztes)) {
                        if (zene[i].kiterjesztes.equals(".mp4"))
                            duplicated.add(i);


                    }
                }
            }

        }
        for (int x : duplicated
                ) {
            System.out.println(x);

        }
        ArrayList<Zene> kurva = new ArrayList<Zene>();
        ArrayList<Zene> kurva_anyad = new ArrayList<Zene>();

        for (Zene x : zene) {
            kurva.add(x);

        }
        for (int x : duplicated) {
            kurva_anyad.add(zene[x]);
        }
        Lejre = (ArrayList<Zene>) CollectionUtils.subtract(kurva, kurva_anyad);

        for (Zene x : Lejre) {
            System.out.println(x.cim + x.kiterjesztes);
        }


    }
}
