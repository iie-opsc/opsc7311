package za.ac.iie.opsc.starsucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // declare fields for the ImageViews
    private ImageView img_Sb1;
    private ImageView img_Sb2;
    private ImageView img_Sb3;
    private ImageView img_Sb4;
    private ImageView img_Sb5;
    private ImageView img_Sb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_Sb1 = findViewById(R.id.img_sb1);
        img_Sb2 = findViewById(R.id.img_sb2);
        img_Sb3 = findViewById(R.id.img_sb3);
        img_Sb4 = findViewById(R.id.img_sb4);
        img_Sb5 = findViewById(R.id.img_sb5);
        img_Sb6 = findViewById(R.id.img_sb6);

        img_Sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}














