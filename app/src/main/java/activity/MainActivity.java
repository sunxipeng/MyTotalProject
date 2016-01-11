package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fragment.ContentFragment;
import fragment.MoiveFragment;
import com.sunxipeng.mytotalproject.R;
import com.sunxipeng.viewpagerindicator.TabPageIndicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.WYNewsAdapter;

public class MainActivity extends FragmentActivity implements Callback{

    private static final String[] CONTENT = new String[] { "菜谱", "电影", "体育", "财经" };

    List<Fragment> fragments = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //设置布局无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        findView();

        fragments.add(new ContentFragment());
        fragments.add(new MoiveFragment());
        fragments.add(new ContentFragment());
        fragments.add(new MoiveFragment());
    }

    private void findView() {

        FragmentPagerAdapter adapter = new WYNewsAdapter(getSupportFragmentManager(),fragments,CONTENT);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    @Override
    public void onFailure(Request request, IOException e) {

    }

    @Override
    public void onResponse(Response response) throws IOException {

    }


}
