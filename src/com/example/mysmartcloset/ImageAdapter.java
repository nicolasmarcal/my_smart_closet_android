package com.example.mysmartcloset;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<String> urls;
	
	public ImageAdapter(Context ctx, ArrayList<String> urls){
		this.context = ctx;
		this.urls = urls;
	}
	
	@Override
	public int getCount() {
		return urls.size();
	}

	@Override
	public Object getItem(int position) {
		try {
			URL url = new URL(urls.get(position));
			InputStream is = url.openStream();
			Bitmap image = BitmapFactory.decodeStream(is);
			image = Bitmap.createScaledBitmap(image, 640, 480, true);
			is.close();
			
			return image;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image = new ImageView(context);
		image.setImageBitmap((Bitmap) getItem(position));
		image.setAdjustViewBounds(true);
		image.setLayoutParams(new Gallery.LayoutParams(300, 200));
    
        image.setScaleType(ImageView.ScaleType.FIT_XY);
		
		return image;
	}
}
