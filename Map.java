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
 * inputPlayer : プレイヤーの位置を読み込み
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
	if(this.gameMap[x][y] == ' ') {
	    return true;
	} else {
	    return false;
	}
    }

    public int[] getPlayerCoordinate() {
	int[] k = new int[2];
	for(int i = 0;i < this.initalMap.length;i++) {
	    for(int j = 0;j < this.initalMap[i].length;j++) {
		if(this.initalMap[i][j] == 'S') {
		    k[0] = i;
		    k[1] = j;
		}
	    }
	}
	return k;
    }

    //public int[] getEnemyCoordinate() {
    //}
    //

    public void inputPlayer(int x, int y) {
	this.gameMap[x][y] = 'P';
    }

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

