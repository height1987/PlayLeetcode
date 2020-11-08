package com.height.offer;

import java.util.ArrayList;
import java.util.List;

public class No16D13ForJava {
    public static double[] cutSquares(int[] square1, int[] square2) {
        double centx1 = getCenter(square1[0],square1[2]);
        double centy1 = getCenter(square1[1],square1[2]);
        double centx2 = getCenter(square2[0],square2[2]);
        double centy2 = getCenter(square2[1],square2[2]);

        if(centx1 == centx2){
            return getXLine(centx1,centy1+square1[2]/2,centy2+square2[2]/2,
                    centy1-square1[2]/2,centy2-square2[2]/2);
        }else{
            return getNormalLine(square1,square2);
        }


    }

    public double[] getXLine(double x,double maxy1,double maxy2,double miny1,double miny2){
        return new double[]{x,Math.min(miny1,miny2),x,Math.max(maxy1,maxy2)};
    }


    public double[] getNormalLine(int[] square1, int[] square2){
        double minX = Math.min(square1[0],square2[0]);
        double maxX = Math.max(square1[0]+square1[2],square2[0]+square2[2]);
        List<Double> line = getLine(getCenter(square1[0],square1[2]),getCenter(square1[1],square1[2]),
                getCenter(square2[0],square2[2]),getCenter(square2[1],square2[2]));
        return new double[]{minX, line.get(0) *minX+ line.get(1),maxX, line.get(0) *maxX+ line.get(1)};
    }

    public List<Double> getLine(double x1,double y1,double x2,double y2){
        Double a = (y2-y1)/(x1-x2);
        Double b = y1-x1*a;
        List<Double> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        return res;
    }
    public double getCenter(int po,int len){
        return po + len/2;
    }

    public static void main(String args[]){
        int a[] = new int[]{-1,1,3};
        int b[] = new int[]{0,0,5};
        cutSquares(a,b);
    }
}
