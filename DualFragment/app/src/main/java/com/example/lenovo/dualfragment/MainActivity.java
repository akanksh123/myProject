package com.example.lenovo.dualfragment;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContainer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements ActivityComs{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualfragment);
    }
    public void onListItemSelected(int position){
        if(findViewById(R.id.detailFragmentHolder)==null){
            Intent i=new Intent(this,PortraitDetailActivity.class);
            i.putExtra("Position",position);
            startActivity(i);
        }
        else
        {
            FragmentManager fmanager=  getFragmentManager();
            FragmentTransaction fTransaction=fmanager.beginTransaction();
            Fragment fragOld=fmanager.findFragmentById(R.id.detailFragmentHolder);
            Fragment fragNew=AddressDetailFragment.newInstance(position);
            if (fragOld!=null)
            {
                fTransaction.remove(fragOld);
            }
            fTransaction.add(R.id.detailFragmentHolder,fragNew);
            fTransaction.commit();


        }
    }


}


