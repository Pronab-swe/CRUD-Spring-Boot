package com.example.postDe.postDemo2.Repository;

import com.example.postDe.postDemo2.Domain.nuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nuserRepository extends JpaRepository<nuser,String> {
}
