package com.example.www.calculator;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToLongBiFunction;


/**
 * A simple {@link Fragment} subclass.
 */
public class TableFragment extends Fragment {


    public TableFragment() {
        // Required empty public constructor
    }

    private RecyclerView tableRecyclerView;
    private TableAdapter mTableAdapter;
    private List<Table> tableList= new ArrayList<>();
    private Button calculateTable;
    private EditText questionNumber;
    RecyclerView.LayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_table, container, false);

        tableRecyclerView = view.findViewById(R.id.table_recycler);
        calculateTable = view.findViewById(R.id.calculateTableButton);
        questionNumber = view.findViewById(R.id.table_number);

        mTableAdapter = new TableAdapter(getContext(),tableList);
        layoutManager = new LinearLayoutManager(getContext());
        tableRecyclerView.setLayoutManager(layoutManager);
        tableRecyclerView.setItemAnimator(new DefaultItemAnimator());
        tableRecyclerView.setAdapter(mTableAdapter);

        prepareTableData(1);

        calculateTable.setOnClickListener(mCalculateTable);

        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    View.OnClickListener mCalculateTable = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String num = questionNumber.getText().toString();

            if(TextUtils.isEmpty(num)){
                Toast.makeText(getContext(),R.string.empty_text_view, Toast.LENGTH_SHORT).show();
            }
            else{
                tableList.clear();
                prepareTableData(Integer.parseInt(num));
                mTableAdapter.notifyDataSetChanged();
                tableRecyclerView.scrollToPosition(0);
                //Toast.makeText(getContext(),"empty_text_view", Toast.LENGTH_SHORT).show();
                //tableRecyclerView.setAdapter(mTableAdapter);
            }
        }
    };

    private void prepareTableData(int num){
        for(int i=1;i<=20;i++){
            Table tableItem = new Table(num,i,num*i);
            tableList.add(tableItem);
        }
    }
}
