package com.example.liaotiandemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Msg> msgs;
    public MyAdapter(List<Msg> list){
        msgs=list;
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder=new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        Msg msg=msgs.get(position);
        if (msg.getType()==Msg.TYPE_receive){
            holder.right_linerlayout.setVisibility(View.GONE);
            holder.left_linerlayout.setVisibility(View.VISIBLE);
            holder.tv_left.setText(msg.getContent());
        }else if(msg.getType()==Msg.TYPE_SEND){
            holder.right_linerlayout.setVisibility(View.VISIBLE);
            holder.left_linerlayout.setVisibility(View.GONE);
            holder.tv_right.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout left_linerlayout;
        LinearLayout right_linerlayout;
        private TextView tv_left;
        private TextView tv_right;
        public MyViewHolder(View itemView) {
            super(itemView);
            left_linerlayout=itemView.findViewById(R.id.left_liner);
            right_linerlayout=itemView.findViewById(R.id.right_liner);
            tv_left=itemView.findViewById(R.id.left_msg);
            tv_right=itemView.findViewById(R.id.right_msg);
        }
    }
}
