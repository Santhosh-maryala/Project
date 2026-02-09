public class ServerDowntimeChecker{
    public static void main(String[] args) {
        int[] serverStatus = {1, 0, 1, 1, 0, 0, 1, 1, 0};
        int totalDowntime=0;
        int longDowntime=0;
        int i=0;
        
        while(i<serverStatus.length){
            if(serverStatus[i]==0){
                int count=0;
                while(i<serverStatus.length&&serverStatus[i]==0){
                    totalDowntime++;
                    count++;
                    i++;
                }
                longDowntime =Math.max(longDowntime, count);
                }
            else
            {
                i++;
            }
        }
        System.out.println("Total Downtime hours: " +totalDowntime);
        System.out.println("Longest Continuous Downtime:" +longDowntime);

    }
}