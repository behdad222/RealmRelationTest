package behdad222.realmrelationtest.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class CategoryModel extends RealmObject {
    private String serverId;
    private String name;
    private String imageURL;
    private String description;
    private String tabId;
    private String tabName;
    private RealmList<ProductModel> products;

    public CategoryModel(
            String serverId,
            String name,
            String imageURL,
            String description,
            String tabId,
            String tabName) {

        this.serverId = serverId;
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
        this.tabId = tabId;
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public RealmList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(RealmList<ProductModel> products) {
        this.products = products;
    }
}
