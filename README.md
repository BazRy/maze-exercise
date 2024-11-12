# Maze Explorer

Description
-------------
A program that creates a maze grid structure from a supplied file.  
Once created an explorer object will navigate the maze until an exit is reached, upon which the 
explorer will leave the maze, having recorded how many times it has moved forward and a log of the 
various positions that the explorer has been on the maze.

How to run
-----------
Once imported into an IDE, the programme requires Java 21 to run.  
Run the main class **MazeMain**, supplying one of the 2 maze txt files - **MazeLarge.txt** or **MazeSmall.txt**.
Once complete the class will output details of the positions encountered by the explore, the number of different steps/moves on the maze taken by the explorer ,
and the number of moves forward taken by the explorer

Position was at grid position - row: 13 , column: 1, heading SOUTH \
Position was at grid position - row: 14 , column: 1, heading SOUTH \
Number of steps to exit maze 74 \
Number of forward moves to exit maze 61

Tests
-----
There are some tests that will test proper construction of a maze and an explorers journey across it.
Run **mvn clean test** to execute these.

Assumptions/Design Decisions
----------------------------
A maze is a structure that is square or rectangular in shape

The outside edges are either wall nodes or exit nodes

A forward move is deemed to be when an explorer moves to a position directly ahead, not to a node left or right.

A maze is a grid structure, comprising of nodes which have coordinates informing where on an x and y axis that node is located.
An explorer features on a maze by virtue of having a position comprising a reference to a nodes's coordinate object,
and direction denoting which way the explorer is headed.

So as to explore as much of the maze as possible,  nodes will be marked as 'explored' when an explorer has been on that node.
An explorer will avoid explored nodes unless they are unavoidable, e.g the explorer is in a dead end and has to turn back.

The program does not attempt to get to an exit in as quick a time as possible,  the explorer will simply explore the maze,
and if it comes upon an exit it will take it.

So illustrate where an explorer has been,  the explorer keeps a record of all the positions it has been on.
If an explorer travels across a node more than once,  this position is recorded as many times.