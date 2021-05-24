package com.tcs.profile_evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.profile_evaluation.entity.Evaluator;

public interface EvaluatorRepo extends JpaRepository<Evaluator, Integer>{

}
