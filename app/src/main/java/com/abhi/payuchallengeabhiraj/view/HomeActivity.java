package com.abhi.payuchallengeabhiraj.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.abhi.payuchallengeabhiraj.R;
import com.abhi.payuchallengeabhiraj.utilities.FragmentTransactionHelper;

/**
 *  Author: Abhiraj Khare
 *  Description: Main Activity which houses all the fragments in the application.
 */

public class HomeActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();
        FragmentTransactionHelper.switchFragment(this, R.id.content, KickListFragment.newInstance());
    }

    public void setActionBarHome(boolean flag) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(flag);
        getSupportActionBar().setHomeButtonEnabled(flag);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            setActionBarHome(false);
            return;
        }

        super.onBackPressed();
    }
}
