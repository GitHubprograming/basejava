import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    final int QUANTITY = 10000;

    Resume[] storage;
    int num;

    public ArrayStorage(){
        storage = new Resume[QUANTITY];
        num = 0;
    }

    void clear() {
        for(int i = 0; i < num; i++){
            storage[i] = null;
        }
        num = 0;
    }

    void save(Resume r) {
        storage[num++] = r;
    }

    Resume get(String uuid) {
        for(int i = 0; i < num; i++){
            if(storage[i].toString() == uuid)
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < num; i++){
            if(storage[i].toString() == uuid){
                storage[i] = storage[--num];
                storage[num] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage,num);
    }

    int size() {
        return num;
    }
}
