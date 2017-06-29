package com.bonepeople.android.sdcardcleaner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.bonepeople.android.sdcardcleaner.adapter.Adapter_list_file;
import com.bonepeople.android.sdcardcleaner.models.SDFile;
import com.bonepeople.android.sdcardcleaner.utils.FileScanUtil;

import java.util.ArrayList;

public class Activity_list_file extends AppCompatActivity {
    private EditText _text_path;
    private RecyclerView _list;
    private Adapter_list_file _adapter;
    private ArrayList<SDFile> _files = new ArrayList<>();
    private ArrayList<String> _paths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_file);
        setTitle("文件列表");

        _text_path = (EditText) findViewById(R.id.edittext_path);
        _list = (RecyclerView) findViewById(R.id.recyclerview);

        SDFile _file = FileScanUtil.get_rootFile();
        _files.add(_file);
        _paths.add("SD卡\\");

        _text_path.setText("SD卡\\");
        LinearLayoutManager _layoutManager = new LinearLayoutManager(this);
        _layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        _list.setLayoutManager(_layoutManager);
        _adapter = new Adapter_list_file(this);
        _adapter.set_data(_file);
        _list.setAdapter(_adapter);
        _list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}