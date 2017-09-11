package message.license.szca.com.drinkbeer.presenter;

import android.app.Activity;
import android.text.TextUtils;

import message.license.szca.com.drinkbeer.view.ICalculateBeerView;

/**
 * Created by edao on 2017/9/11.
 */

public class CalculateBeerPresenter {


    static {
        System.loadLibrary("native-lib");
    }


    private Activity mContext;
    private ICalculateBeerView mICalculateBeerView;
    public CalculateBeerPresenter(Activity context , ICalculateBeerView iCalculateBeerView){
        this.mContext = context;
        this.mICalculateBeerView = iCalculateBeerView;
    }

    /**
     * 计算结果
     * @param str
     */
    public void calculateBeer(String str) {
        String input = str;
        if (TextUtils.isEmpty(input)) {
            mICalculateBeerView.calculateFailed("输入金额");
            return;
        }


        int money = Integer.valueOf(input);
        int result[] = getCalculateResult(money);


        mICalculateBeerView.calculateSuccess(result);

    }


    public native int[] getCalculateResult(int money);
}
