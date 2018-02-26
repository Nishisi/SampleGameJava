/*
 * Playerクラス
 * -----------------
 * <属性>
 * pX : プレイヤーのx座標
 * pY : プレイヤーのy座標
 *
 * ----------------
 * <操作>
 * inputSignal : 得られた情報から次の座標を計算
 *
 */

public class Player {
    CoodinateValue value = new CoodinateValue();
    public void inputSignal(char s) {
	System.out.println(s);
    }

    class CoodinateValue {
	public int x;
	public int y;
    }

}
