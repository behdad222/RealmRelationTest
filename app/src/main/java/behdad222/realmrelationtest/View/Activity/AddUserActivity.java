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
import behdad222.realmrelationtest.Adapter.User2ProductAdapter;
import behdad222.realmrelationtest.Model.ProductModel;
import behdad222.realmrelationtest.Model.User2ProductModel;
import behdad222.realmrelationtest.Model.UserModel;
import behdad222.realmrelationtest.R;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class AddUserActivity extends Activity implements View.OnClickListener {
    private Realm realm;
    private Button save;
    private EditText id;
    private EditText name;
    private String userID;
    private RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private Button add;
    private RealmResults<UserModel> result;
    private ArrayList<User2ProductModel> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        userID = intent.getStringExtra("id");

        realm = Realm.getInstance(this);
        products = new ArrayList<>();

        save = (Button) findViewById(R.id.save);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        add = (Button) findViewById(R.id.add);

        recycleView = (RecyclerView) findViewById(R.id.recycler_view);
        recycleView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        adapter = new User2ProductAdapter(products, this, true, null);
        recycleView.setAdapter(adapter);


        add.setOnClickListener(this);
        save.setOnClickListener(this);

        if (userID != null) {
            result = realm
                    .where(UserModel.class)
                    .equalTo("serverID", userID).findAll();

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
                UserModel user = new UserModel();
                user.setServerID(id.getText().toString());
                user.setName(name.getText().toString());

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(user);
                realm.commitTransaction();

                finish();
                break;

            case R.id.add:
                for (int i = 0; i<3; i++) {
                    RealmResults<ProductModel> result1 = realm
                            .where(ProductModel.class)
                            .findAll();



                    User2ProductModel object = new User2ProductModel();
                    object.setMD5("md5 " + i);
                    object.setProduct(result1.get(i));



                    RealmResults<UserModel> result2 = realm
                            .where(UserModel.class)
                            .equalTo("serverID", userID).findAll();



                    RealmList<User2ProductModel> objects = new RealmList<>();
                    for (int j = 0; j<result2.size(); j++){
                        objects.add(result2.get(0).getProducts().get(j));
                    }
                    objects.add(object);
                    UserModel user1 = new UserModel();


                    user1.setProducts( objects);
                    user1.setName(result2.get(0).getName());
                    user1.setServerID(result2.get(0).getServerID());


                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(user1);
                    realm.commitTransaction();
                }

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
