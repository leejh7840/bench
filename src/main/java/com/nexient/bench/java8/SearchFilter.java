package com.nexient.bench.java8;

import com.nexient.bench.dom.Customer;

public interface SearchFilter {
	boolean isMatched(Customer customer);
}
