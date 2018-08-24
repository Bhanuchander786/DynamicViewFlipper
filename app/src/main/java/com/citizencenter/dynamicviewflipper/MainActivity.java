package com.citizencenter.dynamicviewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
{
    private ViewFlipper viewFlipper;

    String[] url = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
            "https://cdn.pixabay.com/photo/2017/07/31/11/14/poppyseed-2557339_1280.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper =findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);

        setUpSlider();
    }

    private void setUpSlider()
    {
        for (String path:url) {
            View v = LayoutInflater.from(this).inflate(R.layout.view_flipper_inflate, null,false);
            ImageView imageView = v.findViewById(R.id.card_image);

            Picasso.get().load(path).resize(300,200).placeholder(R.drawable.album_default)
                    .into(imageView);

            viewFlipper.addView(v);
        }
    }
}
