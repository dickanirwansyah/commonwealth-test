package id.dicka.testsegitiga;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TestSegitigaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSegitigaApplication.class, args);
	}
}

//3 menit

//@Component
//class TestSegitigaRataKanan implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//		for (int i=1;i<=5;i++){
//			for(int j=5;j>=i;j--){
//				System.out.print(" ");
//			}
//			for(int k=1;k<=i;k++){
//				System.out.print("#");
//			}
//			System.out.println();
//		}
//	}
//}