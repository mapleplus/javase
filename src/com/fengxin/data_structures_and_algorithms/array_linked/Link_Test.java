package com.fengxin.data_structures_and_algorithms.array_linked;

/**
 * @author FENGXIN
 * 单链表的实现
 * 下标索引head.next 从0开始
 * 说明：指定位置的操作时，以第一个结点head.next为起始结点，for循环中索引 (i = 0;i < index;i++) 即为指定位置index的前一个位置
 **/
public class Link_Test {
    public static void main (String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<> ();
        linkedList.addFirst (7);
        linkedList.addFirst (2);
        linkedList.addFirst (1);
        linkedList.add (3,0);
        linkedList.remove (2);
        linkedList.addFirst (6);
        linkedList.addLast (4);
        System.out.println (linkedList.get (4));
        linkedList.printLinkedList ();
    }
}
// 单链表类
class LinkedList<E> {
//    单链表结点
    public static class Node<E> {
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
        tail = newNode;
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
            return;
        }
        Node<E> newNode = new Node<>(value);
        //移动到指定位置的前一个位置
        Node<E> prev = head;
        for (int i = 0 ; i < index; i++) {
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
    public void remove(int index){
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
        for (int i = 0 ; i < index; i++) {
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
        Node<E> getNode = head.next;
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