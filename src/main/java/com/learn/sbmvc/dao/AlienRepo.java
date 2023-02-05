package com.learn.sbmvc.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.sbmvc.model.Alien;

//@Repository
public interface AlienRepo extends JpaRepository<Alien, String>{

	// Query DSL...
	
//	List<Alien> getByAname(String aname);
	List<Alien> getByAnameOrderByAid(String aname); //Desc order
	
	// [findBy|getBy] + variableName(First-letter capital)
	
	// Implementation will be provided by spring-boot Jpa automatically

	Alien getByAid(int aid);
	
	
	// Query Annotation...
	// Its value attribute contains JPQL or SQL to execute
	
	@Query("from Alien where name = :name")
	List<Alien> find(@Param("name") String aname);
	
	// 1. JPQL
	// By default, query definition uses JPQL
	
	// 2. Native
	// nativeQuery attribute set to be true
	
	@Query(value = "SELECT * FROM Alien WHERE name = :name", nativeQuery = true)
	Collection<Alien> findNative(@Param("name") String aname);
	
	
	// Pagination...
	@Query(value = "SELECT * FROM Alien", countQuery = "SELECT count(*) FROM Alien", nativeQuery = true)
	Page<Alien> findAliensWithPagination(Pageable pageable);
	
	
	// Indexed query parameter...
	
	@Query(value = "SELECT * FROM Alien WHERE id = ?1 and name = ?2", nativeQuery = true)
	Collection<Alien> findAlienByIdAndName(Integer aid, String aname);
	
	@Query(value = "SELECT * FROM Alien WHERE name = ?1", nativeQuery = true)
	Collection<Alien> findAlienByName(String aname);
	
	
	// Collection parameter...
//	@Query(value = "from Alien a where a.name IN :names")
//	List<Alien> findUserByNameList(@Param("names") Collection<String> names);
	
	
	// Modifying...
	
	@Transactional
	@Modifying
	@Query(value = "update Alien set name = ? where id = ?", nativeQuery = true)
	int updateAlienSetNameForIdNative(String name, int id);
	
	 
}
