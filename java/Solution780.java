public class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (ty > sy && tx > sx) {
            if (ty > tx) {
                ty %= tx;
            } else {
                tx %= ty;
            }

        }
        if (ty < sy || tx < sx)
            return false;
        return sx == tx ? (ty - sy) % sx == 0 : (tx - sx) % ty == 0;

    }
}
