package com.ds.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOpsTest {

	public static void main(String[] args) {
		
		SetOps<Integer> so = new SetOps<>();
		Set<Integer> s1 = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7, 6));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 3, 4, 5, 7,9,10));
		
		System.out.println("UNION: "+so.unionSet(s1, s2));
		System.out.println("INTERSECTION: "+so.intersectionSet(s1, s2));
		System.out.println("DIFFERENCE: "+so.differenceSet(s1, s2));
		System.out.println("SYMMETRIC DIFFERENCE: "+so.symmetricDifference(s1, s2));
	}
}
