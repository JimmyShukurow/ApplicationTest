class SortGivenArray{

    int[] givenArray;

    SortGivenArray(int[] givenArray){
        this.givenArray = givenArray;
    }

    public int[] sortArray(){
        for(int i = 0; i < givenArray.length; i++){
            for(int j = 0; j < givenArray.length; j++){
                int memory;
                if(givenArray[i] < givenArray[j]){
                    memory = givenArray[i];
                    givenArray[i] = givenArray[j];
                    givenArray[j] =memory;
                }
            }
        }
        return givenArray;
    }
}