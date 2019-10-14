package CRUD;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import me.marnic.jiconextract.extractor.IconSize;
import me.marnic.jiconextract.extractor.JIconExtractor;

public class strFile {

    private int id;
    private Path path;
    private File file;
    private ImageIcon icon;
    private String simpleName;
    private String type;

    public strFile(int id, File file) {
        this.id = id;
        this.path = file.toPath();
        this.file = file;
        
        if (file.isDirectory()) {
            this.simpleName = file.getName();
            this.type = "Directory";
        } else {
            String[] fileName = file.getName().split("\\.");
            this.simpleName = fileName[0];
            this.type = fileName[1];
        }
    }
    public strFile(File file) {
        this.path = file.toPath();
        this.file = file;
        
        if (file.isDirectory()) {
            this.simpleName = file.getName();
            this.type = "Directory";
        } else {
            String[] fileName = file.getName().split("\\.");
            this.simpleName = fileName[0];
            this.type = fileName[1];
        }
    }

    public int getId() {
        return id;
    }

    public Path getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }
    
    public ImageIcon getIcon(Dimension size) {
        if (type.equals("png") || type.equals("jpg") || type.equals("jpeg")|| type.equals("gif")) {
            ImageIcon icon = new ImageIcon(this.path.toString());
            return imageScaled(icon, size);
        }else if (type == "Directory") {
            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imgs/img-folder.png")));
            
            System.out.println("1");
            return imageScaled(icon, size);
        } else {
            BufferedImage image = JIconExtractor.getJIconExtractor().extractIconFromFile(this.file,IconSize.EXTRALARGE);
            return new ImageIcon(image);
        }
    }
    private ImageIcon imageScaled( ImageIcon image, Dimension boundary) {
        Dimension imageSize = new Dimension(image.getIconWidth(), image.getIconHeight());
        double widthRatio = boundary.getWidth() / imageSize.getWidth();
        double heightRatio = boundary.getHeight() / imageSize.getHeight();
        double ratio = Math.min(widthRatio, heightRatio);
        
        Dimension size =  new Dimension((int) (imageSize.width  * ratio),
                             (int) (imageSize.height * ratio));
        Image original = image.getImage();
        Image imageResize = original.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        return new ImageIcon(imageResize);
    }
    
    
    public String getSimpleName() {
        return simpleName;
    }
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getType() {
        return type;
    }
}
