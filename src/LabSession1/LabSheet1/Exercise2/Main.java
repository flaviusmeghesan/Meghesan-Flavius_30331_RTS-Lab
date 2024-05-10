package Laboratory1.LabSheet1.Exercise2;

public class Main {
    public static void main(String[] args){
        int[][] matrixA = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] matrixB = {{8, 5, 3}, {3, 9, 2}, {2, 7 ,3}};

        int[][] sum = new int[3][3];
        for( int i = 0; i < 3; i++){
            for( int j = 0; j < 3; j++){
                sum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        int[][] matrixProduct = new int[3][3];
        for( int i = 0; i < 3; i++ ){
            for( int j = 0; j < 3; j++ ){
                int sum2=0;
                for( int k = 0; k < 3; k++ ){
                    sum2 += matrixA[i][k] * matrixB[k][j];
                }
                matrixProduct[i][j] = sum2;
            }
        }

        System.out.println("sum");
        matrixShapePrint(sum);
        System.out.println("product");
        matrixShapePrint(matrixProduct);
    }

    public static void matrixShapePrint(int[][] matrix){
        for(int i = 0; i < matrix.length; i++ ){
            for(int j = 0; j < matrix.length; j++ ){
                System.out.print( matrix[ i ][ j ] + " ");
            }
            System.out.println();
        }
    }
}
