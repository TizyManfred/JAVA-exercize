package com.company;

public interface Dictionary <K, V>{
    public void insert(K key, V valore) throws Exception;
    public V search(K key) throws Exception;
    public int count();

}
