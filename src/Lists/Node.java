package Lists;

class Node<T> {

    private T data;
    private Node<T> next;

    Node(T dataPortion){
        this(dataPortion, null);
    } // final del constructor

    Node(T dataPortion, Node<T> nextNode){
        data = dataPortion;
        next = nextNode;
    } // final del constructor

    T getData(){
        return data;
    }

    void setData(T data){
        this.data = data;
    }

    void setNext(Node<T> next){
        this.next = next;
    }

    Node<T> getNext() {
        return this.next;
    }
}
