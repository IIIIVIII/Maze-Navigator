
/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Fall 2022</p>
 *
 * @author Purdue CS
 * @version June 13, 2022
 */
public class Maze {
    private boolean[][] maze;
    private int playerRow;
    private int playerColumn;
    private int treasureRow;
    private int treasureColumn;

    public Maze(boolean[][] maze, int treasureRow, int treasureColumn) {
        this.maze = maze;
        playerRow = 0;
        playerColumn = 0;
        this.treasureRow = treasureRow;
        this.treasureColumn = treasureColumn;
    }

    public boolean[][] getMaze() {
        return maze;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerColumn() {
        return playerColumn;
    }

    public int getTreasureRow() {
        return treasureRow;
    }

    public int getTreasureColumn() {
        return treasureColumn;
    }

    public void setMaze(boolean[][] maze) {
        this.maze = maze;
    }

    public void setPlayerRow(int playerRow) {
        this.playerRow = playerRow;
    }

    public void setPlayerColumn(int playerColumn) {
        this.playerColumn = playerColumn;
    }

    public void setTreasureRow(int treasureRow) {
        this.treasureRow = treasureRow;
    }

    public void setTreasureColumn(int treasureColumn) {
        this.treasureColumn = treasureColumn;
    }

    public boolean checkWin() {
        return playerRow == treasureRow && playerColumn == treasureColumn;
    }
}
