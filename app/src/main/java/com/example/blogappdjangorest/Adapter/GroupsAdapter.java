package com.example.blogappdjangorest.Adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogappdjangorest.Fragment.GroupPostFragment;
import com.example.blogappdjangorest.Fragment.HomeFragment;
import com.example.blogappdjangorest.Models.RetrofitModels.GroupListResponse;
import com.example.blogappdjangorest.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupItemHolder> {
    private Context mContext;
    ArrayList<GroupListResponse> responses;
    androidx.fragment.app.FragmentManager fm;




    public GroupsAdapter(Context context, ArrayList<GroupListResponse> responses){
        mContext = context;
        fm =((FragmentActivity) mContext).getSupportFragmentManager();
        this.responses=responses;
    }

    @NonNull
    @Override
    public GroupItemHolder onCreateViewHolder (@NonNull ViewGroup parent,
                                                 int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.groups_item_layout, parent, false);
        return new GroupItemHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull GroupItemHolder holder,final int position){
        setOnClickListener(holder, position);
        holder.group_name.setText(responses.get(position).getGroup_description());

    }

    private void setOnClickListener(final GroupItemHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.homescreenfragment,new GroupPostFragment()).addToBackStack("Groups").commit();

            }
        });
    }


    @Override
    public int getItemCount () {
        return responses.size();

    }

    @Override
    public long getItemId ( int position){
        return position;
    }

    @Override
    public int getItemViewType ( int position){
        return position;
    }

    class GroupItemHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView group_name;

        private GroupItemHolder(@NonNull View itemView) {
            super(itemView);
            setGlobals(itemView);
            //setOnClickListeners();

            image=itemView.findViewById(R.id.group_image);
            group_name=itemView.findViewById(R.id.group_name);

        }

        private void setGlobals(View itemView) {

        }

    }
}
