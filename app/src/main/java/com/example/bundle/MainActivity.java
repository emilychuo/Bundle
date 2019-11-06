package com.example.bundle;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBundleBasicBt;
    private Button mBundleSerializableBt;
    private Button mBundleParcelableBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBundleBasicBt = findViewById(R.id.basic_data_bt);
        mBundleBasicBt.setOnClickListener(this);
        mBundleSerializableBt = findViewById(R.id.serializable_data_bt);
        mBundleSerializableBt.setOnClickListener(this);
        mBundleParcelableBt = findViewById(R.id.parcelable_data_bt);
        mBundleParcelableBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basic_data_bt:
                sendBasicDataThroughBundle();
                break;
            case R.id.serializable_data_bt:
                sendSerializableDataThroughBundle();
                break;
            case R.id.parcelable_data_bt:
                sendParceableDataThroughBundle();
                break;
            default:
                break;
        }
    }

    private void sendBasicDataThroughBundle() {
        Intent intent = new Intent(this, BundleResultActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("name", "bundle demo");
        bundle.putInt("height", 720);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void sendSerializableDataThroughBundle() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.bundle","com.example.bundle.BundleResultActivity"));

        Person mPerson = new Person();
        mPerson.setName("Bundle Person");
        mPerson.setAge(30);

        Bundle bundle = new Bundle();
        bundle.putSerializable("serializableData", mPerson);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void sendParceableDataThroughBundle() {
        Intent intent = new Intent();
        intent.setClassName("com.example.bundle","com.example.bundle.BundleResultActivity");

        Book mBook = new Book();
        mBook.setBookName("Bundle Book");
        mBook.setAuthor("Chuo yan");
        mBook.setPublishTime(2019);

        Bundle bundle = new Bundle();
        bundle.putParcelable("parceableData", mBook);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
