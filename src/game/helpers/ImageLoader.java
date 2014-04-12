package game.helpers;

/**
 * Created by pawel on 08/04/14.
 * Class for loading images for cards
 * takes path to the folder with images
 */

import javax.annotation.processing.FilerException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class ImageLoader {
    File DIR ;

    public ImageLoader(String path) {
        DIR = new File(path);
    }

    String[] EXTENSIONS = new String[] {"gif", "png", "bmp"};

    FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            for(String ext: EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return true;
                }
            }
            return false;
        }
    };
    /*
    * get names of all images form path folder
    * returns them with extnesions
    * for example: 'image1.jpg'
    * */
    public ArrayList<String> getImageNames() {
        ArrayList<String> imageNames = new ArrayList<String>();
        if (DIR.isDirectory()) {
            for (File f : DIR.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    imageNames.add(f.getName());
                } catch (Exception e) {
                    //add handling code here
                    e.printStackTrace();
                }
            }
        }
        return imageNames;
    }

}
