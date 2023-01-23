package com.nexient.bench.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.nexient.bench.dom.Customer;
import com.nexient.bench.dom.Gender;

public class StreamApiCustomer {
	static List<Customer> customers = new ArrayList<>();
	public static void main(String[] arg) {
		initData();
		//search by Using interface
		List<Customer> result = searchCustomers(customer -> customer.getGender().equals(Gender.Female)
				&& customer.getAge() > 30);
		result.stream().forEach(System.out::println);
		
		//Stream
		//연산의 연결(method chaining)을 통해 pipeline 구성하여 다양한 연산을 조합
		//연산처리는 스트림객체의 생성부터 중간연산 그리고 최종연산단계로 구분
		//ex:Filter -> Sort -> Map -> Collect
		List<String> ids = customers.stream()
							.filter(customer -> customer.getGender().equals(Gender.Female) && customer.getAge() > 30)
							.sorted()
							.map(Customer::getId)
							.collect(Collectors.toList());
		ids.stream().forEach(System.out::println);
		
		customers.stream().filter(c -> c.getAge() > 30).forEach(System.out::println);
		System.out.println();
		customers.stream().filter(c -> c.getAge() > 30).distinct().forEach(System.out::println);
		System.out.println();
		//sorted by age
		customers.stream().filter(c -> c.getAge() > 30).
		sorted(Comparator.comparing(Customer::getAge)).forEach(System.out::println);
		
		System.out.println();
		Customer cus = customers.stream().filter(c -> c.getAge() > 30).findFirst().orElse(null);
		System.out.println(cus);
	}
	static void initData() {
		customers.add(new Customer("KIM", "SEOUL", Gender.Female, 30));
		customers.add(new Customer("KIM", "BUSAN", Gender.Male, 50));
		customers.add(new Customer("LEE", "SEOUL", Gender.Female, 20));
		customers.add(new Customer("LEE", "INCHON", Gender.Male, 33));
		customers.add(new Customer("KIM", "SEOUL", Gender.Female, 54));
		customers.add(new Customer("PARK", "BUSAN", Gender.Male, 19));
		customers.add(new Customer("CHOI", "MASAN", Gender.Female, 46));
		customers.add(new Customer("KIM", "SEOUL", Gender.Male, 25));
		customers.add(new Customer("KANG", "ILSAN", Gender.Female, 70));
	}
	//search by Using interface
	public static List<Customer> searchCustomers(SearchFilter filter){
		List<Customer> list = new ArrayList<>();
		for(Customer customer: customers) {
			if(filter.isMatched(customer)) {
				list.add(customer);
			}
		}
		return list;
	}
}
