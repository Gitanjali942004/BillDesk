package com.example.billdesk2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerBillAdapter extends RecyclerView.Adapter<RecyclerBillAdapter.ViewHolder>
{
    Context context;
    ArrayList<BillModel> arrContacts;
    private OnItemClickListener listener;
    public interface  OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener=clickListener;
    }
    RecyclerBillAdapter(Context context, ArrayList<BillModel> arrContacts)
    {
        this.context=context;
        this.arrContacts=arrContacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.meddata,parent,false);
        ViewHolder viewHolder=new ViewHolder(view,listener);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).quantity+"pcs");
        // Convert integer price to String before setting it
        holder.txtTime.setText("₹"+String.valueOf(arrContacts.get(position).price));

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class  ViewHolder extends  RecyclerView.ViewHolder{
        TextView txtName,txtNumber,txtTime;
        ImageView imageView;
        public ViewHolder(View itemView,OnItemClickListener listener) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtNumber=itemView.findViewById((R.id.txtNumber));
            txtTime=itemView.findViewById(R.id.txtTime);

            imageView=itemView.findViewById(R.id.deldata);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  listener.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
