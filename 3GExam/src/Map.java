import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zeng
 * @Date: 2018/8/18 15:04
 */
public class Map<K,V> {
    
    private int size;
    private Node node;

    public Map(int size) {
        this.size = size;
        this.init(size);
    }

    public Map() {
        this.init(8);
    }


    public void init(int initSize) {
        this.node = new Node(initSize);
    }


    public boolean put(K key, V value) {

        if (key == null) {
            return false;
        }
        return node.put(key, value);
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        return node.get(key);
    }

    class Node {

        private int initSize;
        private int currentSize;
        private Object[] keys;
        private Object[] values;


        public Node(int initSize) {
            this.initSize = initSize;
            this.init(initSize);
        }

        private void init(int initSize) {
            this.values = new Object[initSize];
            this.keys = new Object[initSize];
            this.currentSize = 0;
        }

        private int reHash(int hash) {

            int nextHash = hash;
            int jump = 1;

            while (this.values[nextHash] != null) {

                nextHash = hash + jump;
                if (nextHash <= initSize - 1) {
                    if (this.values[nextHash] == null) {
                        return nextHash;
                    }
                }
                nextHash = hash - jump;
                if (nextHash >= 0) {
                    if (this.values[nextHash] == null) {
                        return nextHash;
                    }
                }

                if (nextHash < 0 || nextHash >= initSize) {
                    nextHash = hash;
                }
                jump++;

            }
            return -1;
        }

        public boolean put(K key, V value) {
            if (this.currentSize + 1 >= initSize) {
                return false;
            }
            int hash = key.hashCode();
            while (hash > initSize - 1) {
                hash = hash % initSize;
            }
            if (hash >= 0 && hash <= initSize - 1) {
                if (this.values[hash] == null) {
                    this.values[hash] = value;
                    this.keys[hash] = key;
                    this.currentSize++;
                } else {
                    int nextHash = this.reHash(hash);
                    if (nextHash != -1) this.values[nextHash] = value;
                    this.keys[nextHash] = key;
                    this.currentSize++;
                }
            }
            return false;
        }

        public V get(K key) {
            int hash = key.hashCode();
            while (hash > initSize - 1) {
                hash = hash % initSize;
            }
            if (this.keys[hash] == key) {
                return (V) this.values[hash];
            } else {
                int reHash = this.reHash(hash);
                if (this.keys[hash] != key) {
                    reHash = this.reHash(reHash);
                }
                if (this.keys[reHash] == key) return (V) this.values[reHash];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new Map<>();


        map.put("1", "1");

        System.out.println(map.get("1"));

    }
}
