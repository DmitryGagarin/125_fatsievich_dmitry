package task;

//название класса и дженер аргумент
//дженерик аргумент = тип данных
public class DoubleLinkedListItem<T extends Comparable<T>> {

    //создаем поля для методов
    private DoubleLinkedListItem<T> head; //head = данному любого типа T
    private DoubleLinkedListItem<T> tail; //tail = данному любого типа T
    private T data; //data - число

    //конструктор, для правильности голова и хвост = null
    public DoubleLinkedListItem(T data){
        head = tail = null; //по условию должны быть равны ничему
        this.data = data;
    }

    //getNext - получает значение хвоста, по условию равно Null, никак не меняется
    public DoubleLinkedListItem<T> getNext(){
        this.tail = tail;
        return tail;
    }
    //getPrev - получает значение головы, по условию равно null, никак не изменяется
    public DoubleLinkedListItem<T> getPrev(){
        this.head = head;
        return head;
    }
    //getData - возвращает ссылку на объект, поэтому не можем использовать обозначение как
    //в предыдущих вариантах, так как head,tail могут быть чем угодно, а data Только числом
    public T getData(){
        return  data;
    }
    //setNext - устанавливает ссылку на хвост
    public void setNext(DoubleLinkedListItem<T> newTail){
        this.tail = newTail;
    }
    //setPrev - устанавливает ссылку на голову
    public void setPrev(DoubleLinkedListItem<T> newHead){
        this.head = newHead;
    }
    //setData - устанавливает новую ссылку на элемент
    //в тестах проверяется только на наличие, но не на изменения???
    public void setData(T newData){
        this.data =  newData;
    }
}
