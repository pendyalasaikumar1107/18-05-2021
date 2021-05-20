package com.tcs.evaluation.profileEvaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.evaluation.profileEvaluation.entity.Profilestatus;

public interface StatusRepo extends JpaRepository<Profilestatus, Integer> {

}
