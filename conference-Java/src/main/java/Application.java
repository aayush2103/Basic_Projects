import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pluralsight.service.SpeakerService;

public class Application {
	
	public static void main(String[] args) {
		//when below line is run, it will call the configuration file and create a 
		//registry with the beans present in that file.
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//SpeakerService service = new SpeakerServiceImpl();
		SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
		/*System.out.println(service);
		SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
		System.out.println(service2);*/
		
		System.out.println(service.findAll().get(0).getFirstName());
		System.out.println(service.findAll().get(0).getSeedNum());
	}
	
}
