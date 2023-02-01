package com.company;

import java.util.ArrayList;

public class ArrayDictionary <K extends Comparable<K>, V> implements Dictionary <K, V> {
    private ArrayList<Word<K, V>> dictionary;

    public ArrayDictionary() {
        dictionary = new ArrayList<Word<K, V>>();
    }

    public int count() {
        return dictionary.size();
    }

    public void insert(K key, V value) throws Exception {
        Word<K, V> word = new Word<K, V>(key, value);
        try {
            search(word.getKey());
            throw new Exception("La parola è gia presente");
        } catch (Exception e){
            dictionary.add(word);
        }
    }

    public V search(K key) throws Exception {
        for(int i = 0; i < count(); i++){
            if(dictionary.get(i).getKey().equals(key)){
                return dictionary.get(i).getValue();
            }

        }
        throw new Exception("La parola non è presente");
    }

    public void alphaOrder(){
        for(int i = 0; i < (count()-2); i++){
            int comp = dictionary.get(i).getKey().compareTo(dictionary.get(i+1).getKey());
            if(comp > 1){
                //la prima viene dopo la seconda
                Word<K,V> temp = new Word<>(dictionary.get(i).getKey(), dictionary.get(i+1).getValue());
                dictionary.set(i, new Word<K,V>(dictionary.get(i+1).getKey(), dictionary.get(i+1).getValue()));
                dictionary.set(i+1, temp);
            }
        }
    }

    public String toString(){
        String str = "";
        if(count() == 0){
            str = str + "Il dizionario non contiene nessuna parola";
        } else {
            str = str + dictionary.toString() +"\n";
        }
        return str;
    }
}
