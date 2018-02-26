/*
 * Enemyクラス
 * -------------
 * <属性>
 * -------------
 * <操作>
 */


public class Enemy extends Object {
    public void moveY(CoodinateValue player) {
	if(this.value.x - player.x > 0) {
	    // under
	} else {
	 //up
	}
    }

    public void moveX(CoodinateValue player) {
	if(this.value.y - player.y >0) {
	    // left
	} else {
	    // right
	}
    }

    public void moveUp() {
    }

    public void moveDown() {
    }

    public void moveRight() {
    }

    public void moveLeft(){
    }

}
