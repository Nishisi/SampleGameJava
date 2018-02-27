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

public class Player extends Object {
    char name = 'P';

    public void inputSignal(char s) {
	setNextValue(this.value.x, this.value.y);
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
}
