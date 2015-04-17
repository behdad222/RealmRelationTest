package behdad222.realmrelationtest.Model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/*
 * Created by behdad on 4/17/15.
 */

@RealmClass
public class ProductModel extends RealmObject {
    private String productServerId;
    private String productName;
    private String productImageURL;
    private int productTotalPages;
    private String productProducer;
    private String productPublisher;
    private String productDescription;
    private String productPower;
    private String productISBN;
    private String productPrice;
    private String productSize;
    private String productSummary;
    private String productKind;
    private String productCategory;
    private String productCreationDate;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductServerId() {
        return productServerId;
    }

    public void setProductServerId(String productServerId) {
        this.productServerId = productServerId;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public int getProductTotalPages() {
        return productTotalPages;
    }

    public void setProductTotalPages(int productTotalPages) {
        this.productTotalPages = productTotalPages;
    }

    public String getProductProducer() {
        return productProducer;
    }

    public void setProductProducer(String productProducer) {
        this.productProducer = productProducer;
    }

    public String getProductPublisher() {
        return productPublisher;
    }

    public void setProductPublisher(String productPublisher) {
        this.productPublisher = productPublisher;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPower() {
        return productPower;
    }

    public void setProductPower(String productPower) {
        this.productPower = productPower;
    }

    public String getProductISBN() {
        return productISBN;
    }

    public void setProductISBN(String productISBN) {
        this.productISBN = productISBN;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductSummary() {
        return productSummary;
    }

    public void setProductSummary(String productSummary) {
        this.productSummary = productSummary;
    }

    public String getProductKind() {
        return productKind;
    }

    public void setProductKind(String productKind) {
        this.productKind = productKind;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCreationDate() {
        return productCreationDate;
    }

    public void setProductCreationDate(String productCreationDate) {
        this.productCreationDate = productCreationDate;
    }

    public ProductModel(
            String productServerId,
            String productName,
            String productImageURL,
            int productTotalPages,
            String productProducer,
            String productPublisher,
            String productDescription,
            String productPower,
            String productISBN,
            String productPrice,
            String productSize,
            String productSummary,
            String productKind,
            String productCategory,
            String productCreationDate) {

        this.productServerId = productServerId;
        this.productName = productName;
        this.productImageURL = productImageURL;
        this.productTotalPages = productTotalPages;
        this.productProducer = productProducer;
        this.productPublisher = productPublisher;
        this.productDescription = productDescription;
        this.productPower = productPower;
        this.productISBN = productISBN;
        this.productPrice = productPrice;
        this.productSize = productSize;
        this.productSummary = productSummary;
        this.productKind = productKind;
        this.productCategory = productCategory;
        this.productCreationDate = productCreationDate;
    }
}
