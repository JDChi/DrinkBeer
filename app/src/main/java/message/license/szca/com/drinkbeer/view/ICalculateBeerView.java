package message.license.szca.com.drinkbeer.view;

/**
 * Created by edao on 2017/9/11.
 */

public interface ICalculateBeerView {


    /**
     * 计算失败
     * @param msg
     */
    void calculateFailed(String msg);

    /**
     * 计算成功
     * @param result
     * 第一个数表示已经喝的瓶数
     * 第二个数表示剩下的空瓶子
     * 第三个数表示剩下的盖子
     */
    void calculateSuccess(int[] result);
}
