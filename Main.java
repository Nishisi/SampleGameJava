import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

	    // ユーザからの入力情報
	    // 検査し、次の座標を決定する
	    System.out.print("Please input signal : ");
	    for(;;) {
		char[] input = new Scanner(System.in).nextLine().toCharArray();
		if (input.length == 1) {
		    player.inputSignal(input[0]);
		    if(m.checkPlayerCoorinate(player.nextValue.x, player.nextValue.y)) {
			break;
		    } else {
			System.out.println("移動できません");
		    }
		} else {
		    System.out.println("不適切な入力です");
		    continue;
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
		break;
	    }

	    if(m.getComplate()) {
		System.out.println("Congrats!!");
		break;
	    }

	    // 回数終了条件
	    if(++time == 50) {
		break;
	    }
	}
    }
}

