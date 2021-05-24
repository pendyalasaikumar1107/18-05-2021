package com.tcs.profile_evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.profile_evaluation.entity.Profilestatus;

public interface StatusRepo extends JpaRepository<Profilestatus, Integer> {

}
