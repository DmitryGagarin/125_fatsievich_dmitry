package task;

//чтобы T стало сравниваем нужно добавить extends Comparable<T>>
public class DoubleLinkedList<T extends Comparable<T>> {

    //поля
    //если мы добавляем в голову то то, что мы добавили будет слева от голова => обозначим голову первым элементом, хвост последним
    private DoubleLinkedListItem<T> head; //первый элемент слева
    private DoubleLinkedListItem<T> tail; //последний элемент
    private int listSize; //длина спика

    //конструктор
    public DoubleLinkedList(){
        head = tail = null; //по правилам надо так
        listSize = 0; //изначально списко равен 0, что очевидно
    }

    //возвращает первый элемент с указанным значением
    //то есть, есть какой то номер элемента и этот метод возвращает этот элемент
    //проверка на существование листа должна быть
    //возвращение будет происходить по принципу запроса даты про элемент листа равной номеру с проверки
    public DoubleLinkedListItem<T> findFirstItem(T number){
        if (listSize == 0) return null; //если размер листа = 0, то в нем ничего не будет
        DoubleLinkedListItem<T> element = head; //новый элемент считаем за голову списка
        //до тех пора пока элемент не равен нулю и элемент не равен дате number приравниваем элемент к следующему
        while (element != null && !element.getData().equals(number)) {
            element = element.getNext();
            //element 1 2 3 4 5
            //number 0 1 2 3 4 5
        }
        return element;
    }

    //возвращает последний элемент с указанным значением
    //все тоже самое как и сверху, но только возвращает предыдущий, а не следующий
    public DoubleLinkedListItem<T> findLastItem(T value){
    if (listSize == 0) return null;
    DoubleLinkedListItem<T> element = tail;
    while (element != null && !element.getData().equals(value)) element = element.getPrev();
        return element;
    }

    //размещает элемент с указанным ЗНАЧЕНИЕМ после заданного.
    //Первым аргументом идет элемент списка, вторым данные.
    //сперва нужно понять номер элемента после которого мы будем вставлять новый
    //за счет того, что мы добавляем, размер листа всегда растет на 1
    //в скобках метода пишем тип данных и название переменной, а затем снова тип данных
    //public void insertBefore (int value, int) - пример
    public void insertAfter(DoubleLinkedListItem<T> numberItemWeWantInsert, T data){
        if (listSize == 0){ //проверка на нулевой лист
            head = tail = new DoubleLinkedListItem<>(data); //говорим, что голова и хваст новые элементы списка => Увеличиваем размер на 1
            listSize++;
            return;
        }
        DoubleLinkedListItem<T> item = new DoubleLinkedListItem<>(data); //создаем новый элемент списка
        if (numberItemWeWantInsert == null){ //проверка на пустой лист
            //говорим, что следующий элемент после айтема будет головой
            item.setNext(head); //первый аргумент - элемент списка
            //второй аргумент - данные, которые записываем
            head = item;
        }
        //допустим, что айтем после которого вставляем новый элемент = хвосту
        //хвост -> элемент -> голова
        else if (numberItemWeWantInsert == tail) {
            tail.setNext(item);
            tail = item;
        } //если элемент добавляют в рандомное место, но не в хвост
        else {
            item.setPrev(numberItemWeWantInsert); //говорим, что перед добавляемым предметом элементом listItem
            item.setNext(numberItemWeWantInsert.getNext());
            numberItemWeWantInsert.getNext().setPrev(item);
            numberItemWeWantInsert.setNext(item);
        }
        listSize++;
    }

    //размещает элемент с указанным ЗНАЧЕНИЕМ перед заданным
    //Первым аргументом идет элемент списка, вторым данные.
    //делаем все тоже самое, что и сверху, только getNext меняем на getPrev, setPrev На setNext и тд
    //потому что в прошлый раз мы добавляли после определенного элмента, а здесь до
    //также увеличиваем размер листа на 1
    //public void insertBefore (int value, int) - пример
    public void insertBefore (DoubleLinkedListItem<T> numberItemWeWantInsert, T data){
        if (listSize == 0){
            head = tail = new DoubleLinkedListItem<>(data);
            listSize++;
            return;
        }
        DoubleLinkedListItem<T> item = new DoubleLinkedListItem<>(data);
        if (numberItemWeWantInsert == null){
            tail.setNext(item);
            item.setPrev(tail);
            tail = item;
        }
        else if (numberItemWeWantInsert == head) {
            item.setNext(head);
            head.setPrev(item);
            head = item;
        } else {
            item.setNext(numberItemWeWantInsert);
            item.setPrev(numberItemWeWantInsert.getPrev());
            numberItemWeWantInsert.getPrev().setNext(item);
            numberItemWeWantInsert.setPrev(item);
        }
        listSize++;
    }

    //удаляет переданный элемент из списка
    //то есть у нас есть номер элемента и мы должны удалить элемент с этим номером
    //списко должен уменьшаться на 1
    public void remove(DoubleLinkedListItem<T> itemNumberRemove) { //в скобках пишется тип данного и номер элемента, который будем удалять
        if (listSize == 1){ //допустим, что лист состоит из одного элимента
            head = tail = null; //стандартное условие
        }
        else if (itemNumberRemove == tail) { //тоже самое, что и с головой, только с хвостом
            itemNumberRemove.getPrev().setNext(null);
            tail = itemNumberRemove.getPrev();
        }
        else if (itemNumberRemove == head) { //допустим, что номер айтема равен голове
            itemNumberRemove.getNext().setPrev(null); //делаем этот номер null
            head = itemNumberRemove.getNext(); //и делаем так, чтобы голова равнялась следующему удаленному элементу
        }
        else { //допустим, что элемент для удаления находится где то между головой и хвастом
            itemNumberRemove.getNext().setPrev(itemNumberRemove.getPrev());
            itemNumberRemove.getPrev().setNext(itemNumberRemove.getNext());
        }
        listSize--;
    }

    //метод, который возвращает длину списка
    public int getSize(){
        this.listSize = listSize;
        return listSize;
    }
    //метод, который возвращает первый элемент списка
    public DoubleLinkedListItem<T> getFirst(){
        this.head = head;
        return head;
    }
    //метод, который возвращает последний элемент списка
    public DoubleLinkedListItem<T> getLast(){
        this.tail = tail;
        return tail;
    }
}

