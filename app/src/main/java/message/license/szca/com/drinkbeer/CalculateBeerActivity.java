package message.license.szca.com.drinkbeer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by edao on 2017/9/8.
 */

public class CalculateBeerActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        System.loadLibrary("calculate-lib");
    }

    private EditText et_input;
    private Button bt_calculate;
    private TextView tv_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_beer);
        initView();
    }

    private void initView() {
        et_input = (EditText) findViewById(R.id.et_input);
        bt_calculate = (Button) findViewById(R.id.bt_calculate);
        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_calculate:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String input = et_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "输入金额", Toast.LENGTH_SHORT).show();
            return;
        }

        int i = Integer.valueOf(input);

        tv_result.setText(getBeer(i));



        // TODO validate success, do something


    }

    public native String getBeer(int money);
}
