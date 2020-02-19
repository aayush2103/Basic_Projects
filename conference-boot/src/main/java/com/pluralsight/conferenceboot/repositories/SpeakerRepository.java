package com.pluralsight.conferenceboot.repositories;

import com.pluralsight.conferenceboot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
