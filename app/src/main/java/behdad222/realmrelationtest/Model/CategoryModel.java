package behdad222.realmrelationtest.Model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/*
 * Created by behdad on 4/17/15.
 */

@RealmClass
public class CategoryModel extends RealmObject {
    private String categoryServerId;
    private String categoryName;
    private String categoryImageURL;
    private String categoryDescription;
    private String tabId;
    private String tabName;

    public CategoryModel(String categoryServerId, String categoryName, String categoryImageURL, String categoryDescription, String tabId, String tabName) {
        this.categoryServerId = categoryServerId;
        this.categoryName = categoryName;
        this.categoryImageURL = categoryImageURL;
        this.categoryDescription = categoryDescription;
        this.tabId = tabId;
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryImageURL() {
        return categoryImageURL;
    }

    public void setCategoryImageURL(String categoryImageURL) {
        this.categoryImageURL = categoryImageURL;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryServerId() {
        return categoryServerId;
    }

    public void setCategoryServerId(String categoryServerId) {
        this.categoryServerId = categoryServerId;
    }
}
