package net.codejava.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query(value = " select c from Customer c where c.name LIKE '%' || :keyword || '%'" + 
					" OR c.id LIKE '%' || :keyword || '%'"+ 
			       " OR c.email LIKE '%' || :keyword || '%'"+ 
			        " OR c.address LIKE '%' || :keyword || '%'")
	public List<Customer> search(@Param("keyword") String keyword);//keyword decleared in index.jsp
}
