package behdad222.realmrelationtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.realmrelationtest.Model.CategoryModel;
import behdad222.realmrelationtest.R;
import behdad222.realmrelationtest.View.Activity.AddCategoryActivity;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryModel> categorys;
    private Context context;

    public CategoryAdapter(ArrayList<CategoryModel> categorys, Context context) {
        this.categorys = categorys;
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
            Intent intent = new Intent(context, AddCategoryActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("id", categorys.get(getPosition()).getServerID());
            context.startActivity(intent);
        }
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryModel category = categorys.get(position);
        holder.id.setText(category.getServerID());
        holder.name.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categorys.size();
    }
}
