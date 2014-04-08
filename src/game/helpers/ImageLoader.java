package game.helpers;

/**
 * Created by pawel on 08/04/14.
 */

import javax.annotation.processing.FilerException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class ImageLoader  {
    private File DIR;
    static final String[] EXTENSIONS = new String[] {"gif", "png", "bmp"};
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            for(final String ext: EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return true;
                }
            }
            return false;
        }
    };

    public ImageLoader(String DIR) {

        this.DIR = new File(DIR);
    }


    public ArrayList<String> getListOfImageNames() {
        ArrayList<String> imagesNames = new ArrayList<String>();
        if(DIR.isDirectory()) {
            for(File f: DIR.listFiles()) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    imagesNames.add(f.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return imagesNames;
    }

}
