package com.example.liaotiandemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn;
    private EditText et;
    private List<Msg> msgs=new ArrayList<>();
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        recyclerView=findViewById(R.id.recycler_view);
        myAdapter=new MyAdapter(msgs);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(myAdapter);
        et=findViewById(R.id.et_send);
        btn=findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=et.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    msgs.add(msg);
                    myAdapter.notifyItemInserted(msgs.size()-1);
                    recyclerView.scrollToPosition(msgs.size()-1);
                    et.setText("");
                    msgs.add(new Msg("qqqqq",Msg.TYPE_receive));
                    myAdapter.notifyItemInserted(msgs.size()-1);
                    recyclerView.scrollToPosition(msgs.size()-1);
                }
            }
        });

    }

    private void initMsgs(){
        msgs.add(new Msg("hello 段其鹏",Msg.TYPE_receive));
        msgs.add(new Msg("hello shshshs",Msg.TYPE_SEND));
        msgs.add(new Msg("what are u doing",Msg.TYPE_receive));
    }
}