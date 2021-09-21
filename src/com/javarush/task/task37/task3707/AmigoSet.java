package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final long serialVersionUID = 1L;
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, Math.ceil(collection.size() / .75f));
        this.map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        Set<E> set = map.keySet();
        return set.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) != null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet<E> result = new AmigoSet<>();
        try {
            HashMap<E, Object> hashMap = (HashMap<E, Object>) map.clone();
            result.map = hashMap;
        } catch (Exception e) {
            throw new InternalError();
        }
        return result;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ArrayList<E> list = new ArrayList<>(map.keySet());
        out.writeObject(list);
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        List<E> list = (List<E>) in.readObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        list.forEach(x -> map.put(x, PRESENT));
        in.close();
    }
}
