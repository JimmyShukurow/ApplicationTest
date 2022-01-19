class GivenArrayToPyramid {
    public static void toPyramid(int[][] given){
        for(int i = 0; i < given.length; i++){
            for(int j = 0; j < given[i].length; j++){
                System.out.print(given[i][j]);
            }
            System.out.println();
        }
    }
}