package com.wst.pens;

/**
 * Author:Double
 * Time:2019/4/22
 * Description:This is MainActivity
 */
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    StrokesView strokesView;
    private Button reDo;
    private Button unDo;
    private Button recover;
    private RadioGroup pen_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strokesView = (StrokesView)findViewById(R.id.view);
        recover = (Button)findViewById(R.id.recover);
        unDo = (Button)findViewById(R.id.undo);
        reDo = (Button)findViewById(R.id.redo);
        pen_type = (RadioGroup)findViewById(R.id.pen_type);
        recover.setOnClickListener(this);
        unDo.setOnClickListener(this);
        reDo.setOnClickListener(this);
        pen_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.pen:
                        strokesView.setPenType(PenType.PEN);
                        break;
                    case R.id.brush_pen:
                        strokesView.setPenType(PenType.BRUSH);
                        break;
                    default:
                        break;
                }
            }
        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.undo:
                strokesView.unDo();
                break;
            case R.id.recover:
                strokesView.recover();
                break;
            case R.id.redo:
                strokesView.reDo();
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        strokesView.onDestroy();
    }
}
