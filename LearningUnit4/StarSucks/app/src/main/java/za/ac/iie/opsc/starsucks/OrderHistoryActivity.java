package za.ac.iie.opsc.starsucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference starSucksRef = database.getReference("orders");
    private ListView lstvOrderHistory;
    private List<String> orderList;
    private ArrayAdapter<String> orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        orderList = new ArrayList<>();
        lstvOrderHistory = findViewById(R.id.lstv_OrderHistory);

        starSucksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // iterate over the children in the list
                for (DataSnapshot pulledOrder : snapshot.getChildren()) {
                    Order order = pulledOrder.getValue(Order.class);
                    orderList.add(order.toString());
                }

                // create the adapter to display the items
                orderAdapter = new ArrayAdapter<String>(OrderHistoryActivity.this,
                        android.R.layout.simple_list_item_1, orderList);
                lstvOrderHistory.setAdapter(orderAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(OrderHistoryActivity.this,
                        "Error Reading from Database", Toast.LENGTH_SHORT).show();
            }
        });
    }
}