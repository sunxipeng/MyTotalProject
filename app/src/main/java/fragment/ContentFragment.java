package fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.sunxipeng.mytotalproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Administrator on 2016/1/11.
 */
public class ContentFragment extends BaseFragment implements Callback{

    private String TAG = "ContentFragment";

    TextView textView;

    String str = null;

    String url = "http://apis.juhe.cn/cook/query?key=0902a0f28dd3f28c2c6b73b74db94cd1&menu=%E9%B1%BC";
    @Override
    int getLayoutID() {

        return R.layout.test;
    }


    @Override
    protected void initView(View view) {

        OkHttpUtils.getInstanceOkHttpUtils().get(url, this, 0);

        textView = (TextView) view.findViewById(R.id.tv);

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

        try {

            JSONObject jsonObject = new JSONObject(str);

            final String reason = jsonObject.optString("reason");


            getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    textView.setText(reason);
                }
            });


            int code = jsonObject.optInt("resultcode");

            if(code == 200){

                Log.d(TAG, "请求数据成功");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
