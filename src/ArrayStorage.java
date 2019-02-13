import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 *
 */
public class ArrayStorage {

    final static int QUANTITY = 10000;

    Resume[] storage;
    private int size;

    public ArrayStorage() {
        storage = new Resume[QUANTITY];
        size = 0;
    }

    public void update(Resume r){
        if(checkIfExist(r.uuid) == 0)
            System.out.println("ERROR: update");
    }

    public int checkIfExist(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid))
                return i;
        }
        return -1;
    }

    void clear() {
        Arrays.fill(storage,null);
        size = 0;
    }

    void save(Resume r) {
        if(size < QUANTITY) {
            if (checkIfExist(r.uuid) < 0) {
                storage[size++] = r;
            }
            else
                System.out.println("ERROR: Resume exists!");
        }
        else
            System.out.println("ERROR: QUANTITY!");

    }

    Resume get(String uuid) {
        int j = checkIfExist(uuid);
        if(j < 0) {
            System.out.println("ERROR: No such resume!");
            return null;
        }
        else
            return storage[j];
    }

    void delete(String uuid) {
        int j = checkIfExist(uuid);
        if(j < 0) {
            System.out.println("ERROR: No such resume!");
            return;
        }
        storage[j] = storage[--size];
        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
