package com.tangpj.recyclerdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tangpj.recyclerdemo.model.UserModel;
import com.tangpj.recyclerutils.SimpleAdapter;


/**
 * @ClassName: UserAdapter
 * @author create by Tang
 * @date date 17/1/23 上午11:57
 * @Description: TODO
 */

public class UserAdapter extends SimpleAdapter<UserModel>{

    @Override
    public RecyclerView.ViewHolder onCreateNormalView(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserHolder(view);
    }

    @Override
    public void onBindNormalView(RecyclerView.ViewHolder normalHolder, int position, UserModel value) {
        ((UserHolder) normalHolder).name.setText(value.user.name);
        ((UserHolder) normalHolder).age.setText(value.user.age + "");
        ((UserHolder) normalHolder).sex.setText(value.user.sex);
    }

    @Override
    public int setHeaderView() {
        return R.layout.header_user;
    }

    @Override
    public int setFooterView() {
        return R.layout.footer_user;
    }

    @Override
    public void onBindHeaderView(View header, int position) {
        header.findViewById(R.id.header_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v,"点击Header上的Button",Snackbar.LENGTH_SHORT).show();
                    }
        });
    }

    @Override
    public void onBindFooterView(View footer, int position) {
        footer.findViewById(R.id.footer_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v,"点击Footer上的Button",Snackbar.LENGTH_SHORT).show();
                    }
                });
    }

    private class UserHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView age;
        TextView sex;

        public UserHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_user_name);
            age = (TextView) itemView.findViewById(R.id.item_user_age);
            sex = (TextView) itemView.findViewById(R.id.item_user_sex);
        }
    }

}
