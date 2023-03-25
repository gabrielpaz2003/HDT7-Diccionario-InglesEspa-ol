import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public List<V> inOrder() {
        List<V> values = new ArrayList<>();
        inOrder(root, values);
        return values;
    }

    private void inOrder(Node x, List<V> values) {
        if (x == null) {
            return;
        }

        inOrder(x.left, values);
        values.add(x.value);
        inOrder(x.right, values);
    }
}

