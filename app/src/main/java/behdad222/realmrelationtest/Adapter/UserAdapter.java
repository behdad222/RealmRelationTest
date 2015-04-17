package behdad222.realmrelationtest.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import behdad222.realmrelationtest.Model.UserModel;
import behdad222.realmrelationtest.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserModel> users;


    public UserAdapter(ArrayList<UserModel> users) {
        this.users = users;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;

        public ViewHolder(View v) {
            super(v);
            id = (TextView) itemView.findViewById(R.id.id);
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
        UserModel object = users.get(position);
        holder.id.setText(object.getServerID());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
