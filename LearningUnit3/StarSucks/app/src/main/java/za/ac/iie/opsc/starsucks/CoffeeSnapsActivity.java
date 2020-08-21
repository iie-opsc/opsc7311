package za.ac.iie.opsc.starsucks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CoffeeSnapsActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private ImageView imgCameraImage;
    private static final int REQUEST_IMAGE_CAPTURE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_snaps);

        fab = findViewById(R.id.photoFab);
        imgCameraImage = findViewById(R.id.img_cameraImage);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check if we are receiving the result from the right request.
        // Also check whether the data is null, meaning the user may have cancelled.
        if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgCameraImage.setImageBitmap(bitmap);
        }
    }
}