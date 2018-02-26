/* 
 * Mapクラス
 * ------------
 * <属性>
 * initialMap : マップ情報
 * gameMap : ゲーム用のMap情報
 * ------------
 * <操作>
 * createGameMap : ゲーム用のマップ情報を生成する。
 * getPlayerCoordinate : プレイヤーの座標を取得する。
 * getEnemyCoordinate : 敵の座標を取得する。
 * checkCoorinate : 受け付けた座標に行けるかどうか確認。
 * printOut : マップを出力する
 *
 * copyArray : 配列をコピーする
 * */
//import java.util.Arrays;

public class Map  {
    char[][] gameMap;
    char[][] initalMap = {
	{'#','#','#','#','#','#','#','#','#','#','#'},
	{'#','o',' ',' ','A','#','B',' ',' ','G','#'},
	{'#',' ','#','#',' ','#',' ','#','#',' ','#'},
	{'#',' ','#',' ','o','#','o',' ',' ',' ','#'},
	{'#',' ','#',' ','#','#','#',' ','#',' ','#'},
	{'#','S',' ',' ',' ','o',' ',' ',' ','o','#'},
	{'#','#','#','#','#','#','#','#','#','#','#'},
	};

    public void createGameMap() {
	copyArray();
	for(int i = 0;i < this.gameMap.length;i++) {
	    for(int j = 0;j < this.gameMap[i].length;j++) {
		if(this.gameMap[i][j] == ' ' || this.gameMap[i][j] == '#'){
		    continue;
		} else {
		    this.gameMap[i][j] = ' ';
		}
	    }
	}
    }

    public boolean checkCoorinate(int x, int y) {
	return false;
    }

    //public int[] getPlayerCoordinate() {
    //}

    //public int[] getEnemyCoordinate() {
    //}

    public void printOut(char[][] map) {
	for(char[] row : map) {
	    System.out.println(row);
	    }
    }

    private void copyArray() {
	this.gameMap = new char[7][11];
	int i = 0;
	for(char[] row : this.initalMap) {
	    int j = 0;
	    char[] array = new char[11];
	    for(char col : row) {
		this.gameMap[i][j] = col;
		j++;
	    }
	    i++;
	}
    }
}

