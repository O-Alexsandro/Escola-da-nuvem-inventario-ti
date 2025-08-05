package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
