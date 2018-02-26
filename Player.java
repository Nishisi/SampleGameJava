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
 * update : 座標の更新
 *
 * setValue : 座標のセッター
 *
 */

public class Player {
    char name = 'P';
    CoodinateValue value = new CoodinateValue();
    CoodinateValue nextValue = new CoodinateValue();

    public void inputSignal(char s) {
	this.nextValue = this.value;
	switch(s) {
	    case 'w':
		break;
	    case 'u':
		--this.nextValue.x;
		break;
	    case 'd':
		++this.nextValue.x;
		break;
	    case 'r':
		++this.nextValue.y;
		break;
	    case 'l':
		--this.nextValue.y;
		break;
	    default :
		System.out.println("不適切な入力です");
		break;
	}
	System.out.println(s);
    }

    public void update() {
	this.value = this.nextValue;
    }

    public void setValue(int x, int y) {
	this.value.x = x;
	this.value.y = y;
    }

    class CoodinateValue {
	public int x;
	public int y;
    }

}
