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
 * description :
 * author : JDNew
 * on : 2017/9/10.
 */
public class CalculateBeerActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        System.loadLibrary("native-lib");
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

        int money = Integer.valueOf(input);

        int result[] = getCalculateResult(money);
        tv_result.setText("最后可以喝 " + result[0] + " 瓶酒,剩下 " + result[1] + " 个空酒瓶和剩下 " + result[2] + " 个瓶盖");

    }

    public native int[] getCalculateResult(int money);

}
