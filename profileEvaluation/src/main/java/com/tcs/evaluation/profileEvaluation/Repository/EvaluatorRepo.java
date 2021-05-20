package com.tcs.evaluation.profileEvaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.evaluation.profileEvaluation.entity.Evaluator;

public interface EvaluatorRepo extends JpaRepository<Evaluator, Integer>{

}
