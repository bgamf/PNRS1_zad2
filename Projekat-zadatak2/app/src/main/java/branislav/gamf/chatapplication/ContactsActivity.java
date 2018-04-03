package branislav.gamf.chatapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        final Button logoutButton = (Button) findViewById(R.id.logoutButton1);
        final ListView listViewContacts = (ListView) findViewById(R.id.customListView);

        logoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ContactsActivity.this,MainActivity.class));
            }

        });

        final CustomAdapter adapter = new CustomAdapter(this);


        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact1),getResources().getDrawable(R.drawable.ic_send_black_24dp)));
        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact2),getResources().getDrawable(R.drawable.ic_send_black_24dp)));
        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact3),getResources().getDrawable(R.drawable.ic_send_black_24dp)));
        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact4),getResources().getDrawable(R.drawable.ic_send_black_24dp)));
        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact5),getResources().getDrawable(R.drawable.ic_send_black_24dp)));
        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact6),getResources().getDrawable(R.drawable.ic_send_black_24dp)));
        adapter.AddContact(new ContactItem(getResources().getString(R.string.contact6),getResources().getDrawable(R.drawable.ic_send_black_24dp)));


        listViewContacts.setAdapter(adapter);



    }
}
