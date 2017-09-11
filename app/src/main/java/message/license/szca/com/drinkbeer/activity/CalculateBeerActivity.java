package message.license.szca.com.drinkbeer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import message.license.szca.com.drinkbeer.R;
import message.license.szca.com.drinkbeer.presenter.CalculateBeerPresenter;
import message.license.szca.com.drinkbeer.view.ICalculateBeerView;

/**
 * description :
 * author : JDNew
 * on : 2017/9/10.
 */
public class CalculateBeerActivity extends BaseActivity implements View.OnClickListener, ICalculateBeerView {



    private EditText et_input;
    private Button bt_calculate;
    private TextView tv_result;
    private CalculateBeerPresenter calculateBeerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_beer);
        initView();
        initData();
        setListener();
    }

    @Override
    void initView() {
        et_input = (EditText) findViewById(R.id.et_input);
        bt_calculate = (Button) findViewById(R.id.bt_calculate);
        tv_result = (TextView) findViewById(R.id.tv_result);


    }

    @Override
    void initData() {
        calculateBeerPresenter = new CalculateBeerPresenter(this , this);
    }

    @Override
    void setListener() {
        bt_calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_calculate:
                calculateBeerPresenter.calculateBeer(et_input.getText().toString().trim());
                break;
        }
    }

    @Override
    public void calculateFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void calculateSuccess(int[] result) {
        tv_result.setText("最后可以喝 " + result[0] + " 瓶酒,剩下 "
                + result[1] + " 个空酒瓶和剩下 "
                + result[2] + " 个瓶盖");
    }




}
