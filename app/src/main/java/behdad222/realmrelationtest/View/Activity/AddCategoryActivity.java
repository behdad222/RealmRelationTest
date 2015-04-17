package behdad222.realmrelationtest.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import behdad222.realmrelationtest.Adapter.ProductAdapter;
import behdad222.realmrelationtest.Model.CategoryModel;
import behdad222.realmrelationtest.Model.ProductModel;
import behdad222.realmrelationtest.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class AddCategoryActivity extends Activity implements View.OnClickListener {
    private Realm realm;
    private Button save;
    private Button add;
    private EditText id;
    private EditText name;
    private String categoryID;
    private RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<ProductModel> products;
    public static CategoryModel category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        categoryID = intent.getStringExtra("id");
        products = new ArrayList<>();

        realm = Realm.getInstance(this);

        save = (Button) findViewById(R.id.save);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);

        add = (Button) findViewById(R.id.add);

        recycleView = (RecyclerView) findViewById(R.id.recycler_view);
        recycleView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(products, this, true, null);
        recycleView.setAdapter(adapter);

        add.setOnClickListener(this);
        save.setOnClickListener(this);

        if (categoryID != null) {
            RealmResults<CategoryModel> result = realm
                    .where(CategoryModel.class)
                    .equalTo("serverID", categoryID).findAll();

            category = result.get(0);
            id.setText(result.get(0).getServerID());
            name.setText(result.get(0).getName());
            id.setEnabled(false);

            for (int i = 0; i < result.get(0).getProducts().size(); i++) {
                products.add(result.get(0).getProducts().get(i));
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                CategoryModel category = new CategoryModel();
                category.setServerID(id.getText().toString());
                category.setName(name.getText().toString());

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(category);
                realm.commitTransaction();

                finish();
                break;

            case R.id.add:
                Intent i = new Intent (this, ProductActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                i.putExtra("select", true);

                startActivity(i);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
