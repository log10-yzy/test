package com.example.service;

public class MyThread implements Runnable{
    //Android　UI　控件在子线程里运行会出错，一般是通过一个handler对象处理
    @Override
    public void run() {
        System.out.println("线程1");
    }
}
