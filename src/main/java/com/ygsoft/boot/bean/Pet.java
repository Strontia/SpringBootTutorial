package com.ygsoft.boot.bean;

/**
 * 宠物组件
 */
public class Pet {
    private String name;

    public Pet(){

    }
    public Pet(String name){
        this.name = name;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    /**
     * 重写toString()方法
     * @return
     */
    @Override
    public String toString() {
        return "{Pet{" +
                "name = '" + name + '\'' +
                '}';
    }
}
