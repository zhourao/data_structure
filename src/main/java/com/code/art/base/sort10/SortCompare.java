package com.code.art.base.sort10;

import java.util.Random;

/**
 * 描述: 排序对比接口
 *
 * @author zhourao
 * @create 2021-01-06 11:31 上午
 */
public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) { // 使用算法 alg 将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) { // 进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N; i++)
                a[i] = new Random().nextDouble();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 100000;
        int T = 100;

//        String alg1 = "Shell";
        String alg1 = "Insertion";
        String alg2 = "Selection";
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        System.out.println("For " + N + " random Double " + alg1 + " is " + t1);
        System.out.println("For " + N + " random Double " + alg2 + " is " + t2);

        System.out.println("For " + N + " random Double\n" + alg1 + " is " + t2 / t1 + " times faster than " + alg2);
    }
}