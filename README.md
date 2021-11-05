# Title
You cannot beat us in Connect 4! We have the power of Mini-max Search!

# Team Members
Philip Ayoub (pja66) and Neil Madhavani (nmm85)

# Project Plan
## Introduction
Our main goal that we hope to accomplish at the end of this project is to gain further insight into the power of Mini-max search and how the output variance can be affected by using different heuristic algorithms. We will be answering this question by looking at it through the lens of the popular childhood game, Connect4. In order to accomplish this task, we have broken it up into 4 parts: Connect4 architecture, Minimax-search, heuristics algorithms, and finally testing.

## Game Implementation
Connect Four is a two-player game consisting of a vertical 7x6 board, where the players alternate stacking their specific game pieces on a column of their choice. Since the board is vertical, the piece always drops down to the lowest empty row in that column. If the column already has 6 pieces in it, that column is considered full and there cannot be any more pieces stacked on that column. The object of the game is to have 4 pieces in a row without the opponent’s game piece interrupting your pattern. The 4 in a row pattern must be vertical, horizontal, or diagonal.

## Min-Max with Alpha-Beta Implementation
The mini-max search algorithm will always output the optimal move for the user, assuming that the opponent is always playing optimally. For the mini-max algorithm, there will be a set of goal states, where the values are the maximum number of connected pieces. The optimal result would be a maximum number of connected pieces equal to 4, since that is how the user wins the game. The rest of the tree would be all of the possible moves until the board is filled up. Since Connect 4 is a game with no facets attributed to chance, we can use the normal mini-max algorithm rather than an expectiminimax algorithm. Since the depth of the tree will be 21, since there is a maximum of 21 moves per user, the algorithm will need to use alpha-beta pruning in order to minimize the runtime cost. The pruning order will be a simple depth-first-search from left to right.

## Heuristic Algorithms
Heuristic Algorithms are the engine behind Mini-max search. We plan on developing a full suite of algorithms for which will enable us to pursue our initial question. We have brainstormed 4 so far but leave this section largely open for further optimization. So far our Algorithms are:

  * Place piece to maximize number of connected pieces
  * Place piece to block longest string of opponents pieces
  * Place piece to maximize Number of open spot connections generated
  * Random/Naive piece placement

# Testing
Testing this algorithm will be two-fold. Firstly, there is always an optimal way to play Connect 4. As a result, we will use JUnit testing in order to make sure that the move outputted by the algorithm is always optimal. Secondly, we must make sure that the alpha-beta pruning order is working to significantly reduce the runtime cost of the minimax algorithm. We can also use JUnit testing to check if there are significant runtime differences between different approaches to the alpha-beta pruning orders, and if so, we can pivot to a more efficient pruning algorithm.

# System Architecture
We plan on coding this project in the language Java (SE 13), while simultaneously using GitHub for source control. Our current plan is to divide the project into 4 main classes: game implementation, Mini-max implementation, heuristic algorithm implementation, and finally a testing suite. However, we leave this as more of a general guideline due to the possibility of optimizations we might encounter during execution. 

# Timeline
We have roughly 5 weeks to complete this project. Thus since we have broken up this project into 4 main parts the plan is to tackle one part per week for the next four weeks with a week's worth of contingency days.
