package Prematric.PrematricProject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Prematric_base;
import Pages.Dashboard;
import Pages.Personal_Info;
import Pages.School_Profile;
import Pages.Student_Profile;

public class Student_Profile_Test extends Prematric_base {
	Prematric_base cc;
	School_Profile sp;
	Student_Profile stp;
	Dashboard da;
	TestLoginPages lp;
	Personal_Info pi;
	@BeforeClass

	public void setUp() throws Exception {
		da = new Dashboard();
		sp = new School_Profile();
		cc = new Prematric_base();
		stp = new Student_Profile();
		pi= new Personal_Info();
		initlization_logIn();
		Thread.sleep(3000);
		lp = new TestLoginPages();
	}

	@Test	
	public void filldata1() throws Exception {
		
		sp = new School_Profile();
		sp.filldata();
		stp = new Student_Profile();
		stp.stud();
		pi=new Personal_Info();
		pi.person_info();
		
		/*
		 * sp1 = new Student_Profile(); sp1.filldata1();
		 */
	}

}
