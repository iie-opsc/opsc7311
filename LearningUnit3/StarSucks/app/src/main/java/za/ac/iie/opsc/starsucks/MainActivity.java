package za.ac.iie.opsc.starsucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declare fields for the ImageViews
    private ImageView img_Sb1;
    private ImageView img_Sb2;
    private ImageView img_Sb3;
    private ImageView img_Sb4;
    private ImageView img_Sb5;
    private ImageView img_Sb6;

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.img_sb1:
                Toast.makeText(MainActivity.this, "MMM Soy Latte", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_sb2:
                Toast.makeText(MainActivity.this, "MMM Chocco Frapp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_sb3:
                Toast.makeText(MainActivity.this, "MMM Bottled Americano", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_sb4:
                Toast.makeText(MainActivity.this, "MMM Rainbow Frapp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_sb5:
                Toast.makeText(MainActivity.this, "MMM Caramel Frapp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_sb6:
                Toast.makeText(MainActivity.this, "MMM Black Forest Frapp", Toast.LENGTH_SHORT).show();
                break;
        }
    }

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

        img_Sb1.setOnClickListener(this);
        img_Sb2.setOnClickListener(this);
        img_Sb3.setOnClickListener(this);
        img_Sb4.setOnClickListener(this);
        img_Sb5.setOnClickListener(this);
        img_Sb6.setOnClickListener(this);
    }
}














