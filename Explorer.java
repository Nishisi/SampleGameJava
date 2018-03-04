import java.util.Scanner;
import java.util.ArrayList;
import java.Collections;
import java.util.Arrays;
import java.util.Random;

public class Explorer {
    public static void main(String[] args) {
	//System.out.println(perform());
	perform(RandomChar());
    }

    public static boolean perform(char[] moving) {

	Map m = new Map();
	Player player = new Player();

	m.createGameMap(); 

	// Player の座標の取得
	int[] ar = m.getPlayerCoordinate(); 
	player.setValue(ar[0],ar[1]);

	// Enemy のインスタンス化
	int[] arEa = m.getEnemyCoordinate('A');
	Enemy enemyA = new Enemy();
	enemyA.name = 'A';
	enemyA.setValue(arEa[0],arEa[1]);

	int[] arEb = m.getEnemyCoordinate('B');
	Enemy enemyB = new Enemy();
	enemyB.name = 'B';
	enemyB.setValue(arEb[0],arEb[1]);

	m.inputPlayer(player.value.x, player.value.y,0,0,0,0,0,0);
	m.inputEnemy(enemyA.value.x, enemyA.value.y, enemyA.name);
	m.inputEnemy(enemyB.value.x, enemyB.value.y, enemyB.name);
	m.printOut(m.gameMap);


	// 無限ループ
	int time = 0;
	for(;;){
	    // 新ゲームマップを作る
	    m.createGameMap();

	    // 敵の動き
	    enemyA.moveY(player.value);
	    if(!m.checkEnemyCoorinate(enemyA.nextValue.x, enemyA.nextValue.y)) {
		enemyA.moveX(player.value);
		if(!m.checkEnemyCoorinate(enemyA.nextValue.x, enemyA.nextValue.y)) {
		    enemyA.moveDown();
		    if(!m.checkEnemyCoorinate(enemyA.nextValue.x, enemyA.nextValue.y)) {
			enemyA.moveLeft();
			if(!m.checkEnemyCoorinate(enemyA.nextValue.x, enemyA.nextValue.y)) {
			    enemyA.moveUp();
			    if(!m.checkEnemyCoorinate(enemyA.nextValue.x, enemyA.nextValue.y)) {
				enemyA.moveRight();
			    }
			}
		    }
		}
	    }

	    enemyB.moveX(player.value);
	    if(!m.checkEnemyCoorinate(enemyB.nextValue.x, enemyB.nextValue.y)) {
		enemyB.moveY(player.value);
		if(!m.checkEnemyCoorinate(enemyB.nextValue.x, enemyB.nextValue.y)) {
		    enemyB.moveUp();
		    if(!m.checkEnemyCoorinate(enemyB.nextValue.x, enemyB.nextValue.y)) {
			enemyB.moveLeft();
			if(!m.checkEnemyCoorinate(enemyB.nextValue.x, enemyB.nextValue.y)) {
			    enemyB.moveDown();
			    if(!m.checkEnemyCoorinate(enemyB.nextValue.x, enemyB.nextValue.y)) {
				enemyB.moveRight();
			    }
			}
		    }
		}
	    }


	    for(;;) {
		player.inputSignal(moving[time]);
		if(m.checkPlayerCoorinate(player.nextValue.x, player.nextValue.y)) {
		    break;
		} else {
		    System.out.println("移動できません");
		}
	    }


	    m.inputEnemy(enemyA.nextValue.x, enemyA.nextValue.y, enemyA.name);
	    m.inputEnemy(enemyB.nextValue.x, enemyB.nextValue.y, enemyB.name);

	    m.inputPlayer(player.nextValue.x, player.nextValue.y, player.value.x, player.value.y , enemyA.value.x, enemyA.value.y, enemyB.value.x, enemyB.value.y);
	    m.printOut(m.gameMap);

	    // 座標の更新
	    player.update();
	    enemyA.update();
	    enemyB.update();

	    if(m.getGameOver()) {
		System.out.println("GAME OVER !!");
		return false;
	    }

	    if(m.getComplate()) {
		System.out.println("Congrats!!");
		return true;
	    }

	    // 回数終了条件
	    if(++time == 50) {
		break;
	    }
	}
	return false;
    }

    public static char[] RandomChar() {
	ArrayList<Integer> list = new ArrayList<Integer>();

	char[] str = new char[60];
	Random rand = new Random();
	for(int i = 0; i < 60; i++) {
	    switch(rand.nextInt(5)) {
		case 0:
		    str[i] = 'w';
		    break;
		case 1:
		    str[i] = 'u';
		    break;
		case 2:
		    str[i] = 'd';
		    break;
		case 3:
		    str[i] = 'r';
		    break;
		case 4:
		    str[i] = 'l';
		    break;
	    }
	}
	return str;
    }
}

