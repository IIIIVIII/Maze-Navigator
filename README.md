# Maze-Navigator
Maze Navigator
Project Description
This project generates a random maze and provides a framework for navigating through it. The project includes functionalities for maze generation, printing the maze, and a placeholder for implementing maze navigation logic.

File Structure
Main.java: The main entry point of the project, demonstrating the usage of the maze and navigator.
Maze.java: Generates and prints a random maze.
MazeNavigator.java: Provides a framework for navigating the maze (navigation logic not implemented).
Prerequisites
Java Version: JDK 8 or higher
How to Run
Place all .java files (Main.java, Maze.java, MazeNavigator.java) in the same directory.
Compile the Java files using the following command:
sh
Copy code
javac Main.java Maze.java MazeNavigator.java
Run the program using the following command:
sh
Copy code
java Main
Code Overview
Main.java
This file is the entry point of the program. It demonstrates the usage of the maze and navigator by:

Creating a Maze object.
Generating and printing the maze.
Creating a MazeNavigator object and attempting to navigate the maze.
Maze.java
This file generates a random maze. Its main functions include:

generateMaze(): Generates a random maze with 0s representing open paths and 1s representing walls.
printMaze(): Prints the maze to the console.
getMaze(): Returns the maze array.
MazeNavigator.java
This file provides a framework for navigating the maze. Its main function includes:

navigateMaze(): A placeholder method for implementing the maze navigation algorithm.
