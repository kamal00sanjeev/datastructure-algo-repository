package com.ds.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetOps<T> {

	public void insertItem(Set<T> set, T item) {
		set.add(item);
	}

	public int getSetSize(Set<T> set) {
		return set.size();
	}

	public Set<T> unionSet(Set<T> s1, Set<T> s2) {
		Set<T> union = new LinkedHashSet<>(s1);
		union.addAll(s2);
		return union;
	}

	public Set<T> intersectionSet(Set<T> s1, Set<T> s2) {
		Set<T> intersection = new LinkedHashSet<>(s1);
		intersection.retainAll(s2);
		return intersection;
	}

	public Set<T> differenceSet(Set<T> s1, Set<T> s2) {
		Set<T> difference = new LinkedHashSet<>(s1);
		difference.removeAll(s2);
		return difference;
	}
	
	public Set<T> symmetricDifference(Set<T> s1, Set<T> s2){
		Set<T> union = unionSet(s1, s2);
		Set<T> intersection = intersectionSet(s1, s2);
		return differenceSet(union, intersection);
	}

}
