public class Game {

    private int width;
    private int height;
    private int grid [][];


    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }




    public int countGreenNeighbours(int i, int j) {
        int countGreen = 0;


        countGreen += isValidBoundaries(i-1,j-1);
        countGreen += isValidBoundaries(i,j-1);
        countGreen +=isValidBoundaries(i+1,j-1);
        countGreen += isValidBoundaries(i - 1,j);

        countGreen += isValidBoundaries(i + 1, j);
        countGreen += isValidBoundaries(i - 1, j + 1);
        countGreen += isValidBoundaries(i, j + 1);
        countGreen += isValidBoundaries(i + 1, j + 1);

        return countGreen;
    }

    public  int isValidBoundaries (int row, int col){
            if (row < 0 || row >= width) {
                return 0;
            }
            if (col < 0 || col >= height) {
                return 0;
            }

            return this.grid[row][col];


    }
}