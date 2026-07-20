package classes.intList;

public class intVector implements intList {
    private int vectorLength;
    private int[] intVector;
    private int usedIndex;

    public intVector() {
        setVectorLength(20);
        intVector = new int[vectorLength];
        setUsedIndex(0);
    }

    public int getVectorLength() {
        return vectorLength;
    }

    public void setVectorLength(int vectorLength) {
        this.vectorLength = vectorLength;
    }

    public int[] getIntVector() {
        return intVector;
    }

    public void setIntVector(int[] intVector) {
        this.intVector = intVector;
    }

    public int getUsedIndex() {
        return usedIndex;
    }

    public void setUsedIndex(int usedIndex) {
        this.usedIndex = usedIndex;
    }

    @Override
    public void add(int number) {
        int oldLength = intVector.length;
        for (int i = usedIndex; i <= oldLength; i++) {
            if (i == vectorLength) {
                int newLength = vectorLength * 2;
                setVectorLength(newLength);
                int[] newIntArray = new int[newLength];
                for (int x = 0; x < oldLength; x++) {
                    newIntArray[x] = intVector[x];
                    if (x == (oldLength - 1)) {
                        newIntArray[x+1] = number;
                    }
                }
                setIntVector(newIntArray);
                usedIndex++;
            }
            else {
                intVector[i] = number;
                usedIndex++;
                break;
            }
        }
    }

    @Override
    public void get(int id) {
        if (id < vectorLength && id >= 0) {
            System.out.println("The number in the vector is " + intVector[id]);
        }
        else {
            System.out.println("Index out of bounds.");
        }
    }
}
