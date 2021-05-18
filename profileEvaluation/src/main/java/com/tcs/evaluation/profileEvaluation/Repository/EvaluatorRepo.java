package com.tcs.evaluation.profileEvaluation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.evaluation.profileEvaluation.Entity.Evaluator;

public interface EvaluatorRepo extends JpaRepository<Evaluator, Integer>{

}
