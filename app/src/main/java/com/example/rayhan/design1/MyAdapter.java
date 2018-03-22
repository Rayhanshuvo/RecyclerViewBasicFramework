package com.example.rayhan.design1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Rayhan on 3/22/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//Just testing git
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ListItem listItem=listItems.get(position);
        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDescription());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You clicked"+listItem.getHead(),Toast.LENGTH_SHORT).show();
                Toast.makeText(context,"You clicked"+listItem.getTest(),Toast.LENGTH_SHORT).show();
                Toast.makeText(context,"You clicked"+listItem.getDescription(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("description",listItem.getDescription());
                intent.putExtra("test",listItem.getTest());
                intent.putExtra("head",listItem.getHead());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

           public TextView textViewHead;
           public TextView textViewDesc;
           public LinearLayout linearLayout;
          public ViewHolder(View itemView) {
            super(itemView);

            textViewHead=(TextView)itemView.findViewById(R.id.textViewHead);
            textViewDesc=(TextView)itemView.findViewById(R.id.textViewFooter);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}
