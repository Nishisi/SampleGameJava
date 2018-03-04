/* 
 * Mapクラス
 * ------------
 * <属性>
 * complate   : クリア条件を満たしたかどうか
 * gameOver   : ゲームオーバかどうか
 * items      : マップにあるアイテムの数
 * gameMap    : ゲーム用のMap情報
 * initialMap : マップ情報
 * ------------
 * <操作>
 * getComplate : complate の getter 
 * getGameOver : gameOver の getter
 * getGameMap  : gameMap の getter
 * createGameMap : ゲーム用のマップ情報を生成する。
 * getPlayerCoordinate : プレイヤーの座標を取得する。
 * getEnemyCoordinate : 敵の座標を取得する。
 * checkPlayerCoorinate : 受け付けた座標に行けるかどうか確認。
 * checkEnemyCoorinate: 受け付けた座標は到達可能かどうか
 * inputPlayer : プレイヤーの位置を読み込み
 * printOut : マップを出力する
 *
 * copyArray : 配列をコピーする
 * */
//import java.util.Arrays;

public class Map  {
    private boolean complate = false;
    private boolean gameOver = false;
    private int items;
    private char[][] gameMap;
    private char[][] initalMap = {
	{'#','#','#','#','#','#','#','#','#','#','#'},
	{'#','o',' ',' ','A','#','B',' ',' ','G','#'},
	{'#',' ','#','#',' ',' ',' ','#','#',' ','#'},
	{'#',' ','#',' ','o','#','o',' ',' ',' ','#'},
	{'#',' ','#',' ','#','#','#',' ','#',' ','#'},
	{'#','S',' ',' ',' ','o',' ',' ',' ','o','#'},
	{'#','#','#','#','#','#','#','#','#','#','#'},
	};

    /*
     * getter & setter 
     */

    public boolean getComplate() {
	return this.complate;
    }

    public boolean getGameOver() {
	return this.gameOver;
    }

    public char[][] getGameMap() {
	return this.gameMap;
    }

    public void createGameMap() {
	copyArray();
	this.items = 0;
	for(int i = 0;i < this.gameMap.length;i++) {
	    for(int j = 0;j < this.gameMap[i].length;j++) {
		if(this.gameMap[i][j] == ' ' || this.gameMap[i][j] == '#'){
		    continue;
		} else if(this.gameMap[i][j] == 'o') {
		    this.items++;
		} else if(this.gameMap[i][j] == 'G') {
		    this.gameMap[i][j] = 'G';
		} else {
		    this.gameMap[i][j] = ' ';
		}
	    }
	}
    }

    public boolean checkPlayerCoorinate(int x, int y) {
	if(x < 1 || x > 5 || y < 1 || y > 9) {
	    return false;
	}

	if(this.gameMap[x][y] == ' ') {
	    return true;
	} else if(this.gameMap[x][y] == 'o') {
	    this.initalMap[x][y] = ' ';
	    --items;
	    return true;
	} else if(this.gameMap[x][y] == 'G') {
	    if(items == 0) {
		this.complate = true;
	    } else {
		this.complate = false;
	    }
	    return true;
	} else if(this.gameMap[x][y] == '#') {
	    return false;
	} else {
	    return false;
	}
    }

    public boolean checkEnemyCoorinate(int x, int y) {
	if(x < 1 || x > 5 || y < 1 || y > 9) {
	    return false;
	}
	if(gameMap[x][y] == '#') {
	    return false;
	} else {
	    return true;
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


    public int[] getEnemyCoordinate(char identification) {
	int[] k = new int[2];
	for(int i = 0;i < this.initalMap.length;i++) {
	    for(int j = 0;j < this.initalMap[i].length;j++) {
		if(this.initalMap[i][j] == identification) {
		    k[0] = i;
		    k[1] = j;
		}
	    }
	}
	return k;
    }
    
    public  void inputPlayer(int pnx, int pny, int px, int py, int eaX, int eaY, int ebX, int ebY) {
	if(gameMap[pnx][pny] == 'A' || gameMap[pnx][pny] == 'B') {
	    this.gameOver = true;
	}

	if(eaX == pnx && eaY == pny) {
	    if(gameMap[px][py] == 'A') {
		this.gameOver = true;
	    }
	}

	if(ebX == pnx && ebY == pny) {
	    if(gameMap[px][py] == 'B') {
		this.gameOver = true;
	    }
	}

	this.gameMap[pnx][pny] = 'P';
    }

    public void inputEnemy(int x, int y, char identi) {
	this.gameMap[x][y] = identi;
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

