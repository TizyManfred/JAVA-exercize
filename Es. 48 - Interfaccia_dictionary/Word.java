package com.company;

public class Word <K, V>{
    K key;
    V value;

    public Word(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString(){
        return "La parola è: "+key+" e il suo significato è: "+value;
    }
}
