package solution;

public class RedBlackTree {
    private static final Node EMPTY = new Node(0);

    static {
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }

    protected Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return (header.left == EMPTY) && (header.right == EMPTY);
    }

    public void clear() {
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public void insert(int item) {
        current = grand = parent = header;
        System.out.println("current = " + current.element + " current color = " + current.color);
        EMPTY.element = item;
        while (current.element != item) {
            great = grand;
            System.out.println("great = " + great.element + " great color = " + great.color);
            grand = parent;
            System.out.println("grand = " + grand.element + " grand color = " + grand.color);
            parent = current;
            System.out.println("parent = " + parent.element + " parent color = " + parent.color);
            current = item > current.element ? current.right : current.left;
            System.out.println("current = " + current.element + " current color = " + current.color);
            if (current.left.color == Color.BLACK && current.right.color == Color.BLACK) {
                System.out.println("parent before1 = " + parent.element+ " parent color1 = " + parent.color);
                System.out.println("current before1 = " + current.element+ " current color1 = " + current.color);
                reorient(item);
                System.out.println("parent after1 = " + parent.element+ " parent color1 = " + parent.color);
                System.out.println("current after1 = " + current.element+ " current color1 = " + current.color);
            }
            System.out.println("--------------------------");
        }
        if (current != EMPTY) {
            return;
        }
        current = new Node(item, EMPTY, EMPTY);
        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }
        System.out.println("parent before = " + parent.element+ " parent color = " + parent.color);
        System.out.println("current before = " + current.element+ " current color = " + current.color);
        reorient(item);
        System.out.println("parent after = " + parent.element+ " parent color = " + parent.color);
        System.out.println("current after = " + current.element+ " current color = " + current.color);
        System.out.println("=================================");
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;
        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }
        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }

    private Node rotateWithRightNode(Node element) {
        Node right = element.right;
        element.right = right.left;
        right.left = element;
        return right;
    }

    public static enum Color {
        BLACK,
        RED
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }
    }
}