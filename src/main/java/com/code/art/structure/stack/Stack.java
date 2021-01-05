package com.code.art.structure.stack;

/**
 * 描述: 栈接口
 * 下压（后进先出，LIFO）栈
 *
 * @author zhourao
 * @create 2021-01-05 3:16 下午
 */
public interface Stack<E> {

    /**
     * 入栈
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return 栈顶元素
     */
    E pop();

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