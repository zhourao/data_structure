package com.code.art.structure.queue;

/**
 * 描述:队列接口
 * 先进先出（FIFO）队列
 *
 * @author zhourao
 * @create 2021-01-05 3:41 下午
 */
public interface Queue<E> {

    /**
     * 入队列：添加一个元素
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队列
     *
     * @return
     */
    E dequeue();

    /**
     * 获取集合大小
     *
     * @return 集合的大小
     */
    int getSize();

    /**
     * 获取集合是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();
}