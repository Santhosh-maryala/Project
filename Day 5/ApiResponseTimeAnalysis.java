public class ApiResponseTimeAnalysis{
    public static void main(String[] args) {
        
        int[] responseTime = {1000,2000,320,3373,2888,999};

        int sum = 0;
        System.out.println("Slow Api(>2000 ms:)");

        for (int time : responseTime){
            sum += time;

            if (time> 2000){
                System.out.println(time+ " ms");
                            }
        } 
        double average =(double) sum/responseTime.length;
        System.out.println("Average Response Time:" +average + "ms");
    }
}