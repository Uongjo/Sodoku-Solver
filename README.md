# Sudoku-Solver version 1.0 

## How to run Sudoku Solver

If you don't have Java already installed, go install it [https://java.com/en/download/help/download_options.xml]here

1. Clone the Repo

```
git clone https://github.com/Uongjo/Sudoku-Solver.git
```

2. From the project root, go into the src folder

```
cd src
```

3. Edit input.txt for the sudoku puzzle you want to solve in the following format:
```
4
2 0 0 0 
0 0 1 0
0 2 0 0
0 0 0 4
```
* The first number is the dimensions of the sukdoku puzzle, 4x4, 9x9, etc.
* Each number underneath the first number represents a cell in the sudkoku puzzle
  * 0 represents an empty cell
  * Any non-zero number represents the value within that cell
  
4. Run the following commands to solve the sudoku puzzle
```
javac Tester.java
java Tester
```

5. Refer to classes and method documentation by opening up index.html in the browser from the doc folder

**Note: Since I'm using a recursive backtracking algorithm, 9x9 puzzles may potentially take a long time/run out of stack space**

## What I learned

* How to use a backtracking algorithm to sucessfully solve sudoku puzzles
* How to use git at a intermediate level
* How to write descriptive documentation in conjunction with JavaDoc

## Plans for the future

* Optimization of algorithm
* Implement an iterative solution
* Add error handling
* Implement a UI
