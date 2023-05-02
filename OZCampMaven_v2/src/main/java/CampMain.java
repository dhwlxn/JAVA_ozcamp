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
		Menu.guestMenu();

		Menu.userMenu(resultList);
		// 아직 유저가 없어 검색 테스용
		CampSearch.search(resultList);
//		// 추천 테스트용
//		CampRecommend.thema();
//		CampRecommend.tag();
		
		

	}


}