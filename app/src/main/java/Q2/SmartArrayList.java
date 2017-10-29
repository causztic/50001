
package Q2;

import java.util.Arrays;

public class SmartArrayList {
    private static final int INIT_CAPACITY = 2;
    private int size=0;  // no of element stored
    private String[] data = new String[INIT_CAPACITY]; // where the element stored


    public SmartArrayList() {

    }

    public void add(int index, String s) {
        // check 0<= index <= size
        // when index == size, append to the end
        if (index >= 0 && index < size){
                //if (size >= data.length){
                    // index is over the current size, copy the current array and increase the size
                data = Arrays.copyOf(data, data.length * 2);
                //}
                for (int i = size; i >= index; i--){
                    // shift the items
                    data[i+1] = data[i];
                }
                // increase size
                data[index] = s;
                size++;
        }
        else if (index == size){
            data[index] = s;
            size++;
        }
    }

    public void add(String s) {
        if (size == data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = s;
        size++;
    }

    public String get(int index) {
        if (isValidIndex(index)){
            return data[index];
        } else {
            return null;
        }
    }

    public void set(int index, String s){
        if (isValidIndex(index)) {
            data[index] = s;
        }
    }

    public void remove(int index) {
        if (isValidIndex(index)){
            for (int i = index; i < size; i++){
                if (data.length == i+1){
                    data[i] = null;
                } else {
                    data[i] = data[i+1];
                }
            }
            size--;
        }
    }

    private boolean isValidIndex(int index){
        return index < size && index >= 0;
    }

    @Override
    public String toString(){
        // TODO: IMPLEMENT THE METHOD
        return Arrays.toString(Arrays.copyOfRange(data, 0, size));
    }


}
