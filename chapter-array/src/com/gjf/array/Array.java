package com.gjf.array;

import java.util.Arrays;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/8
 * @Description：
 *
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
    //定义一个保存数据的整型数组
    private int data[];
    //数组长度
    private int len;
    //数组实际长度
    private int count;

    //构造方法，定义数组大小
    public Array(int len){
        this.len = len;
        data = new int[len];
        //初始化数组的实际长度
        this.count = 0;
    }
    //根据索引，找到数据中的元素并返回
    public int find(int index){
        if (index<0||index >= count)  return -1;
        return data[index];
    }
    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value){
        //没有可供插入的空间
        if (count == len){
            System.out.println("没有可供插入的空间");
            return false;
        }
        //位置的判断
        if (index < 0 || index > count){
            System.out.println("位置不合法");
            return false;
        }
        //条件满足
        //index后面的数据向后移
        for (int i = count ; i > index ; i--){
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }
    //根据索引，删除数组中元素
    public boolean delete(int index){
        if (index<0 || index >= count){
            System.out.println("地址不正确~");
            return false;
        }
        for (int i = index;i<count-1;i++){
            data[i] = data[i+1];
        }
//        data[count] = null;
        count-- ;
        return true;
    }
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Array array = new Array(5);
        int[] i = new int[5];
        System.out.println("-->"+ i[3]);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        array.delete(1);
        array.insert(3, 11);

        array.printAll();

    }
}
