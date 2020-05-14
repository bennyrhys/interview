package Leetcode真题分门别类.查找表相关问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author bennyrhys
 * @Date 2020-05-14 11:35
 * 思路：
 * 暴力O(N^3)不可取，500可以O(n^2)
 * jk到点i的相同距离，map（距离，存在的点个数）。
 * 可选择的个数n！
 *
 * 复杂度：
 * 时间O(N^2)
 * 空间O(N)
 *
 * 注意：
 * 空间越界int long
 * int float引发的问题可以用平方避免
 *
 * 推荐149
 */
public class _447回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        // i 遍历二维数组第一列
        for (int i = 0; i < points.length; i++) {
            // map 中存储点 i 到所有其他点的距离出现的频次
            Map<Integer,Integer> map = new HashMap<>();
            // j 遍历二维数组第二列
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 计算距离时不进行开根运算, 以保证精度（反正距离相等）
                    int dis = dis(points[i], points[j] );
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            // 排列组合，例如：三个数选两个并且可以改变顺序，也就是A32 = 3 * 2
            for (int dis : map.keySet() ) {
                ans += (map.get(dis) ) * (map.get(dis) - 1);
            }
        }
        return ans;
    }

    // 计算距离（平方和）
    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
