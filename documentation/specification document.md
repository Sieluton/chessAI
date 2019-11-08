Alpha-beta pruning is the algorithm used for traversing the game tree while also pruning away bad
branches. I will use array to store the board and new boards in game tree.


My goal for this project is to create a chess algorithm that can beat me atleast which shouldn't be that hard.


chess.Game will be text controlled and after each move the board will be printed. For moving pieces
you will need to specify coordinates in (1-8,1-8) or (a-h,1-8) for piece you want to move and then again for where to move it. Before the move is made it's checked that it's a valid move.
In case of castling you type ''castle long'' or ''castle short''.


If 
<img src="https://latex.codecogs.com/svg.latex?b" title="b"/>
denotes average branching meaning average of possible moves through out the whole game and 
<img src="https://latex.codecogs.com/svg.latex?d" title="d"/>
denotes depth in this case how many moves deep do we look then the worst-case time complexity is
<img src="https://latex.codecogs.com/svg.latex?O(b^d)" title="O(b^d)"/>
if we traverse the game tree by first looking at bad moves. Idea is to get good moves as early as
possible so maximum pruning happens and we can continue deeper into the game tree in same amount of time.


[Alpha-beta pruning](https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning)

[Alpha-beta pruning in chess](https://www.chessprogramming.org/Alpha-Beta)