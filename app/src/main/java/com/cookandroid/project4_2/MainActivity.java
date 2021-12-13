package com.cookandroid.project4_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2, text3;
    CheckBox chkAgree;
    PictureView mypicture;
    Button btnPrev, btnNext, bntJoin;
    File[] imageFiles;
    String imageFname; //파일명 저장


    int curNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("♡Youri's Portfolio♡");
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);
        bntJoin=(Button)findViewById(R.id.bntJoin);
        mypicture=(PictureView)findViewById(R.id.PictureView);


        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);
        text3 = (TextView) findViewById(R.id.Text3);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        mypicture.imagePath = imageFname; //첫번째 파일의 이름을 추출해 imagePath에 전달

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum <= 0) {
                    Toast.makeText(getApplicationContext(),"This is first picture!", Toast.LENGTH_SHORT).show();
                }
                else {
                    curNum --; //이전클릭시 감소
                    imageFname = imageFiles[curNum].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum >= imageFiles.length) {
                    Toast.makeText(getApplicationContext(),"This is final picture!", Toast.LENGTH_SHORT).show();
                }
                else {
                    curNum ++; //다음클릭시 늘어남
                    imageFname = imageFiles[curNum].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();

                }
            }
        });

        bntJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UCoELIMId3CncjEm2kjYZSFw");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true) {
                    text1.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    bntJoin.setVisibility(View.VISIBLE);
                } else
                {
                    text1.setVisibility(View.INVISIBLE);
                    text2.setVisibility(View.INVISIBLE);
                    text3.setVisibility(View.INVISIBLE);
                    bntJoin.setVisibility(View.INVISIBLE);
                }
            }
        });


                }
            }






