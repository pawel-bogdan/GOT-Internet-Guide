package com.github.pawelbogdan.internetowy_przewodnik_got.model.repositories;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.EmployeePTTK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePTTKRepo extends JpaRepository<EmployeePTTK, String> {
}
