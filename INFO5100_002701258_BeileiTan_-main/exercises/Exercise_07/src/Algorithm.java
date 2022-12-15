import java.util.Collection;
import java.util.List;

public final class Algorithm {
    //Question 1: count the number of elements in a collection
    public static <T> int countNumber(Collection<T> list, SomeSpecialCollection<T> p){
        int count = 0;
        for(T element : list){
            if(p.match(element)){
                count++;
            }
        }
        return count;
    }
    //Question 2: exchange the positions of two different elements in an array.
    public static <T> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //Question 3: find the maximal element in the range [begin, end) of a list.
    public static <T extends Object & Comparable<? super T>>
    T max(List<? extends T> list, int begin, int end) {

        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
}
