package message.license.szca.com.drinkbeer.activity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by edao on 2017/9/11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    abstract void initView();
    abstract void initData();
    abstract void setListener();
}
