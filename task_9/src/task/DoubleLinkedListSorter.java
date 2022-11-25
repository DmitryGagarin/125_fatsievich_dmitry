package task;

//ВНИМАНИЕ
//!!!! лист будет сортировать не величины (числа, строки), а дату элементов
//ВНИМАНИЕ

//название класса
public class DoubleLinkedListSorter {
    //делаем метод со сравниваемым джнерик атрибутом и названием метода
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        //очевидно, что лист не будет пустой
        //всегда увеличиваем размер листа на 1, добавляем в новый списко новый элемент

        //создаем луп с размером отсортированного листа, чтобы увеличивать его длину
        for (int sortedListSize = 0; sortedListSize <= list.getSize(); sortedListSize++ ) {
            //создаем новый элемент сортированного списка
            DoubleLinkedListItem<T> element = list.getFirst();
            int i = 0;
            //делаем луп, который будет увеличивать размер нового списка до момента, пока
            //кол-во раз не будет меньше старого листа - новый лист - 1
            //потому что i будет равен 1
            while (i < list.getSize() - sortedListSize - 1){
               // if (element.getData().equals(element.getNext().getData()) >= 0){
//The equals() tells the equality of two strings
//whereas the compareTo() method tell how strings are compared lexicographically.
                //если дата элемента по сравнению с датой следующего элемента не равно, то создаем новую дату
                if (element.getData().compareTo(element.getNext().getData()) > 0) {
                    //тип даты всегда Т, а не название класса<T>!!!
                    T newData = element.getData();
                    //даем элементу новую дату, а именно дату следущего элемента
                    element.setData(element.getNext().getData());
                    //устанавляваем дате следующего элемента новую дату
                    element.getNext().setData(newData);
                }
                //в конце должны добавить, что элемент равен следующему элементу
                element = element.getNext();
                i++;
            }
        }
    }
}
