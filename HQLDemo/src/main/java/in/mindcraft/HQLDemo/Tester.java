package in.mindcraft.HQLDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/*
 * write a menu driven program to perform Crud Operations on mobile phone objects using hibernate HQL
 */

public class Tester {

	public static void main(String[] args) {
		
//		MobilePhone m1= new MobilePhone(101,"samsung",20000);
//		MobilePhone m2= new MobilePhone(102,"redmi",20050);
//		MobilePhone m3= new MobilePhone(103,"iphone",54000);
//		MobilePhone m4= new MobilePhone(104,"xoxo",25000);	
//		Configuration con = new Configuration().configure();
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//		SessionFactory sf = con.buildSessionFactory(reg);
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();		
//		MobilePhone m = (MobilePhone)session.get(MobilePhone.class, 102); // to fetch particular id from table
//		System.out.println("Details of moblie "+m);	
//		Query query  = session.createQuery("from MobilePhone m  where m.cost >22000 ");
//		List<MobilePhone> mlist = query.list();
//		for(MobilePhone m:mlist)
//			System.out.println(m);		
//		Query q=session.createQuery("update MobilePhone m set make=:m where mid=:i");  
//		q.setParameter("m","google");  
//		q.setParameter("i",102);  
//		int update=q.executeUpdate();  
//		System.out.println(update);
		
		Scanner scanner = new Scanner(System.in);

		MobilePhone mp = new MobilePhone();

		Configuration con=new Configuration().configure();
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session session=sf.openSession();

		Transaction tx=session.beginTransaction();

		while (true) {
		System.out.println("\nSelect:");
		System.out.println("1. Add Mobile Phone");
		System.out.println("2. Display Mobile Phone");
		System.out.println("3. Update Mobile Phone");
		System.out.println("4. Delete Mobile Phone");
		System.out.println("5. Exit Menu");
		System.out.print("Enter your choice: ");
		int Choice = scanner.nextInt();

		switch (Choice) {
		case 1:
		System.out.print("Enter mobile phone ID: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.print("Enter mobile phone name: ");
		String brand = scanner.nextLine();

		System.out.print("Enter mobile phone price: ");
		double price = scanner.nextDouble();

		// Create an instance of MobilePhone with user input
		MobilePhone m1 = new MobilePhone(id, brand, price);
		session.save(m1);

		tx.commit();

		break;
		case 2:
		Query query=session.createQuery("from MobilePhone");
		List<MobilePhone> mlist=query.list(); //using query obj call list method
		for(MobilePhone m:mlist)
		System.out.println(m);
		tx.commit();

		break;
		case 3:
		System.out.println("Enter details to be updated");
		System.out.print("Enter mobile phone ID: ");
		int mid = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.print("Enter mobile phone name: ");
		String name = scanner.nextLine();

		System.out.print("Enter mobile phone price: ");
		double cost = scanner.nextDouble();

		// Create an instance of MobilePhone with user input
		MobilePhone mo = new MobilePhone(mid, name, cost);
		session.update(mo);

		tx.commit();

		break;
		default:
		System.out.println("Invalid option.");
		break;
		}

		//scanner.close();




		}

				
	}

}
