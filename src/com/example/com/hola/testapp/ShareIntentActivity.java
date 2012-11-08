package com.example.com.hola.testapp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareIntentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_share_intent, menu);
        return true;
    }
    
    public void shareText(View view) {
    	Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "這是要分享的字串。");
        startActivity(Intent.createChooser(intent, "Share Text by using…"));
    }
    
    public static int CAMERA_REQUEST = 10000;
    public static int GALLERY_PICK_REQUEST = 10001;
    public String image_filepath;
    public void takePhotoFromCamera(View view) {
    	 Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
         startActivityForResult(cameraIntent, CAMERA_REQUEST); 
    }

    public void pickPhotoFromGallery(View view) {
    	Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_PICK_REQUEST);
    }
    
    public String getPath(Uri uri) {
	    String[] projection = { MediaStore.Images.Media.DATA };
	    Cursor cursor = managedQuery(uri, projection, null, null, null);
	    int column_index = cursor
	            .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	    cursor.moveToFirst();
	    return cursor.getString(column_index);
	}
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView imageView = (ImageView) this.findViewById(R.id.imageView1);
            imageView.setImageBitmap(photo);                        
        }
        if (requestCode == GALLERY_PICK_REQUEST && resultCode == RESULT_OK ) {
            Uri selectedImageUri = data.getData();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            ImageView imageView = (ImageView) this.findViewById(R.id.imageView1);
            TextView textView = (TextView) this.findViewById(R.id.textView2);
            image_filepath = getPath(selectedImageUri);
            textView.setText(image_filepath);
            Bitmap photo = BitmapFactory.decodeFile( image_filepath, options);
            imageView.setImageBitmap(photo);            
        }
    }
    
    public void shareImage(View view) {    	
    	if( image_filepath == null )
    		return;    	
    	File imageFile = new File(image_filepath);
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("image/*");       
        sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(imageFile));
        startActivity(Intent.createChooser(sharingIntent, "Share Image by using..."));
    }
    
	public void saveBitmapToFile(Bitmap bitmap) {
		// save bitmap to file
		String filename = String.format("capture_%s.jpg", UUID.randomUUID());
		File file = new File(Environment.getExternalStorageDirectory(),
				filename);
		try {
			FileOutputStream ostream = new FileOutputStream(file);
			bitmap.compress(CompressFormat.JPEG, 70, ostream);
			ostream.close();
			
			TextView textView = (TextView) this.findViewById(R.id.textView2);
			textView.setText(filename);
			image_filepath = filename;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void screenCapture(View view) {
		View root = (View) findViewById(android.R.id.content);

		if (root != null) {
			root.setDrawingCacheEnabled(true);
			root.buildDrawingCache(true);
			Bitmap bitmap = Bitmap.createBitmap(root.getDrawingCache());
			root.setDrawingCacheEnabled(false);
			
			ImageView imageView = (ImageView) this.findViewById(R.id.imageView1);
            imageView.setImageBitmap(bitmap);
            
            saveBitmapToFile(bitmap);
		}
	}
}
