package com.example.saurav.donateblood;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class PostList extends ArrayAdapter<BlogPost> {

    private Activity context;
    private List<BlogPost>postList;

    public PostList( Activity context, List<BlogPost> donorList) {
        super(context, R.layout.searchlistview,donorList);
        this.context = context;
        this.postList = donorList;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();

        View listViewItem=layoutInflater.inflate(R.layout.post_row,null,true);


        final BlogPost blogpost = postList.get(getCount()-position-1);

        TextView userName=listViewItem.findViewById(R.id.post_username);
        userName.setText(blogpost.getUsername()+" posted it.");

        TextView userposttitle=listViewItem.findViewById(R.id.new_post_titile);
        userposttitle.setText(blogpost.getTitle());

        TextView userpostdesc=listViewItem.findViewById(R.id.new_post_des);
        userpostdesc.setText(blogpost.getPost());

        TextView userposttime=listViewItem.findViewById(R.id.post_time);
        userposttime.setText(blogpost.getTime());

        TextView userpostdate=listViewItem.findViewById(R.id.post_date);
        userpostdate.setText(blogpost.getDate());


        return  listViewItem;
    }
}
