package Leetcode真题分门别类.查找表相关问题;

/**
 * @Author bennyrhys
 * @Date 2020-05-14 14:30
 * 思路：
 * 暴力O(N^3)
 *
 * 注意：
 * 一条直线上斜率相等(y2−y1)∗(x−x2)=(y−y2)∗(x2−x1)
 * 两个点，点重合情况特殊处理
 */
public class _149直线上最多的点数 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int i = 0;
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }

        }
        if (i == points.length - 1) {
            return points.length;
        }
        int max = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }

                }
                if (tempMax > max) {
                    max = tempMax;
                }
            }
        }
        //加上直线本身的两个点
        return max + 2;
    }
/*private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
	return (long)(y2 - y1) * (x - x2) == (long)(y - y2) * (x2 - x1);
}*/

/*private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
    BigInteger x11 = BigInteger.valueOf(x1);
    BigInteger x22 = BigInteger.valueOf(x2);
    BigInteger y11 = BigInteger.valueOf(y1);
   	BigInteger y22 = BigInteger.valueOf(y2);
    BigInteger x0 = BigInteger.valueOf(x);
    BigInteger y0 = BigInteger.valueOf(y);
    return y22.subtract(y11).multiply(x0.subtract(x22)).equals(y0.subtract(y22).multiply(x22.subtract(x11)));
}*/

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        int g1 = gcd(y2 - y1, x2 - x1);
        if(y == y2 && x == x2){
            return true;
        }
        int g2 = gcd(y - y2, x - x2);
        return (y2 - y1) / g1 == (y - y2) / g2 && (x2 - x1) / g1 == (x - x2) / g2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
