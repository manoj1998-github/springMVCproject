package net.codejava.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

	@Autowired
	protected CustomerRepository repository;
	
	public List<Customer> listAll()
	{
		return (List<Customer>) repository.findAll();
	}
	
	public void save(Customer customer)
	{
		repository.save(customer);
	}
	
	public Optional<Customer> editid(long id)
	{
		return repository.findById(id);
	}
	
	public void deleteid(long id)
	{
		 repository.deleteById(id);
	}
	
	public List<Customer> search(String keyword)
	{
		return repository.search(keyword);
	}
	
}
