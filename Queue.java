public class Queue<T>{

    private final T[] queue;
    private final int capacity;
    private int head;
    private int tail;
    private int currentSize;

    public Queue(int capacity){
        this.queue = (T[])new Object[capacity];
        this.capacity = capacity;
        this.currentSize = 0;
        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == this.capacity;
    }

    public void enqueue(T data){
        if(isFull()) return;

        queue[tail] = data;
        tail = (tail+1) % capacity;
        currentSize++;
    }

    public T dequeue(){
        if(isEmpty()) return null;

        T data = queue[head];
        head = (head+1) % capacity;
        currentSize--;
        return data;
    }


    public static void main(String[] args) {
        
        Queue<Integer> queue = new Queue<Integer>(5);

        for(int i = 0; i < 5; i++){
            queue.enqueue(i);
        }

        for(int i = 0; i < 5; i++){
            System.out.println(queue.dequeue());
        }

    }

}