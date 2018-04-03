package branislav.gamf.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        final Button logoutButton = (Button) findViewById(R.id.logoutButton2);
        final Button sendButton = (Button) findViewById(R.id.sendButton);
        final EditText messageTextEdit = (EditText) findViewById(R.id.messsage);
        final TextView friendFullName = (TextView) findViewById(R.id.friendFullName);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String fullName = bundle.getString("fullNameFromContactList");
        friendFullName.setText(fullName);

        final CustomAdapter2 adapter = new CustomAdapter2(this);
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message1),true));
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message2),false));
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message3),true));
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message4),false));
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message5),true));
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message6),false));
        adapter.AddMessage(new MessageItem(getResources().getString(R.string.message7),true));

        ListView list = (ListView) findViewById(R.id.customListMessages);
        list.setDivider(null);
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MessageItem forDelete = (MessageItem) adapter.getItem(position);
                adapter.RemoveMessage(forDelete);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        messageTextEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String message = messageTextEdit.getText().toString();
                if(message.length()!=0)
                    sendButton.setEnabled(true);
                else
                    sendButton.setEnabled(false);
            }
        });


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Context context = getApplicationContext();
                CharSequence text = "Message is sent!";
                int duration = Toast.LENGTH_SHORT;
                */
                Toast toast = Toast.makeText(getApplicationContext(),(CharSequence)"Message is sent!",(int) Toast.LENGTH_SHORT);

                String message = messageTextEdit.getText().toString();
                adapter.AddMessage(new MessageItem(message,false));
                toast.show();
                messageTextEdit.setText("");


            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MessageActivity.this,MainActivity.class));
            }
        });
    }
}
