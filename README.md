# EightQueens
A program to calculate the Eight Queens chess problem given an initial queen, and will also do N queens on an NxN board

The input from the command line can be coordinates from (1,1)-(8,8) where (1,1) is the upper left corner.
If you input with coordinates, you must put them as such: "java EightQueens 2 3", where 2 3 is (2,3).
You can also input as a chess location. The labeling is a standard chess board. a1 being the lower left, and
h8 being the upper right corners respectively.

Alternatively, you can type '0' which will bring you to an edit menu where you can select a new dimension for the board
I advise not picking a size larger thn 14, but see what you can do. When you put the new queen here, it takes
chess coordinates only. If you wish to put a number greater than 9 as the second coordinate, use code similar
to Hexi (but lowercase): that is, a=10, b=11, c=12, etc. For example, ab would be the upper left corner of a 11x11 board.

