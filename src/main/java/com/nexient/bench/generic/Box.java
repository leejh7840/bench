package com.nexient.bench.generic;
/*
* 제너릭은 클래스를 설계할때 구체적으로 타입을 명시하지 않고
* 타입 패러미터로 대체했다가 실제 클래스가 사용될때 구체적인 타입을
* 지정함으로써 타입변환을 최소화한다
* */
public class Box<T> {
    private T t;
    public T get() {return t;}
    public void set(T t) { this.t = t;}

    public static void main(String[] args) {
        Box<String> box = new Box<String>();
        box.set("hello");
        System.out.println(box.get());
    }
}
