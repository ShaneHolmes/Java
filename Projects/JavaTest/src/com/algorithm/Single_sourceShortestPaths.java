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
 *   单源;
 *      没有负边 就是dijkstra
 *      一般情况就是Bellman-Ford
 *      题中是有负值的 所以用下面的算法
 */

public class Single_sourceShortestPaths {


    /**
     * 顶点到另外一个顶点的距离
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
        //起始节点到起始节点的距离  最大值代表不可达
        pathVals[0] = 0;
        for (int i = 1; i < v; i++) {
            pathVals[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < v; i++) {
            for (int j = 0; j < edges.length; j++) {
                //第一次进入的就是针对与起始节点A 的边(两条或者一条 或者很多条)
//             if (pathVals[edges[j].to] > pathVals[edges[j].from] + edges[j].val) {
//                 pathVals[edges[j].to] = pathVals[edges[j].from] + edges[j].val;
//              }
                //这里就是动态更新了
                //这种算法每个边 都进行遍历了  时间复杂度太高了
                pathVals[edges[j].to] = pathVals[edges[j].to] > pathVals[edges[j].from] + edges[j].val
                                      ? pathVals[edges[j].from] + edges[j].val
                                      : pathVals[edges[j].to];
            }
        }
        boolean flag = true;
        /*************为什么这个时候比较呢**************/
        //因为此时 所有的pathVals 都已经是有具体的值了的
        //判断是否存在负环
        //因为有环路的时候  会影响起始节点
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
            System.out.println("有环路");
            return;
        }
        int[] pathVals = ss.getPathVals();
        for (int pathVal : pathVals) {
            System.out.print(pathVal + " ");
        }
    }
}
