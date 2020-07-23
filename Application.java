import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] dimensions = scanner.nextLine().split(",\\s+");

        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);


        int[][] generationZGrid = new int[width][height];
        for (int row = 0; row < width; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < height; col++) {
                generationZGrid[row][col] = Integer.parseInt(String.valueOf(input.charAt(col)));


            }
        }

        Game game = new Game(width, height);
        game.setGrid(generationZGrid);


        String[] inputCoordinates = scanner.nextLine().split(",\\s+");

        int x = Integer.parseInt(inputCoordinates[0]);
        int y = Integer.parseInt(inputCoordinates[1]);
        int generationN = Integer.parseInt(inputCoordinates[2]);


        int generationZCount = countForGreenGenerationZero(generationZGrid, x, y);


        int generationNCount = 0;
        int greenNeighbours =0;

        for (int beginning = 0; beginning < generationN ;beginning++) {



        int[][] newGenerationGrid = new int[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {

                    greenNeighbours = game.countGreenNeighbours(i, j);

                    if (generationZGrid[i][j] == 0) {
                        if (greenNeighbours == 3 || greenNeighbours == 6) {
                           newGenerationGrid[i][j] = 1;
                        } else if (greenNeighbours == 0 || greenNeighbours == 1 || greenNeighbours == 2
                                || greenNeighbours == 4 || greenNeighbours == 5 || greenNeighbours == 7 || greenNeighbours == 8) {
                            newGenerationGrid[i][j] = 0;
                        }
                    }
                    if (generationZGrid[i][j] == 1) {

                        if (greenNeighbours == 0 || greenNeighbours == 1 || greenNeighbours == 4
                                || greenNeighbours == 5 || greenNeighbours == 7 || greenNeighbours == 8) {
                           newGenerationGrid[i][j] = 0;
                        }else if (greenNeighbours == 2 || greenNeighbours == 3 || greenNeighbours == 6) {
                            newGenerationGrid[i][j] = 1;
                        }

                    }

                }
            }


            if (newGenerationGrid[x][y] == 1) {
                generationNCount++;
            }
         generationZGrid = newGenerationGrid;


        }

        int sumOfGenerationZAndN = generationNCount + generationZCount;
        System.out.println(sumOfGenerationZAndN);


    }


    private static int countForGreenGenerationZero(int[][] generationZGrid, int x, int y) {
        int generationZeroSum = 0;
        if (generationZGrid[x][y] == 1) {
            generationZeroSum++;
        }

        return generationZeroSum;
    }


}


