package net.mint.psi.utils;


import com.intellij.openapi.util.Pair;
import com.intellij.util.Function;

import java.util.*;

public class ListUtils {

    public static <T> Optional<T> head(List<T> list) {
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    public static <T1, T2> List<T2> map(List<T1> source, Function<T1, T2> f) {
        if (source.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList<T2> result =  new ArrayList<T2>(source.size());
        for (T1 aSource : source) {
            result.add(f.fun(aSource));
        }
        return result;
    }

    @SafeVarargs
    public static <T> List<T> flatten(List<List<T>>... deeps) {
        List<T> result = new LinkedList<>();
        for (List<List<T>> deep : deeps) {
            for(List<T> list : deep) {
                result.addAll(list);
            }
        }
        return result;
    }

    public static <T1,T2> T2 reduce(List<T1> list, Function2<T2, T1, T2> f, T2 seed) {
        T2 result = seed;
        for (T1 elem : list) {
            result = f.fun(result, elem);
        }
        return result;
    }

    public static <T extends Comparable<? super T>> List<T> unique(List<T> list) {
        if (list.size() < 2) {
            return list;
        }
        List<T> sorted = new LinkedList<T>(list);
        Collections.sort(sorted);
        T current = sorted.get(sorted.size() - 1);
        for (int i = sorted.size() - 1; i > 0; i--) {
            T previous = sorted.get(i - 1);
            if (current == null || current.compareTo(previous) == 0) {
                sorted.remove(i);
            }
            current = previous;
        }
        if (sorted.get(0) == null) {
            sorted.remove(0);
        }
        return sorted;
    }

    public static <T> T find(List<T> list, Function<T, Boolean> predicate) {
        for (T elem : list) {
            if (predicate.fun(elem)) {
                return elem;
            }
        }
        return null;
    }

    public static <T1,T2> List<Pair<T1,T2>> zip(List<T1> list1, List<T2> list2) {
        int size = Math.min(list1.size(), list2.size());
        ArrayList<Pair<T1,T2>> result =  new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(Pair.create(list1.get(i), list2.get(i)));
        }
        return result;
    }
}

