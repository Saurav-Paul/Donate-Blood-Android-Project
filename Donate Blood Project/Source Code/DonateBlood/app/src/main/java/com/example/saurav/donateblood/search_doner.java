package com.example.saurav.donateblood;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class search_doner extends Fragment {

    Button ap,ane,bp,bne,abp,abne,op,oneg;
    Globals globals=Globals.getInstance();


    public search_doner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_search_doner, container, false);

        ap=v.findViewById(R.id.search_Apositive);
        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("A+");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        ane=v.findViewById(R.id.search_Anegative);
        ane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("A-");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        bp=v.findViewById(R.id.search_Bpositive);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("B+");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        bne=v.findViewById(R.id.search_Bnegative);
        bne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("B-");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        abp=v.findViewById(R.id.search_ABpositive);
        abp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("AB+");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        abne=v.findViewById(R.id.search_ABnegative);
        abne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("AB-");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        op=v.findViewById(R.id.search_Opositive);
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("O+");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        oneg=v.findViewById(R.id.search_Onegative);
        oneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globals.setValue("O-");
                startActivity(new Intent(getActivity(),bloodGroupList.class));

            }
        });

        return v;
    }

}
