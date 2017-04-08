package reipki.com.simpleloginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class user extends AppCompatActivity {
    private static ImageView imageView;
    private static Button switchButton;

    private int current_image_view;
    int[] images = {R.mipmap.ic_launcher, R.mipmap.wallpaper_1, R.mipmap.wallpaper_2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        buttonClick();
    }

    public void buttonClick(){
        imageView = (ImageView)findViewById(R.id.imageView);
        switchButton = (Button)findViewById(R.id.button);
        switchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        current_image_view++;
                        current_image_view = current_image_view % images.length;
                        imageView.setImageResource(images[current_image_view]);
                    }
                }
        );
    }
}
