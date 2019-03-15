package com.junipersys.fragmentspractice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean is_tablet = getResources().getBoolean(R.bool.is_tablet);

        if (!is_tablet) {
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                ListFragment listFragment = new ListFragment();
                FragmentManager fragman = getSupportFragmentManager();
                FragmentTransaction fragtrans = fragman.beginTransaction();
                fragtrans.add(R.id.placeholder, listFragment, LIST_FRAGMENT);
                fragtrans.commit();
            }
        } else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                GridFragment gridFragment = new GridFragment();
                FragmentManager fragman = getSupportFragmentManager();
                FragmentTransaction fragtrans = fragman.beginTransaction();
                fragtrans.add(R.id.placeholder, gridFragment, LIST_FRAGMENT);
                fragtrans.commit();
            }
        }


    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        viewPagerFragment.setArguments(bundle);
        FragmentManager fragman = getSupportFragmentManager();
        FragmentTransaction fragtrans = fragman.beginTransaction();
        fragtrans.replace(R.id.placeholder, viewPagerFragment, VIEWPAGER_FRAGMENT);
        fragtrans.addToBackStack(null);
        fragtrans.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DuelPaneFragment viewPagerFragment = new DuelPaneFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        viewPagerFragment.setArguments(bundle);
        FragmentManager fragman = getSupportFragmentManager();
        FragmentTransaction fragtrans = fragman.beginTransaction();
        fragtrans.replace(R.id.placeholder, viewPagerFragment, VIEWPAGER_FRAGMENT);
        fragtrans.addToBackStack(null);
        fragtrans.commit();
    }
}
