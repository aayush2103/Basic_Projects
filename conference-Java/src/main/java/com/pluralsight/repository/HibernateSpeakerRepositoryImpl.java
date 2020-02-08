package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Speaker;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
	
	@Autowired
	private Calendar cal;
	
	@Value("#{ T(java.lang.Math).random() *100 }")
	private double seedNum;
	
	public List<Speaker> findAll(){
		List<Speaker> speakers = new ArrayList<Speaker>();
		
		Speaker speaker = new Speaker();
		speaker.setFirstName("Bryan");
		speaker.setLastName("Hansen");
		speaker.setSeedNum(seedNum);
		
		System.out.println("cal : " + cal.getTime());
		
		speakers.add(speaker);
		
		return speakers;
	}
	
}
