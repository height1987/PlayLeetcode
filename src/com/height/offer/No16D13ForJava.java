package com.height.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 16.13. 平分正方形
 * 给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
 * 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2]。所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点）。2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
 * 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。
 *
 * 思路：纯数学题
 * 1.面积相同分隔，则肯定是2个正方形的中心点的连接线
 * 2.通过2个中心点算出y=ax+b中的a和b，如果改直线和y轴平行，则单独处理下
 * 3.当|a|<1时，直线和正方形的上下边相交，通过y坐标算出x坐标
 * 4.当|a|>=1时，直线和正方形的左右边相交，通过y坐标算出y坐标
 *
 */
public class No16D13ForJava {
    public static double[] cutSquares(int[] square1, int[] square2) {
        double centx1 = getCenter(square1[0],square1[2]);
        double centy1 = getCenter(square1[1],square1[2]);
        double centx2 = getCenter(square2[0],square2[2]);
        double centy2 = getCenter(square2[1],square2[2]);

        if(centx1 == centx2){
            return getXLine(centx1,centy1+square1[2]/2,centy2+square2[2]/2,
                    centy1-square1[2]/2.0,centy2-square2[2]/2.0);
        }else{
            return getNormalLine(square1,square2);
        }
    }

    public static double[] getXLine(double x, double maxy1, double maxy2, double miny1, double miny2){
        return new double[]{x,Math.min(miny1,miny2),x,Math.max(maxy1,maxy2)};
    }


    public static double[] getNormalLine(int[] square1, int[] square2){
        List<Double> line = getLine(getCenter(square1[0],square1[2]),getCenter(square1[1],square1[2]),
                getCenter(square2[0],square2[2]),getCenter(square2[1],square2[2]));
        if(Math.abs(line.get(0)) < 1) {
            double minX = Math.min(square1[0],square2[0]);
            double maxX = Math.max(square1[0]+square1[2],square2[0]+square2[2]);
            return new double[]{minX, line.get(0) * minX + line.get(1), maxX, line.get(0) * maxX + line.get(1)};
        }else{
            double minY = Math.min(square1[1],square2[1]);
            double minX = (minY- line.get(1))/line.get(0);
            double maxY = Math.max(square1[1]+square1[2],square2[1]+square2[2]);
            double maxX = (maxY- line.get(1))/line.get(0);
            return minX<maxX ? new double[]{minX,minY,maxX,maxY} : new double[]{maxX,maxY,minX,minY};
        }
    }

    public static List<Double> getLine(double x1, double y1, double x2, double y2){
        double a = (y2-y1)/(x2-x1);
        Double b = y1-x1*a;
        List<Double> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        return res;
    }
    public static double getCenter(int po, int len){
        return po + len/2.0;
    }

    public static void main(String args[]){
        int a[] = new int[]{249,-199,5};
        int b[] = new int[]{-1,136,76};
        cutSquares(a,b);
    }
}