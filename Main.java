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

	m.inputPlayer(player.value.x, player.value.y);
	m.printOut(m.gameMap);


	// 無限ループ
	int time = 0;
	for(;;){
	    // ユーザからの入力情報
	    System.out.println("Please input signal");
	    char[] input = new Scanner(System.in).nextLine().toCharArray();
	    if (input.length == 1) {
		player.inputSignal(input[0]);
		if(m.checkCoorinate(player.nextValue.x, player.nextValue.y)) {
		    player.update();
		} else {
		    continue;
		}
	    } else {
		System.out.println("不適切な入力です");
		continue;
	    }

	    m.createGameMap();
	    m.inputPlayer(player.value.x, player.value.y);
	    m.printOut(m.gameMap);

	    // 回数終了条件
	    if(++time == 50) {
		break;
	    }
	}
    }
}

