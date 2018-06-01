package com.algorithm;

import org.junit.Test;

import javax.swing.text.GapContent;
import javax.swing.text.ParagraphView;

/**
 * @Author: WuDuoXian
 * @Date: 2018.5.2
 * @Description:
 *
 *
 *   ��Դ;
 *      û�и��� ����dijkstra
 *      һ���������Bellman-Ford
 *      �������и�ֵ�� ������������㷨
 */

public class Single_sourceShortestPaths {


    /**
     * ���㵽����һ������ľ���
     */
    private int[] pathVals;

    private  static class Edge {
        private int from;
        private int to;
        private int val;

        Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;

        }
    }

    private boolean getShortestPath(int v, Edge[] edges) {
        pathVals = new int[v];
        //��ʼ�ڵ㵽��ʼ�ڵ�ľ���  ���ֵ�����ɴ�
        pathVals[0] = 0;
        for (int i = 1; i < v; i++) {
            pathVals[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < v; i++) {
            for (int j = 0; j < edges.length; j++) {
                //��һ�ν���ľ����������ʼ�ڵ�A �ı�(��������һ�� ���ߺܶ���)
//             if (pathVals[edges[j].to] > pathVals[edges[j].from] + edges[j].val) {
//                 pathVals[edges[j].to] = pathVals[edges[j].from] + edges[j].val;
//              }
                //������Ƕ�̬������
                //�����㷨ÿ���� �����б�����  ʱ�临�Ӷ�̫����
                pathVals[edges[j].to] = pathVals[edges[j].to] > pathVals[edges[j].from] + edges[j].val
                                      ? pathVals[edges[j].from] + edges[j].val
                                      : pathVals[edges[j].to];
            }
        }
        boolean flag = true;
        /*************Ϊʲô���ʱ��Ƚ���**************/
        //��Ϊ��ʱ ���е�pathVals ���Ѿ����о����ֵ�˵�
        //�ж��Ƿ���ڸ���
        //��Ϊ�л�·��ʱ��  ��Ӱ����ʼ�ڵ�
        for (int k = 0; k < v; k++) {
            if (pathVals[edges[k].to] > pathVals[edges[k].from] + edges[k].val) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public int[] getPathVals() {
        return pathVals;
    }

    @Test
    public void testBellmanFord() {
        int v = 4;
        Edge[] edges = {
                new Edge(0, 1, 6),
                new Edge(0, 2, -3),
                new Edge(2, 0, -3),
                new Edge(1, 2, 2),
                new Edge(1, 3, 5),
                new Edge(2, 3, 3)
        };

        Single_sourceShortestPaths ss = new Single_sourceShortestPaths();
        boolean shortestPath = ss.getShortestPath(v, edges);
        System.out.println(shortestPath);
        int[] pathVals = ss.getPathVals();
        for (int pathVal : pathVals) {
            System.out.print(pathVal + " ");
        }
    }

    @Test
    public void testBellmanFord2() {
        int v = 5;
        Edge[] edges = {
                new Edge(0, 1, -1),
                new Edge(0, 2, 3),
                new Edge(1, 2, 3),
                new Edge(1, 3, 2),
                new Edge(1, 4, 2),
                new Edge(3, 1, 1),
                new Edge(3, 2, 5),
                new Edge(4, 3, -3)
        };

        Single_sourceShortestPaths ss = new Single_sourceShortestPaths();
        boolean flag = ss.getShortestPath(v, edges);
        if (!flag) {
            System.out.println("�л�·");
            return;
        }
        int[] pathVals = ss.getPathVals();
        for (int pathVal : pathVals) {
            System.out.print(pathVal + " ");
        }
    }
}
