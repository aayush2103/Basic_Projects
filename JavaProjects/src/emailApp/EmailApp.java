package emailApp;

public class EmailApp {

	public static void main(String[] args) {
		Email em1 = new Email("Aayush", "Kumar");
		
		em1.setAlternateEmail("abc.info.com");
		System.out.println(em1.getAlternateEmail());

		em1.setMailboxCapacity(300);
		System.out.println(em1.getMailboxCapacity());
		
		em1.setPassword("AK123$#KUM");
		
		em1.showInfo();
	}

}
