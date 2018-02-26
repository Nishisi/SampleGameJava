import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Map m = new Map();
	m.createGameMap();
	m.printOut(m.gameMap);

	for(;;){
	    System.out.println("Please input signal");
	    char[] input = new Scanner(System.in).nextLine().toCharArray();
	    if (input.length == 1) {
		Player player = new Player();
		player.inputSignal(input[0]);
	    } else {
		System.out.println("不適切な入力です");
		break;
	    }
	}
    }
}

