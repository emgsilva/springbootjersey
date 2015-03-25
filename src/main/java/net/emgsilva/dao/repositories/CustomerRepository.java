package net.emgsilva.dao.repositories;

import net.emgsilva.dao.models.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends
		PagingAndSortingRepository<Customer, Long> {

}