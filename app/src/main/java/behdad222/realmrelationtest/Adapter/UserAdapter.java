package behdad222.realmrelationtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.realmrelationtest.Model.UserModel;
import behdad222.realmrelationtest.R;
import behdad222.realmrelationtest.View.Activity.AddUserActivity;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserModel> users;
    private Context context;

    public UserAdapter(ArrayList<UserModel> users, Context context) {
        this.users = users;
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
            intent.putExtra("id", users.get(getPosition()).getServerID());
            context.startActivity(intent);
        }
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModel user = users.get(position);
        holder.id.setText(user.getServerID());
        holder.name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
