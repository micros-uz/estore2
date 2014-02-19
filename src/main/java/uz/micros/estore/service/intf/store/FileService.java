package uz.micros.estore.service.intf.store;

public interface FileService {
    void saveBookImage(int bookId, byte[] content);
}
