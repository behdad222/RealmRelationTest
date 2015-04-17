package behdad222.realmrelationtest.Model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class User2ProductModel extends RealmObject {
    private String MD5;
    private String encryptedMD5;
    private int status;
    private int localStatus;
    private int currentPage;
    private String lastRead;
    private ProductModel product;

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getEncryptedMD5() {
        return encryptedMD5;
    }

    public void setEncryptedMD5(String encryptedMD5) {
        this.encryptedMD5 = encryptedMD5;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLocalStatus() {
        return localStatus;
    }

    public void setLocalStatus(int localStatus) {
        this.localStatus = localStatus;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getLastRead() {
        return lastRead;
    }

    public void setLastRead(String lastRead) {
        this.lastRead = lastRead;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
