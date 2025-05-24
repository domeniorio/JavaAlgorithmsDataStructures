
public class Stack{

    private int[] stack;
    private int maxSize;
    private int currentSize;

    public Stack(int maxSize){
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
        this.currentSize = 0;
    }


    public void push(int elem){
        if(this.currentSize == this.maxSize){
            System.out.println("Stack overflow");
            return;
        }
        this.stack[currentSize] = elem;
        this.currentSize++;
    }

    public int pop(){
        if(this.isEmpty()){
            System.out.println("Lo stack è vuoto");
            return -1;
        }
        currentSize--;
        return this.stack[currentSize];
    }

    public boolean isEmpty(){
        if(this.currentSize <= 0) return true;
        else return false;
    }


    public static void main(String[] args) {

        Stack stack = new Stack(5);

        stack.pop();
        stack.push(10);
        stack.push(15);
        System.out.println(stack.pop());

    }

}