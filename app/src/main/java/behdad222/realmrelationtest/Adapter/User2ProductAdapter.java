package behdad222.realmrelationtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.realmrelationtest.Model.CategoryModel;
import behdad222.realmrelationtest.Model.User2ProductModel;
import behdad222.realmrelationtest.R;

public class User2ProductAdapter extends RecyclerView.Adapter<User2ProductAdapter.ViewHolder> {
    private ArrayList<User2ProductModel> products;
    private Context context;
    private boolean select;
    private CategoryModel category;

    public User2ProductAdapter(ArrayList<User2ProductModel> products, Context context, boolean select, CategoryModel category) {
        this.products = products;
        this.context = context;
        this.select = select;
        this.category = category;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView md5;

        public ViewHolder(View v) {
            super(v);
            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            md5 = (TextView) itemView.findViewById(R.id.md5);
        }
    }

    @Override
    public User2ProductAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User2ProductModel product = products.get(position);
        holder.id.setText(product.getProduct().getServerID());
        holder.name.setText(product.getProduct().getName());
        holder.md5.setText(product.getMD5());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
