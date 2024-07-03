import java.util.Scanner;

/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Summer 2023</p >
 *
 * @author Purdue CS
 * @version July 11, 2023
 */
public class MazeNavigator {

    public static final String WELCOME = "Welcome to the Maze Navigator!";
    public static final String INITIALIZE_MAZE = "Initializing maze...";
    public static final String MAZE_DIMENSIONS = "Please enter the maze dimensions:";
    public static final String MAZE_VALUES = "Please enter the values for the maze's row %d:\n";
    public static final String TREASURE_LOCATION = "Please enter the expected treasure location:";
    public static final String READY = "Ready to start?";
    public static final String CURRENT_POSITION = "Player's Position: %d,%d\n";
    public static final String MOVE_SELECT = "Please enter a move:";
    public static final String[] MOVES = {"Up", "Down", "Left", "Right"};
    public static final String INVALID_MOVE = "Invalid move! Select another direction.";
    public static final String TREASURE_FOUND = "Treasure found!";
    public static final String FAREWELL = "Thank you for playing!";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(WELCOME);
        System.out.println(INITIALIZE_MAZE);
        System.out.println(MAZE_DIMENSIONS);
        String dimension = "";
        dimension = in.nextLine();
        int indexComma = dimension.indexOf(",");
        String row = "";
        row = dimension.substring(0, indexComma);
        String column = "";
        column = dimension.substring(indexComma + 1, dimension.length());
        int rowN = Integer.parseInt(row);
        int columnN = Integer.parseInt(column);
        boolean[][] maze = new boolean[rowN][columnN];
        String input = "";
        for (int i = 0; i < rowN; i++) {
            System.out.printf(MAZE_VALUES, i);
            input = in.nextLine();
            String[] tf = input.split(",");
            for (int j = 0; j < tf.length; j++) {
                boolean x = Boolean.parseBoolean(tf[j]);
                maze[i][j] = x;
            }
        }
        System.out.println(TREASURE_LOCATION);
        String treasure = "";
        treasure = in.nextLine();
        int indexComma2 = treasure.indexOf(",");
        String treasureRowNum = treasure.substring(0, indexComma2);
        String treasureColumnNum = treasure.substring(indexComma2 + 1, treasure.length());
        int treasureRow = Integer.parseInt(treasureRowNum);
        int treasureColumn = Integer.parseInt(treasureColumnNum);
        Maze mainMaze = new Maze(maze, treasureRow, treasureColumn);
        System.out.println(READY);
        String choice = in.nextLine();
        int pRow = 0;
        int pColumn = 0;
        String move = "";
        if (choice.compareTo("Yes") == 0 || choice.compareTo("yes") == 0) {
            while (!mainMaze.checkWin()) {
                System.out.printf(CURRENT_POSITION, pRow, pColumn);
                System.out.println(MOVE_SELECT);
                for (int i = 0; i < MOVES.length; i++) {
                    System.out.println(i + 1 + ". " + MOVES[i]);
                }
                move = in.nextLine();
                if (move.compareTo("Up") == 0) {
                    pRow -= 1;
                    if (pRow < 0) {
                        pRow = rowN - 1;
                        if (maze[pRow][pColumn] == false) {
                            System.out.println(INVALID_MOVE);
                            pRow = 0;
                        } else if (pRow == treasureRow && pColumn == treasureColumn) {
                            System.out.println(TREASURE_FOUND);
                            System.out.println(FAREWELL);
                            break;
                        }
                    } else if (maze[pRow][pColumn] == false) {
                        System.out.println(INVALID_MOVE);
                        pRow = pRow + 1;
                    } else if (pRow == treasureRow && pColumn == treasureColumn) {
                        System.out.println(TREASURE_FOUND);
                        System.out.println(FAREWELL);
                        break;
                    }
                }
                if (move.compareTo("Down") == 0) {
                    pRow += 1;
                    if (pRow >= rowN) {
                        pRow = 0;
                        if (maze[pRow][pColumn] == false) {
                            System.out.println(INVALID_MOVE);
                            pRow = rowN - 1;
                        } else if (pRow == treasureRow && pColumn == treasureColumn) {
                            System.out.println(TREASURE_FOUND);
                            System.out.println(FAREWELL);
                            break;
                        }
                    } else if (pRow == treasureRow && pColumn == treasureColumn) {
                        System.out.println(TREASURE_FOUND);
                        System.out.println(FAREWELL);
                        break;
                    } else if (maze[pRow][pColumn] == false) {
                        System.out.println(INVALID_MOVE);
                        pRow = rowN - 1;
                    }
                }
                if (move.compareTo("Left") == 0) {
                    pColumn -= 1;
                    if (pColumn < 0) {
                        pColumn = columnN - 1;

                        if (maze[pRow][pColumn] == false) {
                            System.out.println(INVALID_MOVE);
                            pColumn = 0;
                        } else if (pRow == treasureRow && pColumn == treasureColumn) {
                            System.out.println(TREASURE_FOUND);
                            System.out.println(FAREWELL);
                            break;
                        }
                    } else if (maze[pRow][pColumn] == false) {
                        System.out.println(INVALID_MOVE);
                        pColumn += 1;
                    } else if (pRow == treasureRow && pColumn == treasureColumn) {
                        System.out.println(TREASURE_FOUND);
                        System.out.println(FAREWELL);
                        break;
                    }
                }
                if (move.compareTo("Right") == 0) {
                    pColumn += 1;
                    if (pColumn >= columnN) {
                        pColumn = 0;
                    }
                    if (maze[pRow][pColumn] == false) {
                        System.out.println(INVALID_MOVE);
                        pColumn = columnN - 1;
                    } else if (pRow == treasureRow && pColumn == treasureColumn) {
                        System.out.println(TREASURE_FOUND);
                        System.out.println(FAREWELL);
                        break;
                    }
                } else if (maze[pRow][pColumn] == false) {
                    System.out.println(INVALID_MOVE);
                    pColumn -= 1;
                } else if (pRow == treasureRow && pColumn == treasureColumn) {
                    System.out.println(TREASURE_FOUND);
                    System.out.println(FAREWELL);
                    break;
                }


            }

        } else {
            System.out.println(FAREWELL);
        }
    }
}