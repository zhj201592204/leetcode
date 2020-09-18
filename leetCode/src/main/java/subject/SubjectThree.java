package subject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectThree {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for(int i=0; i<bookings.length; i++){
            for(int j=bookings[i][0];j<bookings[i][1]+1;j++){
                answer[j-1]+=bookings[i][2];
            }
        }
        return answer;
    }
}
