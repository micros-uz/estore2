package uz.micros.estore.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.util.PathHelper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService  {

    @Autowired
    private PathHelper pathHelper;

    public void saveBookImage(int bookId, byte[] content) {
        String s = pathHelper.getPath();
        Path path = Paths.get(s, bookId + "-uploaded.jpg");
        try {
            File file = new File(path.toString());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
            stream.write(content);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
