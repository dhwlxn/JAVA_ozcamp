import com.dto.CampDTO;
import com.service.CampServiceImpl;
import search.*;

import java.util.List;
import java.util.Scanner;

public class CampMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("캠핑장 이름 입력 : ");
		String search_test = scan.next();

		CampServiceImpl campService = new CampServiceImpl();
		List<CampDTO> camp_search = campService.findByName(search_test);
		for (CampDTO camp_info :
				camp_search) {
			System.out.println(camp_info.getCID() + " "+ camp_info.getName() + " "+ camp_info.getAddress());
		}
		// 테스트용으로 출력만, 활용할 때 CID를 ArrayList로 add 해서 해당 CID들로 목록을 출력한다던지 해야 함

//	CampSearch.search();
//		CampRecommend.thema();
//    CampRecommend.tag();
//    CampSearch.search();

	}


}
