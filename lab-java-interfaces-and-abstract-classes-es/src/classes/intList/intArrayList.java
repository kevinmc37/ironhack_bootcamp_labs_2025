package classes.intList;

public class intArrayList implements intList {
    private int arrayLength;
    private int[] intArray;
    private int usedIndex;

    public intArrayList() {
        setArrayLength(10);
        intArray = new int[arrayLength];
        setUsedIndex(0);
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public int getUsedIndex() {
        return usedIndex;
    }

    public void setUsedIndex(int usedIndex) {
        this.usedIndex = usedIndex;
    }

    @Override
    public void add(int number) {
        int oldLength = intArray.length;
        for (int i = usedIndex; i <= oldLength; i++) {
            if (i == arrayLength) {
                int newLength = arrayLength + (arrayLength / 2);
                setArrayLength(newLength);
                int[] newIntArray = new int[newLength];
                for (int x = 0; x < oldLength; x++) {
                    newIntArray[x] = intArray[x];
                    if (x == (oldLength - 1)) {
                        newIntArray[x+1] = number;
                    }
                }
                setIntArray(newIntArray);
                usedIndex++;
            }
            else {
                intArray[i] = number;
                usedIndex++;
                break;
            }
        }
    }

    @Override
    public void get(int id) {
        if (id < arrayLength && id >= 0) {
            System.out.println("The number in the array is " + intArray[id]);
        }
        else {
            System.out.println("Index out of bounds.");
        }
    }
}
