# Structure

<img src="https://github.com/Sieluton/chessAI/blob/master/documentation/structure.png"/>

# Implemented

## Chess
Chess game itself with all the rules.

Move generation with help of game rules has been done and stored in queue stucture. This is also used when we want to know did the game end.

## Alpha-beta pruning
Alpha-beta pruning traverses the game tree in which each node is Board object. In each call of alpha-beta it generates all the moves for current board and playes them one at a time and calls itself on the new board until we reach end in game or depth limit that we search. In the end returns Move object that got best value from evaluation in given depth.

## Queue
Queue implementation used to store the moves. It is made as a linked list and adding and removing from it are O(1) operations. The linked list stores in the node an object and the next node. When the queue is asked to add an object it adds it to the end by creating new node and storing it in the last nodes reference to next node. Removing a node just returns first nodes object and moves the first node to point to next one.