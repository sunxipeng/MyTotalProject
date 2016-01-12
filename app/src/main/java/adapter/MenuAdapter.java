package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunxipeng.mytotalproject.R;

import java.util.ArrayList;

import modle.Cookdish;

/**
 * Created by Administrator on 2016/1/12.
 */
public class MenuAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Cookdish> mDatas;

    public MenuAdapter(Context context, ArrayList<Cookdish> mDatas){

        this.context = context;

        this.mDatas = mDatas;

    }
    @Override
    public int getCount() {

        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {

        return (mDatas.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cookdish cookdish = mDatas.get(position);


            convertView = LayoutInflater.from(context).inflate(R.layout.menu,null);

            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);

            tv_title.setText(cookdish.title);

            TextView menu_tv_descrption = (TextView) convertView.findViewById(R.id.menu_tv_descrption);

            menu_tv_descrption.setText(cookdish.tags);

            ImageView img = (ImageView) convertView.findViewById(R.id.img);

            Glide.with(context).load(cookdish.albums.get(0)).into(img);

            return convertView;


    }




}
