package uz.micros.estore.service.impl.store;

import org.springframework.stereotype.Service;
import uz.micros.estore.service.intf.store.FileService;

import java.io.*;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void saveBookImage(int bookId, byte[] content) {

        try {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(bookId + "-uploaded.jpg")));
            stream.write(content);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
