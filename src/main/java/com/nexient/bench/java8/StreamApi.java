package com.nexient.bench.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] arg) {
		//sum();
		sum2();
	}
	public static void externalIteration() {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		for(int i: values) {
			System.out.println(i);
		}
		
		Iterator<Integer> i = values.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public static void internalIteration() {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		//values.forEach(i -> System.out.println(i));
		values.forEach(System.out::println); //call by method reference
		
		/*
		Consumer<Integer> c = new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.println(i);
			}
		};
		*/
		Consumer<Integer> c = i -> System.out.println(i);
		values.forEach(c);
	}
	
	public static void sum() {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		int result = 0;
		for(int i: values) {
			result = result + i*2;
		}
		System.out.println(result);
		
		System.out.println(values.stream().map(i -> i*2).reduce(0,(c,e) -> c+e));
		
		//detail
		Function<Integer, Integer> f = new Function<Integer, Integer>() {
			public Integer apply(Integer t) {
				return t*2;
			}
		};
		Stream s = values.stream();
		values.stream().map(f).forEach(System.out::println);
		
		
		//Stream s1 = s.map(f);
		Stream<Integer> s1 = values.stream();
		Stream<Integer> s2 = s1.map(i -> i*2);
		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
			
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		//Integer result1 = (Integer)s2.reduce(0, b);
		Integer result1 = (Integer)s2.reduce(0, (i,j) -> i+j);
		System.out.println(result1);
	}
	
	public static void sum2() {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		System.out.println(values.stream()
				.filter(n -> n %2 == 0)
				.mapToInt(Integer::intValue)
				.sum()
				);
	}
}
