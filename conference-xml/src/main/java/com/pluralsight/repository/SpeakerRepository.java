package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Speaker;

public interface SpeakerRepository {

	List<Speaker> findAll();

}