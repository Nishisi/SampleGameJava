/*
 * Enemyクラス
 * -------------
 * <属性>
 * -------------
 * <操作>
 * moveY : Y軸を起点にプレイヤーに近い方に近く
 * moveX : X軸を起点にプレイヤーに近い方に近く
 * moveUp : 上
 * moveDoen : 下
 * moveLeft : 左
 * moveRight  右
 */


public class Enemy extends Object {
    public void moveY(CoodinateValue player) {
	if(this.value.x - player.x > 0) {
	    moveDown();
	} else {
	    moveUp();
	}
    }

    public void moveX(CoodinateValue player) {
	if(this.value.y - player.y >0) {
	    moveLeft();
	} else {
	    moveRight();
	}
    }

    public void moveUp() {
	this.nextValue = this.value;
	--this.nextValue.x;
    }

    public void moveDown() {
	this.nextValue = this.value;
	++this.nextValue.x;
    }

    public void moveRight() {
	this.nextValue = this.value;
	++this.nextValue.y;
    }

    public void moveLeft(){
	this.nextValue = this.value;
	--this.nextValue.y;
    }

}
