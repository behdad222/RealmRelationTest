package behdad222.realmrelationtest.View.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import behdad222.realmrelationtest.R;
import io.realm.Realm;

public class AddUserActivity extends Activity implements View.OnClickListener {
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        realm = Realm.getInstance(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
