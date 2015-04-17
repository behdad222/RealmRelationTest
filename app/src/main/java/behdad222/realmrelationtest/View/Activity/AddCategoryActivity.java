package behdad222.realmrelationtest.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import behdad222.realmrelationtest.Model.CategoryModel;
import behdad222.realmrelationtest.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class AddCategoryActivity extends Activity implements View.OnClickListener {
    private Realm realm;
    private Button save;
    private EditText id;
    private EditText name;
    private String categoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        categoryID = intent.getStringExtra("id");

        realm = Realm.getInstance(this);

        save = (Button) findViewById(R.id.save);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);

        save.setOnClickListener(this);

        if (categoryID != null) {
            RealmResults<CategoryModel> result = realm
                    .where(CategoryModel.class)
                    .equalTo("serverID", categoryID).findAll();

            id.setText(result.get(0).getServerID());
            name.setText(result.get(0).getName());
            id.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {

        CategoryModel category = new CategoryModel();
        category.setServerID(id.getText().toString());
        category.setName(name.getText().toString());

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(category);
        realm.commitTransaction();

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
