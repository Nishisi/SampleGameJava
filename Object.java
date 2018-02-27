/*
 * Object クラス
 * -------------
 *  <属性>
 *  name : 名前
 *  value : 現在の座標
 *  nextValue : 次に移動予定の座標
 * -------------
 *  <操作>
 *  update : 座標の更新
 *  setValue : valueのセッター
 *  setNextValue : nextValueのセッター
 *  -----------
 *  CoorinateValue クラス : 座標用のクラス
 */
public class Object {
    char name;
    CoodinateValue value = new CoodinateValue();
    CoodinateValue nextValue = new CoodinateValue();

    public void update() {
	setValue(this.nextValue.x , this.nextValue.y);
    }

    public void setValue(int x, int y) {
	this.value.x = x;
	this.value.y = y;
    }

    public void setNextValue(int x, int y) {
	this.nextValue.x = x;
	this.nextValue.y = y;
    }

    class CoodinateValue {
	public int x;
	public int y;
    }
}
