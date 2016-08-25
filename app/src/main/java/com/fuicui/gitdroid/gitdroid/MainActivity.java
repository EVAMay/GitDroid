package com.fuicui.gitdroid.gitdroid;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fuicui.gitdroid.gitdroid.github.HotRepoFragment;
import com.fuicui.gitdroid.gitdroid.github.HotRepoListFragment;
import com.fuicui.gitdroid.gitdroid.github.HotUserFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HotRepoListFragment hotRepolistFragment=new HotRepoListFragment();
    private HotRepoFragment hotRepoFragment=new HotRepoFragment();
    private HotUserFragment hotUserFragment=new HotUserFragment();
    private NavigationView navigationView_main;
    private Toolbar toolbar_main;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView_main= (NavigationView) findViewById(R.id.navigationView);
        toolbar_main= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar_main);
        toolbar_main.setTitle("");
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar_main,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);//drawerLayout与toolBar设置同步
        navigationView_main.setNavigationItemSelectedListener(this);
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        transaction.replace(R.id.container,hotRepoFragment);//设置默认是热门仓库
        transaction.commit();
    }

    /**
     * replaceFragment的方法
     * */
    private void replaceFragment(Fragment fragment){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // 将默认选中项“手动”设置为false
        if (item.isChecked()) {
            item.setChecked(false);
        }
        switch (item.getItemId()){
            case R.id.github_hot_repo://热门仓库
                if (!hotRepoFragment.isAdded()){
                    replaceFragment(hotRepoFragment);
                }
                break;
            case R.id.github_hot_coder://热门开发者
                if (!hotUserFragment.isAdded()){
                    replaceFragment(hotUserFragment);
                }
                break;
            case R.id.arsenal_my_repo: //我的收藏

                break;

            case R.id.tips_daily:// 每日干货

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);//关闭侧滑菜单


        // 返回true，代表将该菜单项变为checked状态
        return true;
    }

}
