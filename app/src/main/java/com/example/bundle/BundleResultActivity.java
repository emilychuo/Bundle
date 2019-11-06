package com.example.bundle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BundleResultActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mBundleResultTv;
    private Button mBackBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bundle_result);

        mBundleResultTv = findViewById(R.id.bundle_result_tv);
        mBackBt = findViewById(R.id.back_bt);
        mBackBt.setOnClickListener(this);

        receiveBasicData();
        receiveSerializableData();
        receiveParceableData();

    }

    private void receiveBasicData() {
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        int height = bundle.getInt("height");

        if ( name != null && height != 0)
        mBundleResultTv.setText("receive Basic Data : name =" + name + ";" + "height =" + height);
    }

    private void receiveSerializableData() {
        Person person = (Person) getIntent().getSerializableExtra("serializableData");
        if (person != null) {
            mBundleResultTv.setText("receive Serializable Data : person.name = " + person.getName() + ";" + "person.age=" +person.getAge());
        }
    }

    private void receiveParceableData() {
        Book book = (Book)getIntent().getParcelableExtra("parceableData");
        if (book != null) {
            mBundleResultTv.setText("receive Parcelable Data : book.name = " +book.getBookName() + ";" + "book.publishTime =" + book.getPublishTime());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_bt:
                this.finish();
                break;
            default:
                break;
        }
    }
}
