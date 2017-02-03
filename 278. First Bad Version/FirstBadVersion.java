/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //binary search. if current version is bad, then the first bad version isn't in the right hand side of current position
    //otherwise, isn't in the left hand side.
    //Terminate until bounders meet: left>=right.
    public int firstBadVersion(int n) {
        long k = (1 + n)/2;
        long m = n;
        if (isBadVersion((int)k)){
            m = k;
            k = 1;
        }
        while (m-k>1){
            k = (k + m)/2;
            if (isBadVersion((int)k)){
                m = k;
                k = 1;
            }
        }
        if (!isBadVersion((int)k)){
            k = m;
        }
        return (int)k;
    }
}