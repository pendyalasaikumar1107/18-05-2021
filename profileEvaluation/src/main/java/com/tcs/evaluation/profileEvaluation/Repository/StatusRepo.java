package com.tcs.evaluation.profileEvaluation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tcs.evaluation.profileEvaluation.Entity.Profilestatus;

public interface StatusRepo extends JpaRepository<Profilestatus, Integer> {

}
