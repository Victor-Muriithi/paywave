package com.example.paywave.Services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paywave.Details;
import com.example.paywave.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Details> arrayList;
    Context context;

    public Adapter(ArrayList<Details> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.CardTitle.setText(arrayList.get(position).entity);
        System.out.println(arrayList.get(position).entity);
        holder.transactionTo.setText(arrayList.get(position).transactionDetail1);
        holder.transactionFrom.setText(arrayList.get(position).transactionDetail2);

        holder.CardExpandableTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(position).isVisible){
                    holder.ExpandableCardItem.setVisibility(View.GONE);
                    arrayList.get(position).isVisible = false;
                }
                else {
                    holder.ExpandableCardItem.setVisibility(View.VISIBLE);
                    arrayList.get(position).isVisible = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView CardTitle;
        TextView transactionTo;
        TextView transactionFrom;
        LinearLayout CardExpandableTitle;
        LinearLayout ExpandableCardItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CardTitle = itemView.findViewById(R.id.my_text_view);
            transactionTo = itemView.findViewById(R.id.transaction_number);
            transactionFrom = itemView.findViewById(R.id.transaction_to_details);
            CardExpandableTitle = itemView.findViewById(R.id.cardTitleExpandable);
            ExpandableCardItem = itemView.findViewById(R.id.cardExpandedItems);
        }
    }
}
