public class BST<T extends Comparable> {
    Node<T> root;
    int size;

    BST(){

    }

    public boolean insert(T element){
        Node<T> parrent = null;
        Node<T> current = root;

        if(root == null){
            root = new Node<>(element);
            size++;
            return true;
        } else {
            while (current != null){
                if(current.data.compareTo(element) > 0){
                    parrent = current;
                    current = current.left;
                } else if(current.data.compareTo(element) < 0){
                    parrent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if(parrent.data.compareTo(element) > 0){
                parrent.left = new Node<>(element);
            } else {
                parrent.right = new Node<>(element);
            }
            size++;
            return true;
        }
    }
    public Node<T> findMax(Node<T> root){
        while (root.right!= null){
            root = root.right;
        }
        return root;
    }
    public Node<T> findMin(Node<T> root){
        while (root.left!= null){
            root = root.left;
        }
        return root;
    }
    public void remove(T element){
        remove(root, element);
    }
    private Node<T> remove(Node<T> root, T element){
        if(root == null){
            return root;
        } else {
            if(root.data.compareTo(element) > 0){
                root.left = remove(root.left, element);
            } else if(root.data.compareTo(element) < 0){
                root.right = remove(root.right, element);
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                root.data = findMin(root.right).data;
                root.right=  remove(root.right, root.data);
            }
        }
        return root;
    }
    public void preorder(){
        preorder(root);
        size--;
    }
    private void preorder(Node<T> root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
