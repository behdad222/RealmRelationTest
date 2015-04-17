package behdad222.realmrelationtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.realmrelationtest.Model.ProductModel;
import behdad222.realmrelationtest.R;
import behdad222.realmrelationtest.View.Activity.AddUserActivity;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<ProductModel> products;
    private Context context;

    public ProductAdapter(ArrayList<ProductModel> products, Context context) {
        this.products = products;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id;
        TextView name;

        public ViewHolder(View v) {
            super(v);
            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, AddUserActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("id", products.get(getPosition()).getServerID());
            context.startActivity(intent);
        }
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductModel product = products.get(position);
        holder.id.setText(product.getServerID());
        holder.name.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
