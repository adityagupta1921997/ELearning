package com.apkglobal.elearning.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.apkglobal.elearning.R;

/**
 * Created by H.P on 11-Jun-17.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] imagesSlide = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3,R.drawable.slider4,R.drawable.slider5};

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagesSlide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliderimagelayout, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_imageViewSlider);
        imageView.setImageResource(imagesSlide[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager v = (ViewPager) container;
        View view = (View) object;
        v.removeView(view);
    }
}

