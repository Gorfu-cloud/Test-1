package com.test.pojo;

public class Page {/*当前页*/
    private int index = 1;
    /*每页几行*/
    private int size = 10;
    /*从第几页显示*/
    private int start;

    public Page(int index, int size) {
        super();
        this.index = index;
        this.size = size;
        this.start = (index - 1) * size;
    }
}