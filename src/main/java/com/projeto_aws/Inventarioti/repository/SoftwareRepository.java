package com.projeto_aws.Inventarioti.repository;

import com.projeto_aws.Inventarioti.domain.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareRepository extends JpaRepository<Software, Long> {
}
