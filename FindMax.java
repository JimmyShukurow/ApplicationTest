import java.util.*;
class FindMax extends GivenArrayToPyramid{

    public static void main (String args[]){
        
        Scanner scanner = new Scanner(System.in);
        int height;
        System.out.print("Yuksekligi gir: ");
        height = scanner.nextInt();
        int[][] triangle = new int[height][];
        for(int i = 0; i < height; i++){
            triangle[i] = new int[i+1];
            for(int j = 0; j <= i; j++){
                System.out.print("triangle["+i+"]["+j+"]: ");
                int number = scanner.nextInt();
                triangle[i][j] =  isPrime(number) ? 0 : number;
            }
        }
        // System.out.println("Sayi Prime'my: " + isPrime(number)); 
        toPyramid(triangle);
        System.out.println(maxSequence(triangle));
    }

    public static int factorial(int k){ 
        if (k ==1) return 1;

        return k* factorial(k-1);
    }

    public static int maximumNumber(int[] givenArray){
        int max = 0;
        for(int i = 0; i < givenArray.length; i++){
            max = givenArray[i] > max ? givenArray[i] : max;
        }
        return max;
    }

    public static boolean isPrime(int k){
        for(int i = 2; i <= k/2; i++){
            if(k%i == 0 ) return false;
        }
        if(k == 1 ) return false;
        return true;
    }

    public static int maxSequence(int[][] given){
        Map<Integer, List<Integer>> temporaryanswers = new HashMap<>();
        Map<Integer, List<Integer>> answers = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator;

        list.add(given[0][0]);
        answers.put(0, list);

        for(int i = 1; i < given.length; i++){
           for(int j =0; j < given[i].length; j++){
               list =new ArrayList<>();
               if( j < given[i-1].length ) {
                    if(j > 0) list.add(given[i][j]+answers.get(j-1).get(0));
                    list.add(given[i][j]+answers.get(j).get(0));
               }else{
                    if(j > 0) list.add(given[i][j]+answers.get(j-1).get(0));
               }
                temporaryanswers.put(j, list);
           }
           answers.clear();
           answers.putAll(temporaryanswers);
           temporaryanswers.clear();
        }
       
        System.out.println(answers);
        return answers.get(0).get(0);  

    }
}
