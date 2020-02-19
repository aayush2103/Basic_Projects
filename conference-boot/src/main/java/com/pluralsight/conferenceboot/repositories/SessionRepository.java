package com.pluralsight.conferenceboot.repositories;

import com.pluralsight.conferenceboot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
