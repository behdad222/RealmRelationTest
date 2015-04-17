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

import behdad222.realmrelationtest.Model.ProductModel;
import behdad222.realmrelationtest.Model.UserModel;
import behdad222.realmrelationtest.R;
import io.realm.Realm;
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
    private ArrayList<ProductModel> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        userID = intent.getStringExtra("id");

        realm = Realm.getInstance(this);

        save = (Button) findViewById(R.id.save);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        recycleView = (RecyclerView) findViewById(R.id.recycler_view);
        recycleView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);


        save.setOnClickListener(this);

        if (userID != null) {
            RealmResults<UserModel> result = realm
                    .where(UserModel.class)
                    .equalTo("serverID", userID).findAll();

            id.setText(result.get(0).getServerID());
            name.setText(result.get(0).getName());
            id.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {

        UserModel user = new UserModel();
        user.setServerID(id.getText().toString());
        user.setName(name.getText().toString());

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
