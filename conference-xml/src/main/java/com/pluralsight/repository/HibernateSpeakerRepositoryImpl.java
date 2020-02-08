package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Speaker;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
	
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.SpeakerRepository#findAll()
	 */
	public List<Speaker> findAll(){
		List<Speaker> speakers = new ArrayList<Speaker>();
		
		Speaker speaker = new Speaker();
		speaker.setFirstName("Bryan");
		speaker.setLastName("Hansen");
		
		speakers.add(speaker);
		
		return speakers;
	}
	
}
