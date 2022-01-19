import java.util.*;
import java.io.*;
class FindMax extends GivenArrayToPyramid{

    public static void main (String args[]){
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("numbers.txt");
        BufferedReader reader = null;
        int height = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String textLine = null;

            while ((textLine = reader.readLine()) != null) {
                    int i = 0,j = 0;

                while(j < textLine.length()){
                    if(textLine.charAt(j) == ' ') {
                        list.add(Integer.parseInt(textLine.substring(i,j)));
                        i = j+1;
                    }
                    if( j == textLine.length()-1) list.add(Integer.parseInt(textLine.substring(i,j+1))); 
                    j++;
                }
                height++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        System.out.println(list.get(3));
        System.out.println(height);


        // Scanner scanner = new Scanner(System.in);
        // int height;
        // System.out.print("Yuksekligi gir: ");
        // height = scanner.nextInt();
        // int[][] triangle = new int[height][];
        // for(int i = 0; i < height; i++){
        //     triangle[i] = new int[i+1];
        //     for(int j = 0; j <= i; j++){
        //         System.out.print("triangle["+i+"]["+j+"]: ");
        //         int number = scanner.nextInt();
        //         triangle[i][j] =  isPrime(number) ? 0 : number;
        //     }
        // }
        // System.out.println(maxSequence(triangle));
    }




    public static boolean isPrime(int k){
        for(int i = 2; i <= k/2; i++){
            if(k%i == 0 ) return false;
        }
        if(k == 1 ) return false;
        return true;
    }

    public static int maximumNumber(Map<Integer, List<Integer>> map){
        int max = 0;
        for(int i = 0; i < map.size(); i++){
            for(int nums: map.get(i)){
                max = nums > max ? nums : max;
            }
        }
        return max;
    }

    public static int maxSequence(int[][] given){
        Map<Integer, List<Integer>> temporaryanswers = new HashMap<>();
        Map<Integer, List<Integer>> answers = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        list.add(given[0][0]);
        answers.put(0, list);

        for(int i = 1; i < given.length; i++){
           for(int j =0; j < given[i].length; j++){
               list =new ArrayList<>();
               if( j < given[i-1].length ) {
                    if(j > 0){
                        if(given[i][j] == 0){
                            list.add(0);
                        }else{
                            for(int nums: answers.get(j-1)){
                                if(nums == 0 ){
                                    list.add(0);
                                }else{
                                    list.add(given[i][j]+ nums);
                                }
                            }
                        }
                    }
                    if(given[i][j] == 0){
                        list.add(0);
                    }else{
                        for(int nums: answers.get(j)){
                            if(nums == 0){
                                list.add(0);
                            }else{
                                list.add(given[i][j]+ nums);
                            }
                        }
                    }
               }else{
                   if(given[i][j] == 0){
                       list.add(0);
                   }else{
                        if(j > 0) {
                            for(int nums: answers.get(j-1)){
                                if(nums == 0){
                                    list.add(0);
                                }else{
                                    list.add(given[i][j]+nums);
                                }
                            }
                        }
                   }
               }
                temporaryanswers.put(j, list);
           }
           answers.clear();
           answers.putAll(temporaryanswers);
           temporaryanswers.clear();
        }
       
        return maximumNumber(answers); 

    }
}
