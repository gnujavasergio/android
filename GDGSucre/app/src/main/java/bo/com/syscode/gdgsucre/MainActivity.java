package bo.com.syscode.gdgsucre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView textMessage;
    private EditText editMessage;
    private Button btnModified;

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference messageReference = reference.child("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMessage = (TextView) findViewById(R.id.text_message);
        editMessage = (EditText) findViewById(R.id.edit_message);
        btnModified = (Button) findViewById(R.id.btn_modified);
        btnModified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editMessage.getText().toString();
                messageReference.setValue(message);

                editMessage.setText("");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        messageReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                textMessage.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
