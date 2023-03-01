package id.ac.usk.android.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Drawable gambar1, gambar2;
    boolean gambarPertama = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.logoUSK);

        // load gambar pertama
        try{
            InputStream ip = getAssets().open("logo_unsyiah.png");
            gambar1 = Drawable.createFromStream(ip, null);
        }catch (Exception e){
            Log.e("Tidak Ada gambar", e.getMessage());
        }
        // Load gambar kedua
        try{
            InputStream ip = getAssets().open("logo_unsyiah_2.png");
            gambar2 = Drawable.createFromStream(ip, null);
        }catch (Exception e){
            Log.e("Tidak Ada gambar", e.getMessage());
        }
    }

    public void tombolAsset(View view) {
        ImageView iv = findViewById(R.id.logoUSK);
        if(gambarPertama){
            iv.setImageDrawable(gambar2);
            gambarPertama = false;
        }else{
            iv.setImageDrawable(gambar1);
            gambarPertama = true;
        }
    }
}