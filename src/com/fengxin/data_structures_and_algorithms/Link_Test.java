package com.fengxin.data_structures_and_algorithms;

/**
 * @author FENGXIN
 * @data 2024.4.29
 * 单链表的实现
 * 说明：指定位置的操作时，以头结点head为起始结点，for循环中索引 (i < index - 1) 即为指定位置的前一个位置
 * (i < index) 即为指定位置
 **/
public class Link_Test {
    public static void main (String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<> ();
        linkedList.addFirst (5);
        linkedList.addFirst (4);
        linkedList.addFirst (3);
        linkedList.addFirst (2);
        linkedList.addFirst (1);
        linkedList.printLinkedList ();
        System.out.println ();
        linkedList.add (3,6);
        linkedList.printLinkedList ();
        System.out.println ();
        linkedList.remove (3);
        linkedList.printLinkedList ();
        System.out.println ();
        System.out.println (linkedList.get (3));
        linkedList.set (3,7);
        linkedList.printLinkedList ();
        System.out.println ();
    }
}
// 单链表类
class LinkedList<E> {
//    单链表结点
    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value){
            this.value = value;
            this.next = null;
        }
}
//    链表头
    Node<E> head;
//    链表长度
    private int size;
//    链表尾
    Node<E> tail;
//    链表构造函数
    public LinkedList() {
        this.head = new Node<> (null);
        tail = head;
        this.size = 0;
    }
//     添加元素在链表头部
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head.next;
        head.next = newNode;
        //如果添加之前链表为空，头尾结点是相等的地址，则需要更新尾节点指向新节点
        if (tail == head) {
            tail = newNode;
        }
        size++;
    }
//     添加元素在链表尾部
    public void addLast(E value){
        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        newNode = tail;
        size++;
    }
//    添加元素在指定位置
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引超出范围");
        }
        //如果索引等于链表长度，则直接添加到链表尾部
        if(index == size){
            addLast(value);
        }
        Node<E> newNode = new Node<>(value);
        //移动到指定位置的前一个位置
        Node<E> prev = head;
        for (int i = 0 ; i < index - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
//    删除链表头部元素
    public E removeFirst() {
        //如果链表为空，则抛出异常
        if (head.next == null) {
            throw new IllegalArgumentException("链表为空");
        }
        Node<E> first = head.next;
        head.next = first.next;
        first.next = null;
        //如果删除后链表为空，则更新尾节点
        if(size == 1)
        {
            final boolean b = tail == head;
        }
        size--;
        return first.value;
    }
//    删除链表尾部元素
    public E removeLast(){
        //如果链表为空，则抛出异常
        if(head.next == null){
            throw new IllegalArgumentException("链表为空");
        }
        Node<E> prev = head;
        //移动到尾节点的前一个位置
        while (prev.next != tail){
            prev = prev.next;
        }
        //保存尾节点的值
        E val = tail.value;
        //删除尾节点
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
//    删除指定位置的元素
    public E remove(int index){
//        如果索引小于0或者大于等于链表长度，则抛出异常
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引超出范围");
        }
//        如果链表为空，则抛出异常
        if(head.next == null){
            throw new IllegalArgumentException("链表为空");
        }
        //移动到指定位置的前一个位置
        Node<E> prev = head;
        for (int i = 0 ; i < index - 1; i++) {
            prev = prev.next;
        }
        Node<E> toRemove = prev.next;
        prev.next = toRemove.next;
        //如果删除的节点是尾节点，则更新尾节点
        if(toRemove == tail){
            tail = prev;
        }
        size--;
        toRemove.next = null;
        return toRemove.value;
    }
//    获取链表头部元素
    public E getFirst() {
        //如果链表为空，则抛出异常
        if (head.next == null) {
            throw new IllegalArgumentException("链表为空");
        }
        return head.next.value;
    }
//    获取链表尾部元素
    public E getLast(){
        //如果链表为空，则抛出异常
        if (head.next == null) {
            throw new IllegalArgumentException("链表为空");
        }
        return tail.value;
    }
//    获取指定位置的元素
    public E get(int index){
        //如果索引小于0或者大于等于链表长度，则抛出异常
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引超出范围");
        }
        //如果链表为空，则抛出异常
        if(head.next == null){
            throw new IllegalArgumentException("链表为空");
        }
        //移动到指定位置
        Node<E> getNode = head;
        for (int i = 0 ; i < index ; i++) {
            getNode = getNode.next;
        }
        return getNode.value;
    }
//    获取链表长度
    public int getSize(){
        return size;
    }
//    修改指定链表位置的元素
    public void set(int index, E value){
        //如果索引小于0或者大于等于链表长度，则抛出异常
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引超出范围");
        }
        //如果链表为空，则抛出异常
        if(head.next == null){
            throw new IllegalArgumentException("链表为空");
        }
        //移动到指定位置
        Node<E> setNode = head;
        for (int i = 0 ; i < index ; i++){
            setNode = setNode.next;
        }
        setNode.value = value;
        System.out.println ("修改成功" +index +"的值为" + value);
    }
//    打印链表
    public void printLinkedList(){
        //如果链表为空，则抛出异常
        if(head.next == null){
            throw new IllegalArgumentException("链表为空");
        }
        //移动到第一个元素
        Node<E> printNode = head.next;
        for (int i = 0 ; i < size ; i++){
            if(printNode.next == null)
            {
                System.out.print (printNode.value);
                break;
            }
            System.out.print (printNode.value +"--->");
            printNode = printNode.next;
        }
    }
}