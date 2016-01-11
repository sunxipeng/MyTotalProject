package utils;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * 网络层的封装处理
 * Created by sunxipeng on 2016/1/11.
 */
class OkHttpUtils {

    private String url;

    private static OkHttpClient okHttpClient;

    //单例设计模式获取okHttpUtils的实例化对象
    private OkHttpUtils() {

        //创建okHttpclient的对象
        okHttpClient = new OkHttpClient();

    }

    //实例化OkHttpUtils的对象；
    private static OkHttpUtils okHttpUtils;

    //获取OkHttpUtils的对象
    public static synchronized OkHttpUtils getOkHttpUtils() {

        if (okHttpUtils == null) {

            okHttpUtils = new OkHttpUtils();

            return okHttpUtils;
        }
        return okHttpUtils;

    }


    //设置网络请求的url路径

    public void setUrl(String url) {

        if (url != null) {

            this.url = url;
        }
    }

    //进行get网络请求
    public static void get(String url,Callback callback,int requestCode){

        Request request = new Request.Builder().url(url).build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(callback);

    }

}
