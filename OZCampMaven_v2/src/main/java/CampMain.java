import com.dto.CampDTO;


import com.service.CampServiceImpl;
import search.*;
import page.*;
import java.util.Scanner;
import java.util.List;



public class CampMain {

	public static void main(String[] args) {

		List<CampDTO> resultList = null;
		
		// 메인화면 출력		
		Menu.mainPrint();
		Menu.menuTitle("start !");
		Menu.guestMenu(resultList);
		

		

	}


}