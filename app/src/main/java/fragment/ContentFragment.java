package fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.sunxipeng.mytotalproject.R;

import java.io.IOException;

import adapter.MenuAdapter;
import modle.Cookdish;
import modle.DishMenu;
import okhttputils.OkHttpUtils;
import okhttputils.ParseModle;

/**
 * Created by Administrator on 2016/1/11.
 */
public class ContentFragment extends BaseFragment implements Callback {

    private String TAG = "ContentFragment";

    ListView list_menu;

    String str = null;

    String url = "http://apis.juhe.cn/cook/query?key=0902a0f28dd3f28c2c6b73b74db94cd1&menu=%E9%B1%BC";

    @Override
    int getLayoutID() {

        return R.layout.test;
    }


    @Override
    protected void initView(View view) {


        OkHttpUtils.getInstanceOkHttpUtils().get(url, this, 0);

        list_menu = (ListView) view.findViewById(R.id.list_menu);



    }

    @Override
    protected void initData() {

    }


    @Override
    public void onFailure(Request request, IOException e) {


    }

    @Override
    public void onResponse(Response response) throws IOException {


            String str = response.body().string();

            final DishMenu dishMenu = ParseModle.getInstatceParceModle().parseResult(str, DishMenu.class);

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    list_menu.setAdapter(new MenuAdapter(getActivity(), dishMenu.data));

                    list_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Cookdish cookdish = dishMenu.data.get(position);

                        }
                    });
                }
            });



    }
}
