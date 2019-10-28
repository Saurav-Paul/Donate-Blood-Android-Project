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

public class DonorList extends ArrayAdapter<Donor> {

    private Activity context;
    private List<Donor>donorList;

    public DonorList( Activity context, List<Donor> donorList) {
        super(context, R.layout.searchlistview,donorList);
        this.context = context;
        this.donorList = donorList;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();

        View listViewItem=layoutInflater.inflate(R.layout.searchlistview,null,true);

        TextView userName=listViewItem.findViewById(R.id.searchName);
        TextView userInterest=listViewItem.findViewById(R.id.searchInterest);
        final Donor donor = donorList.get(position);
        userName.setText(donor.getUserName());
        userInterest.setText("Interest : "+donor.getUserInterest());
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),donor.getUserName(),Toast.LENGTH_SHORT).show();

                //creating alert dialog

                LayoutInflater inflater=LayoutInflater.from(getContext());
                View view=inflater.inflate(R.layout.alert_dialog,null);
                AlertDialog.Builder alertdialog= new AlertDialog.Builder(getContext());
                alertdialog.setView(view);
                //alertdialog.setCancelable(false);

                TextView cName,cage,cInterest,clastTime,cEmail,cTotal,cContact,cFb;

                cName=view.findViewById(R.id.c_profile_name);
                cName.setText("Name : "+donor.getUserName());

                cage=view.findViewById(R.id.c_profile_age);
                cage.setText("Age : "+donor.getUserAge());

                cInterest=view.findViewById(R.id.c_profile_interest);
                cInterest.setText("Interest to Donate : "+donor.getUserInterest());

                clastTime=view.findViewById(R.id.c_profile_lasttime);
                clastTime.setText("Last Donation Date : "+donor.getUserLastTimeDonation());

                cEmail=view.findViewById(R.id.c_profile_email);
                cEmail.setText("Email : "+donor.getUseremail());

                cTotal=view.findViewById(R.id.c_profile_total);
                cTotal.setText("Total Donation : "+donor.getUserTotalDonate());

                cContact=view.findViewById(R.id.c_profile_contact);
                cContact.setText("Contact : "+donor.getUserNumber());

                cFb=view.findViewById(R.id.c_profile_fb);
                cFb.setText("Facebook Profile : "+ donor.getUserFb());



               /*

                alertdialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                */
                alertdialog.create();
                alertdialog.show();




            }
        });

        return  listViewItem;
    }
}
