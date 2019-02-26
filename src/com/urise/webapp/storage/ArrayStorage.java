package com.urise.webapp.storage;

import com.urise.webapp.model.*;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 *
 */
public class ArrayStorage {

    private static final int STORAGE_LIMIT = 10000;

    private Resume[] storage;
    private int size;

    public ArrayStorage() {
        storage = new Resume[STORAGE_LIMIT];
        size = 0;
    }

    public void update(Resume r){
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " doesn't exist!");
        } else {
            storage[index] = r;
        }
    }

    public void clear() {
        Arrays.fill(storage,null);
        size = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exists!");
        } else if(size == storage.length) {
            System.out.println("Storage overflow");
        } else{
        storage[size++] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if(index == -1) {
            System.out.println("Resume " + uuid + " doesn't exist!");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index == -1) {
            System.out.println("Resume " + uuid + " doesn't exist!");
        }else {
            storage[index] = storage[--size];
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid))
                return i;
        }
        return -1;
    }
}
