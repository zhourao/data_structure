# 8个排序算法，你了解多少？

## 1 概述

&emsp;&emsp;学习排序算法的三大实际意义：

* 对排序算法的分析将有助于你全面理解比较算法性能的方法；
* 类似的技术也能有效解决其他类型的问题；
* 排序算法常常是我们解决其他问题的第一步。

## 2 约定

类及位置：com.code.art.sort

### 基础函数

```java
package com.code.art.sort;

/**
 * 描述:排序模板
 */
public class SampleSort {

    public static void sort(Comparable[] a) {

    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
```

后续排序只会重点展示sort的代码

## 3 排序算法展示

| 序号 | 算法 | 类型 |
| ------ | ------ | ------ |
| 1 | 选择排序 | 普通 |
| 2 | 冒泡排序 | 普通 |
| 3 | 插入排序 | 普通 |
| 4 | 希尔排序 | 普通 |
| 5 | 归并排序 | 分治 |
| 6 | 快速排序 | 分治 |
| 7 | 桶排序 | 分治 |
| 8 | 基数排序 | 分治 |

### 3.1 选择排序

#### 步骤

* 找min：找到数组最小的那个元素
* min替换：将它和数字的第一个元素交换位置
* 循环，从2个到第N个

#### 分析

#### 实现

```java
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            //遍历找到最小的元素
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            //对元素进行交换
            exch(a, i, min);
        }
    }
}
```

### 3.2 冒泡排序

#### 步骤

#### 分析

#### 实现

```java
public class BubbleSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            //设置冒泡数量i（初始为0）
            //按冒泡范围j∈[0,a.length()-1-i)进行遍历
            for (int j = 0; j < a.length - 1 - i; j++)
                //冒泡操作：相邻元素j（初始值0）和j+1进行比较
                // 如a[j]>a[j+1]则交换位置
                if (less(a[j + 1], a[j]))
                    exch(a, j, j + 1);
    }
}
```

### 3.3 插入排序

#### 步骤

#### 分析

#### 实现

```java
public class Insertion {

    public static void simpleSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            //将a[j]插入到a[j-1]、a[j-2]...a[0]之中
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }
}
```

### 3.4 希尔排序

#### 步骤

#### 分析

#### 实现

```java
public class Shell {

    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        for (int h = a.length / 2; h > 0; h /= 2)
            for (int i = h; i < a.length; i++)
                //将a[j]插入到a[j-h]、a[j-2h]、a[j-3h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
    }
}
```

### 3.5 归并排序

#### 步骤

#### 分析

#### 实现

```java
public class Merge {

    //归并所需的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    //将数组a[lo..li]排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //将左半边排序
        sort(a, lo, mid);
        //将右半边排序
        sort(a, mid + 1, hi);
        //归并结果
        merge(a, lo, mid, hi);
    }

    //将a[lo..mid]和a[mid+1..hi]归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //j将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) aux[k] = a[k];
        //归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
```

### 3.6 快速排序

#### 步骤

#### 分析

#### 实现

```java
public class Quick {

    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    //将数组a[lo..li]排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        // 元素过少的时候使用插入排序优化
        // if (hi <= lo + 16) { Insertion.sort(a);return; }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);  //将左半部分a[lo..j-1]排序
        sort(a, j, hi); //将右半部分a[j..hi]排序
    }

    //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1; //左右扫描指针
        Comparable v = a[lo];
        while (true) {//扫描左右，检查是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); //将v = a[j]放入正确的位置
        return j; //a[lo..j-1] <= a[j] <= a[j+1..hi]达成
    }
}
```

### 3.7 桶排序

#### 步骤

#### 分析

#### 实现

### 3.8 基数排序

#### 步骤

#### 分析

#### 实现

## CHANGELOG

##### 2021年03月16日16:04:40 创建