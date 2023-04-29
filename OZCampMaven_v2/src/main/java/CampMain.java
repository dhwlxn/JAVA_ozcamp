import com.dto.CampDTO;
import com.service.CampServiceImpl;
import search.*;
import page.*;
import java.util.Scanner;
import java.util.List;

public class CampMain {

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		System.out.println("캠핑장 이름 입력 : ");
//		String search_test = scan.next();
//
//		CampServiceImpl campService = new CampServiceImpl();
//		List<CampDTO> camp_search = campService.findByName(search_test);
//		for (CampDTO camp_info :
//				camp_search) {
//			System.out.println(camp_info.getCID() + " "+ camp_info.getName() + " "+ camp_info.getAddress());
//		}
		// 테스트용으로 출력만, 활용할 때 CID를 ArrayList로 add 해서 해당 CID들로 목록을 출력한다던지 해야 함

		
		// 메인화면 출력		
		Menu.mainPrint();
		Menu.menuTitle("start !");
		Menu.guestMenu();
		
		// 아직 유저가 없어 검색 테스용
		CampSearch.search();
		// 추천 테스트용
		CampRecommend.location();
		CampRecommend.thema();
		CampRecommend.tag();
		
		

	}


}