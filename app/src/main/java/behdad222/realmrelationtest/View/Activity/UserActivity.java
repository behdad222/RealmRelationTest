package behdad222.realmrelationtest.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import behdad222.realmrelationtest.Adapter.UserAdapter;
import behdad222.realmrelationtest.Model.UserModel;
import behdad222.realmrelationtest.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class UserActivity extends Activity implements View.OnClickListener {
    private RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private Realm realm;
    private ArrayList<UserModel> users;

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        realm = Realm.getInstance(this);
        users = new ArrayList<>();

        add = (Button) findViewById(R.id.add);

        recycleView = (RecyclerView) findViewById(R.id.recycler_view);
        recycleView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);

        adapter = new UserAdapter(users, this);
        recycleView.setAdapter(adapter);

        RealmResults<UserModel> result = realm
                .where(UserModel.class)
                .findAll();

        for (int i = 0; i < result.size(); i++) {
            users.add(result.get(i));
        }

        adapter.notifyDataSetChanged();

        add.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, AddUserActivity.class);
        startActivity(i);
    }
}