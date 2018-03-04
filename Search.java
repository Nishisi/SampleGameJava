import java.util.Queue;
import java.util.ArrayDeque;

public class Search {
    public static void main(String[] args){
        Queue<String> queue = new ArrayDeque<String>();
	queue.add("u");
	queue.add("d");
	queue.add("r");
	queue.add("l");
	queue.add("w");
	for(int i = 0;i < 10000000; i++) {
	    String str = queue.poll();
	    //char[] charArray = str.toCharArray();

	    for(char w : getCharArray()) {
		// 指示のchar配列を生成
		char[] checkArray = (str + w).toCharArray();

		// 検査
		switch(flowGame(checkArray)) {
		    case 0: // 失敗
			System.out.print("GameOver!! : ");
			System.out.println(checkArray);
			break;
		    case 1: // 継続
			queue.add(String.valueOf(checkArray));
			break;
		    case 2: // 成功
			System.out.print("Sucessful : ");
			System.out.println(checkArray);
			return;
		}
	    }
	}
    }   

   public static char[] getCharArray() {
	return new char[]{'u','d','r','l','w'};
   }

   public static int flowGame(char[] signal) {
    Player player = new Player();
    Map m = new Map();
    m.createGameMap();
    int[] ar = m.getPlayerCoordinate();
    player.setValue(ar[0],ar[1]);

    // Enemy のインスタンス化
    int[] arEa = m.getEnemyCoordinate('A');
    Enemy enemyA = new Enemy('A');
    enemyA.setValue(arEa[0],arEa[1]);

    int[] arEb = m.getEnemyCoordinate('B');
    Enemy enemyB = new Enemy('B');
    enemyB.setValue(arEb[0],arEb[1]);

    m.inputPlayer(player.value.x, player.value.y,0,0,0,0,0,0);
    m.inputEnemy(enemyA.value.x, enemyA.value.y, enemyA.name);
    m.inputEnemy(enemyB.value.x, enemyB.value.y, enemyB.name);
    //m.printOut(m.getGameMap());

    for(char ch : signal){
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

	player.inputSignal(ch);
	// 不適切であれば 0 を返す
	if(!m.checkPlayerCoorinate(player.nextValue.x, player.nextValue.y)) {
	    return 0;
	}

	m.inputEnemy(enemyA.nextValue.x, enemyA.nextValue.y, enemyA.name);
	m.inputEnemy(enemyB.nextValue.x, enemyB.nextValue.y, enemyB.name);

	m.inputPlayer(player.nextValue.x, player.nextValue.y, player.value.x, player.value.y , enemyA.value.x, enemyA.value.y, enemyB.value.x, enemyB.value.y);
	//m.printOut(m.getGameMap());

	// 座標の更新
	player.update();
	enemyA.update();
	enemyB.update();

	if(m.getGameOver()) {
	    return 0;
	}

	if(m.getComplate()) {
	    return 2;
	}
    }
    return 1;
    }
}
