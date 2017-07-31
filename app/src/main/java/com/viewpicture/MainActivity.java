package com.viewpicture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.banner)
    Banner banner;

    List<String> Url;//图片网址
    List<String> Title;//标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Url = new ArrayList<>();
        Url.add("https://ws1.sinaimg.cn/large/610dc034ly1ffyp4g2vwxj20u00tu77b.jpg");
        Url.add("https://ws1.sinaimg.cn/large/610dc034ly1fgdmpxi7erj20qy0qyjtr.jpg");
        Url.add("https://ws1.sinaimg.cn/large/610dc034ly1fgchgnfn7dj20u00uvgnj.jpg");
        Url.add("https://ws1.sinaimg.cn/mw690/610dc034ly1ffwb7npldpj20u00u076z.jpg");
        Url.add("https://ws1.sinaimg.cn/large/610dc034ly1fg5dany6uzj20u011iq60.jpg");

        Title = new ArrayList<>();
        Title.add("一");
        Title.add("二");
        Title.add("三");
        Title.add("四");
        Title.add("五");

        //使用Banner
        banner.setIndicatorGravity(BannerConfig.RIGHT)//圆点显示位置
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE).setBannerTitles(Title)//文字
                .setImages(Url).setImageLoader(new GlideImageLoader()).setDelayTime(3000).start();//获取图片呈现

        //Banner的监听事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(MainActivity.this, "点击了第" + Title.get(position).toString() + "张", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, PhotoviewActivity.class);
                intent.putExtra("url", Url.get(position));//传递点击图片网址
                startActivity(intent);
            }
        });
    }
}