import java.util.Arrays;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null)
            return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]) );
        int cnt = 1; // count for not overlapping jobs
        int prevFinishTime = intervals[0][1];
        for (int i = 1; i< intervals.length; i++){
            int currStartTime = intervals[i][0];
            if (prevFinishTime <= currStartTime ){
                // not overlapping
                cnt++;
                // assigning  the most recent finish time as the
                //finish time of recently selected job
                prevFinishTime = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}
