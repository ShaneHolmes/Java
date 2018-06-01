package com.algorithm;

import org.junit.Test;

/**
 * @Author: WuDuoXian
 * @Date: 2018.5.1
 * @Description:
 * 2��A simple scheduling problem. We are given jobs j1, j2�� jn, all with known running
 *  times t1, t2�� tn, respectively. We have a single processor. What is the best way to schedule
 *   these jobs in order to minimize the average completion time. Assume that it is a nonpreemptive
 *    scheduling: once a job is started, it must run to completion. The following is an instance.
a)(j1, j2, j3, j4) : (15��8��3��10)
 */

public class SchedulingProblem {
    /**
     * ��Ϊ�����Ƿ���ռʽ����
     * Ҫ�����ƽ�����ʱ��  ����С����ǰ  ����ں�
     * jobs �������������Ҫ��ʱ��
     */
    public int[] scheduledTimer(int[] jobs) {
        int[] res = new int[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            res[i] = getMin(jobs);
        }
        return res;
    }

    /**
     * �õ�һ�������е���Сֵ���±�
     *  һ�εõ��±�֮��ͽ����޸�
     */
    private int getMin(int[] p) {
        int minIndex = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] < p[minIndex]) {
                minIndex = i;
            }
        }
        p[minIndex] = Integer.MAX_VALUE;
        return minIndex;
    }


    @Test
    public void testScheduling() {
        int[] jobs = {15, 8, 3, 10};
        SchedulingProblem sp = new SchedulingProblem();
        int[] jobsSeq = sp.scheduledTimer(jobs);
        for (int i = 0; i < jobsSeq.length; i++) {
            if (i != jobsSeq.length - 1) {
                System.out.print("job" + jobsSeq[i] + "-->");
            } else {
                System.out.print("job" + jobsSeq[i]);
            }
        }
    }


    @Test
    public void ttt(){
        int[] jobs = {15, 8, 3, 10};
        int min = getMin(jobs);
        System.out.println(min);

        min = getMin(jobs);
        System.out.println(min);
        min = getMin(jobs);
        System.out.println(min);
        min = getMin(jobs);
        System.out.println(min);
    }
}
