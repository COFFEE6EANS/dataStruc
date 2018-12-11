package com.gjf.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/8
 * @Description：
 */
public class GenericArray<T> {

    //数据
    private T data[];

    //当前有多少数据
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity){
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    // 无参构造方法，默认数组容量为10
    public GenericArray(){
        this(10);
    }
    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }
    // 获取当前元素个数
    public int count() {
        return size;
    }
    // 判断数组是否为空
    public boolean isEmpty() {
        return size==0;
    }
    // 修改 index 位置的元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }
    // 获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }
    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public GenericArray<T> add(int index, T e) {
        checkIndex(index);
        //判断容器大小
        //如果当前元素个数等于数组容量，则将数组扩容为原来的2倍   O(n)
        if (size == data.length) {
            resize(2 * size);
        }
        //O(m)
        for (int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
        return this;
    }
    // 向数组头插入元素
    public GenericArray<T> addFirst(T e) {
        return add(0,e);
    }
    // 向数组尾插入元素
    public GenericArray<T> addLast(T e) {
        return add(size,e);
    }
    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndexForRemove(index);

        T ret = data[index];
        //判断容器大小
        for (int i = index;i < size-1 ;i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;

        //缩容
        //当前容器中数组有数据的大小不到申明数组长度的1/4，说明可以将申明的数组缩小成之前的1/2
        if (size <= data.length/4 ){
            resize(data.length/2);
        }
        return ret;
    }
    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }
    // 删除末尾元素
    public T removeLast() {
        return remove(size-1);
    }
    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index!=-1){
            remove(index);
        }
//        List
    }
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("Array size = %d, capacity = %d \n",size,data.length));
        strBuilder.append("[");
        for (int i=0;i<size;i++){
            strBuilder.append(data[i]);
            if (i!=size-1){
                strBuilder.append(",");
            }
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }
    // 扩容或缩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData = (T[])  new Object[capacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }
    private void checkIndexForRemove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }
    public static void main(String[] args) {
        GenericArray<String> genericArray = new GenericArray(5);
        System.out.println(genericArray.addLast("aa").addLast("bb").addFirst("cc"));
        System.out.println(genericArray.addLast("aa").addLast("bb").addFirst("cc"));
        genericArray.remove(0);
        genericArray.remove(0);
        genericArray.remove(0);
        genericArray.remove(0);
        genericArray.remove(0);
        genericArray.remove(0);
        System.out.println(genericArray);
    }
}
