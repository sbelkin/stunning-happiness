# stunning-happiness
Starting out with scala. 

Found a few basic tutorials however, none seemed a good way to start. 

Decided to make Conway's Game of Life.

From the wiki we got the following rules:
  Game of Life universe is a infinity two dimentional grid.
  In each step the following transitions occur:
    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any live cell with more than three live neighbours dies, as if by over-population.
    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    
To run need 4 arguments (Example used:   5  5 src/resource/default 3):
 Rows Columns DefaultFile IterationLifeCount