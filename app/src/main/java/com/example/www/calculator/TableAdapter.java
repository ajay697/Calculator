package com.example.www.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.MyTableAdapter> {

    private Context mContext;
    private List<Table> tableList;

    public TableAdapter(Context mContext,List<Table> tableList){
        this.mContext = mContext;
        this.tableList = tableList;
    }
    @NonNull
    @Override
    public TableAdapter.MyTableAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.table_layout,parent,false);
        MyTableAdapter myTableAdapter = new MyTableAdapter(itemView);
        return myTableAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.MyTableAdapter holder, int position) {
            Table tableItem = tableList.get(position);
            holder.questionNumber.setText(Integer.toString(tableItem.getQuestion()));
            holder.multipleTextView.setText(Integer.toString(tableItem.getMultiple()));
            holder.answerTextView.setText(Integer.toString(tableItem.getResult()));

            if(position%2==0){
                holder.mCardView.setBackgroundResource(R.color.light_red);
            }
            else{
                holder.mCardView.setBackgroundResource(R.color.light_green);
            }
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public class MyTableAdapter extends RecyclerView.ViewHolder{

        public TextView questionNumber,multipleTextView,answerTextView;
        public CardView mCardView;
        public MyTableAdapter(@NonNull View itemView) {
            super(itemView);
            questionNumber = itemView.findViewById(R.id.quest_textView);
            multipleTextView = itemView.findViewById(R.id.multiply_textView);
            answerTextView = itemView.findViewById(R.id.answer_textView);
            mCardView = itemView.findViewById(R.id.cardView);
        }
    }
}
