//package com.pl.repository;
//
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//
//@Repository
//public interface TokenRepository extends JpaRepository <T, Long> {
//	T findByToken(String token);
//
//	@Modifying
//	void deletePreviousTo(Date date);
//
//	@Modifying
//	@Query("delete from ForgotPasswordToken t where t.expirationDate <= ?1") //*HQL
//	void deletePreviousTo(Date date);
//}