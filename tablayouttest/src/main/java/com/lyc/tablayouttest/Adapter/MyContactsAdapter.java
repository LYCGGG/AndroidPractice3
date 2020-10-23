package com.lyc.tablayouttest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lyc.tablayouttest.Contacts.MyContacts;
import com.lyc.tablayouttest.LogUtil.LogUtil;
import com.lyc.tablayouttest.R;

import java.util.List;

/**
 * @author ：LYC
 * @date ：Created in 2020/10/15
 * @version:
 * @description：
 */
public class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.MyViewHolder> {
    private Context context;
    private List<MyContacts> myContactsList;
    private int count = 0;
    private int count1 = 0;

//    public MyContactsAdapter(String name) {
//        myContactsList.
//    }

    public MyContactsAdapter(Context context, List<MyContacts> myContactsList) {
        super();
        this.context = context;
        this.myContactsList = myContactsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtil.i("LYCGGG" + ++count);
        if (context != null) {
            context = parent.getContext();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.contact_item,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyContacts myContacts = myContactsList.get(position);
        holder.textView.setText(myContacts.getUserName());
        LogUtil.i("LYCGGG" + ++count1);


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                JumpToModifyContactActivity()
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return myContactsList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView textView;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            textView = itemView.findViewById(R.id.contact_name);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"ok"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
//            textView = itemView.findViewById(R.id.contact_name);
        }


        
    }
}
