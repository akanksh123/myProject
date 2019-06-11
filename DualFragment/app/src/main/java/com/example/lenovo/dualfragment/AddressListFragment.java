package com.example.lenovo.dualfragment;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddressListFragment extends ListFragment {
    private ActivityComs mActivityComs;
    private ArrayList<NameAndAddress2>mNameAndAddress;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivityComs=(ActivityComs)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs=null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mActivityComs.onListItemSelected(position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameAndAddress=AdressBook.getInstance().getBook();
        AddressListAdapter adapter=new AddressListAdapter(mNameAndAddress);
        setListAdapter(adapter);
    }
    private class AddressListAdapter extends ArrayAdapter<NameAndAddress2>{

        public AddressListAdapter(ArrayList<NameAndAddress2> nameAndAddress) {
            super(getActivity(),R.layout.list_item,nameAndAddress);
        }


        @Override
        public View getView(int position,View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater inflater=(LayoutInflater)getActivity().getLayoutInflater();
                convertView=inflater.inflate(R.layout.list_item,null);

            }
            NameAndAddress2 tempNameAndAddress=getItem(position);
            TextView txtName=(TextView)convertView.findViewById(R.id.txtName);
            txtName.setText(tempNameAndAddress.getName());
            return convertView;

        }
    }
}