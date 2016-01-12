package activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunxipeng.mytotalproject.R;

import modle.Cookdish;

/**
 * Created by Administrator on 2016/1/12.
 */
public class DishDetialActivity extends Activity {

    private TextView detial_tv_main, detial_tv_next, detial_descrape_tv;

    private LinearLayout imageView_container;

    private Cookdish cookdish;

    private ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail);

        cookdish = (Cookdish) getIntent().getExtras().getSerializable("cookdish");

        image = (ImageView) findViewById(R.id.image);

        Glide.with(this).load(cookdish.albums.get(0)).into(image);

        detial_tv_main = (TextView) findViewById(R.id.detial_tv_main);
        detial_tv_main.setText(cookdish.ingredients);


        detial_tv_next = (TextView) findViewById(R.id.detial_tv_next);
        detial_tv_next.setText(cookdish.burden);

        imageView_container = (LinearLayout) findViewById(R.id.imageView_container);

        detial_descrape_tv = (TextView) findViewById(R.id.detial_descrape_tv);
        detial_descrape_tv.setText(cookdish.imtro);

        addImageView();
    }

    /**
     * 动态添加imagView
     */
    private void addImageView() {

        for (int image = 0; image < cookdish.steps.size(); image++) {

            ImageView imageView = new ImageView(this);

            TextView textView = new TextView(this);

            textView.setText(cookdish.steps.get(image).step);

            LinearLayout.LayoutParams textViewLayoutparams = new LinearLayout.
                    LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                    , ViewGroup.LayoutParams.WRAP_CONTENT);
            textViewLayoutparams.setMargins(20, 0, 20, 5);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setLayoutParams(textViewLayoutparams);

            Glide.with(this).load(cookdish.steps.get(image).img).into(imageView);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.
                    LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                    , LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(20, 0, 20, 20);

            imageView.setLayoutParams(layoutParams);


            imageView_container.addView(textView);
            imageView_container.addView(imageView);


        }
    }


}
