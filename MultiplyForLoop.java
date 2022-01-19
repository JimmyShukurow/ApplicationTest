class MultiplyForLoop {
    String given;

    MultiplyForLoop(String given) {
        this.given = given;
    }

    public void forLoop(){
        int max = 0;
        for (int i = 0; i < given.length() ; i++){
                // max = given[i] > max ? given[i] : max;
        System.out.println(given.charAt(i));
        }
    }

    // public int sumOfLoop(){
    //     int sum = 0;
    //     for(int i = 0; i < given.length; i++){
    //         sum += given[i];
    //     }
    //     return sum;
    // }
}