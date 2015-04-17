package behdad222.realmrelationtest.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import behdad222.realmrelationtest.R;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button user;
    private Button category;
    private Button product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (Button) findViewById(R.id.user);
        category = (Button) findViewById(R.id.category);
        product = (Button) findViewById(R.id.product);

        user.setOnClickListener(this);
        category.setOnClickListener(this);
        product.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.user:
                i = new Intent (this, UserActivity.class);
                startActivity(i);
                break;

            case R.id.category:
                i = new Intent (this, UserActivity.class);
                startActivity(i);
                break;

            case R.id.product:
                i = new Intent (this, UserActivity.class);
                startActivity(i);
                break;
        }
    }
}
