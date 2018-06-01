package com.algorithm;


import org.junit.Test;

/**
 * @Author: WuDuoXian
 * @Date: 2018.5.
 * @Description:
 *            0 1 背包问题
 */

public class KnapsackProblem {

    /**
     *   01 背包问题就属于是dp问题了  需要dp矩阵
      *  分数背包 就不需要dp辅助来解决
     */

    public static class  FractionalKnapsack{
        private int[] w;
        private int[] v;
        private double[] p;
        private double[] p1;
        private  int maxCount;
        private  int curCount;
        private  double curValue;

        FractionalKnapsack() {
        }

        FractionalKnapsack(int[] v, int[] w, int maxCount) {
            this.v = v;
            this.w = w;
            this.maxCount = maxCount;
            curCount = 0;
            p = new double[w.length];
            p1 = new double[w.length];
            for (int i = 0; i < w.length; i++) {
                //初始化单位容量
                p[i] = w[i] / v[i];
            }
            for (int i = 0; i < p.length; i++) {
                p1[i] = p[i];
            }
        }

        private double greedyMax() {
            while (true) {
                int i = getMax(p);
                int c = w[i] + curCount <= maxCount ? w[i] : maxCount - curCount;
                curCount += c ;
                curValue += p1[i] * c;
                if (c < w[i]) {
                    System.out.print("");
                    break;
                }
            }
            return curValue;
        }

        private int getMax(double[] p) {
            int maxIndex = 0;
            for (int i = 1; i < p.length; i++) {
                if (p[i] > p[maxIndex]) {
                    maxIndex = i;
                }
            }
            p[maxIndex] = -1;
            return maxIndex;
        }
    }

    /**
     * 0 1 就是要么全拿要么都不拿
     *    所以就是一个动态规划问题 dp
     *    c[i][j] 就是
     *              选择第i个时候
     *              此时重量为j 的时候所对应的价值
     *
     *这个动态规划相当于是最简单的动态规划了
     */
    public static class Knapsack_0_1 {

        private int maxWeight;
        private int[] weights;
        private int[] values;
        private int[][] dp;

        private int greedyGetMax(int maxWeight,int[] weights,int[] values) {
            this.maxWeight = maxWeight;
            this.weights = weights;
            this.values = values;
            dp = new int[weights.length][maxWeight + 1];
            //然后在进行初始化:初始化行 初始化列
            for (int i = 0; i < weights.length; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i <= maxWeight; i++) {
                dp[0][i] = 0;
            }
            //然后在通过公式进行初始化
            for (int i = 1; i < weights.length; i++) {
                for (int j = 1; j <= maxWeight; j++) {
                    dp[i][j] = j - weights[i] >= 0 ? Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]) : dp[i - 1][j];
                }
            }
            return dp[weights.length - 1][maxWeight];
        }

    }

    /**
     * 分数测试
     */
    @Test
    public void testFractional() {
        int[] w = {10, 20};
        int[] v = {5, 20};
        int maxCount = 25;
        FractionalKnapsack fk = new FractionalKnapsack(v, w, maxCount);
        System.out.println(fk.greedyMax());
    }

    /**
     * 01 dp测试
     */
    @Test
    public void test01Knapsack (){
        int[] weights = {1, 2, 5, 6, 7};
        int[] values = {1, 6, 18, 22, 28};
        int maxCount = 11;
        Knapsack_0_1 sack01 = new Knapsack_0_1();
        System.out.println(sack01.greedyGetMax(maxCount, weights, values));
    }

    /**
     * 分数 getMax方法测试
     */
    @Test
    public void testGetMax(){
        double[] p = {2.0, 1.0};
        FractionalKnapsack fk = new FractionalKnapsack();
        System.out.println(fk.getMax(p));
        System.out.println(fk.getMax(p));
    }
}


