package com.tang.uibestpractice;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private MessageAdapter adapter;
    private List<Message> msgList = new ArrayList<Message>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        adapter = new MessageAdapter(MainActivity.this, R.layout.msg_list, msgList);
        final ListView messageList = (ListView)findViewById(R.id.messageList);
        messageList.setAdapter(adapter);
        final EditText inputText = (EditText)findViewById(R.id.messageText);
        Button sendButton = (Button)findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgList.add(new Message(inputText.getText().toString(), Message.TYPE_SENT));
                adapter.notifyDataSetChanged();
                messageList.setSelection(msgList.size());
                inputText.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initMsgs() {
        Message msg1 = new Message("Hello guy.", Message.TYPE_RECEIVED); msgList.add(msg1);
        Message msg2 = new Message("Hello. Who is that?", Message.TYPE_SENT); msgList.add(msg2);
        Message msg3 = new Message("This is Tom. Nice talking to you. ", Message.TYPE_RECEIVED); msgList.add(msg3);
    }
}
