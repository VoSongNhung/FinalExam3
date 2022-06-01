package com.example.finalexam3.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalexam3.DBNhanvien;
import com.example.finalexam3.Nav_Activity;
import com.example.finalexam3.Nhanvien;
import com.example.finalexam3.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SearchFragment extends Fragment {
    ArrayAdapter<Nhanvien> adapter;
    ListView lv;
    EditText ed_Searchkey;
    List<Nhanvien> listNV;
    Button btn_search;
    DBNhanvien dbNhanvien;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dbNhanvien = new DBNhanvien(getActivity());
        View view = inflater.inflate(R.layout.layout_fragmentsearch, container, false);
        lv = (ListView) view.findViewById(R.id.lv_Nhanvien);
        btn_search = (Button) view.findViewById(R.id.btn_search);
        ed_Searchkey = (EditText) view.findViewById(R.id.searchkey);
        listNV = dbNhanvien.getAllPeople();
        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, listNV);
        lv.setAdapter(adapter);
        ed_Searchkey.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH)
                {
                    listNV = dbNhanvien.getPersonByName(ed_Searchkey.getText().toString().trim());
                    adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, listNV);
                    lv.setAdapter(adapter);
                }
                return false;
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNV = dbNhanvien.getPersonByName(ed_Searchkey.getText().toString().trim());
                adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, listNV);
                lv.setAdapter(adapter);
                if(listNV.contains(""))
                {
                    Toast.makeText(getActivity(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    /*private void handleSearchNV()
    {
        listNV.clear();
        String strKeyWord = ed_Searchkey.getText().toString().trim();
        listNV = dbNhanvien.getPersonByName(strKeyWord);
        adapter.notifyDataSetChanged();
    }*/
}
