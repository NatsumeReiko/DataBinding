package pj.nj.bding.bding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pj.nj.bding.R;
import pj.nj.bding.model.User;
import pj.nj.bding.databinding.ListItemRowBdingBinding;

public class DataBindingActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new UserAdapter(User.getUsers()));
    }

    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

        private List<User> mUsers = new ArrayList<>();

        public UserAdapter(@NonNull List<User> users) {
            mUsers.addAll(users);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ListItemRowBdingBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_row_bding, parent, false);
            return new ViewHolder(binding);
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
            private ListItemRowBdingBinding mBinding;
            public ViewHolder(ListItemRowBdingBinding binding) {
                super(binding.getRoot());
                mBinding = binding;
            }

            public void bind(@NonNull User user) {
                mBinding.setUser(user);
                mBinding.executePendingBindings();
            }
        }
    }
}
