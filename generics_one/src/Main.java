public class Main {

    public static void main(String[] args) {
        DoubleBox<String> box = new DoubleBox<>();
        System.out.println(box.put(10, "test"));
//        System.out.println("111 -> " + box.get(111)); // null
//        System.out.println("SIZE: " + box.size()); // 0
//        System.out.println();
//
//        System.out.println("PUT: " + box.put(111, "First string")); // true
//        System.out.println("111 -> " + box.get(111)); // First string
//        System.out.println("111 -> " + box.get(22)); // null
//        System.out.println("111 -> " + box.get(3333)); // null
//        System.out.println("SIZE: " + box.size()); // 1
//        System.out.println();
//
//        System.out.println("PUT: " + box.put(22, "Second string")); // true
//        System.out.println("111 -> " + box.get(111)); // First string
//        System.out.println("111 -> " + box.get(22)); // Second string
//        System.out.println("111 -> " + box.get(3333)); // null
//        System.out.println("SIZE: " + box.size()); // 2
//        System.out.println();
//
//        System.out.println("PUT: " + box.put(3333, "First string")); // false
//        System.out.println("111 -> " + box.get(111)); // First string
//        System.out.println("111 -> " + box.get(22)); // Second string
//        System.out.println("111 -> " + box.get(3333)); // null
//        System.out.println("SIZE: " + box.size()); // 2
    }
}


class RandomBox<T> {
    private int key;
    private T value;

    public RandomBox(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public T tryUnlock(int key) {
        if (this.key == key) {
            return value;
        } else {
            return null;
        }
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}


class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;

    public  DoubleBox(RandomBox<T> first, RandomBox<T> second){
        this.first = first;
        this.second = second;
    }

    public void setFirst(RandomBox<T> first) {
        this.first = first;
    }

    public void setSecond(RandomBox<T> second) {
        this.second = second;
    }

    public boolean put(int key, T value) {
        if (first.tryUnlock(key).equals("")){
            setFirst(first);
            return true;
        }
        if (second.tryUnlock(key).equals("")){
            setFirst(first);
            return true;
        }
        return false;
    }

    public T get(int key) {
        if (first.tryUnlock(key) != null) {
            return first.tryUnlock(key);
        } else if (second.tryUnlock(key) != null){
            return second.tryUnlock(key);
        }
        return null;

    }

    public int size() {
        if (first != null && second !=null){
            return 2;
        } else if (first == null || second == null){
            return 1;
        }
        return 0;
    }
}