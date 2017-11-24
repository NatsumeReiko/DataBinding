package pj.nj.bding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pj.nj.bding.model.User;

public class NormalActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new UserAdapter(User.getUsers()));
    }


    public static class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

        private List<User> mUsers = new ArrayList<>();

        public UserAdapter(@NonNull List<User> users) {
            mUsers.addAll(users);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.list_item_row_normal, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            User user = mUsers.get(position);
            holder.bind(user);
        }

        @Override
        public int getItemCount() {
            return mUsers.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mFirstName, mLastName;

            public ViewHolder(View itemView) {
                super(itemView);
                mFirstName = (TextView) itemView.findViewById(R.id.firstName);
                mLastName = (TextView) itemView.findViewById(R.id.lastName);
            }

            public void bind(User user) {
                mFirstName.setText(user.getFirstName());
                mLastName.setText(user.getLastName());
            }
        }
    }
}
