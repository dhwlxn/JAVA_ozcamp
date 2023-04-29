package search;

import java.util.List;
import java.util.Scanner;

import com.dto.CampDTO;
import com.dto.LocationDTO;
import com.service.CampService;
import com.service.CampServiceImpl;
import com.service.LocationService;
import com.service.LocationServiceImpl;
import page.*;


public class CampRecommend{
	
	public static void campChoice() {
		CampService service = new CampServiceImpl();
		List<CampDTO> resultList;
//		CampDTO options= ;
		
//		resultList = service.findByRecommendation(options);
	}
	
	
	
	// 출발지 입력
	public static void location() {
		Menu.spaceForNew();
		Menu.menuTitle("캠핑장 추천");
		LocationService service = new LocationServiceImpl();
		List<LocationDTO> locaList;
		String startLoc;
		String gu;
		String dong;
		
		Scanner input = new Scanner(System.in);
		System.out.println("                                     출발지를 입력해주세요.");
		
		//예외처리 아직 안 함 //////////////////////////////////////
		System.out.print("                                     ▶  구 (ex. 강남구) : ");
		gu = input.nextLine();
		System.out.print("                                     ▶  동 (ex. 양재동) : ");
		dong = input.nextLine();
		
		
		/// 모르겟음 파라미터 타입의 dto로 어떻게 변환하는지
//		startLoc = service.findByDistrict(gu, dong);
	}
	
	
	
	
	// 반경 선택 후 최대, 최소 위경도 계산
	public static void district(double startLat, double startLong) {
		// 리턴은 어떻게??????
		
		
		
		
		String selectDistrict;
		String maxLat;
		String minLat;
		String maxLong;
		String minLong;
		int districtNum;
		
		Scanner input = new Scanner(System.in);
		System.out.println("                                     원하는 캠핑장의 거리를 선택해주세요.");
		do {
			System.out.println("                                [   50km / 100km / 150km   ]");
			System.out.print("                                     ▶   ");
			selectDistrict = input.nextLine();
			districtNum = Integer.parseInt(selectDistrict);
			
			if (districtNum != 50 && districtNum != 100 && districtNum != 150) {
				System.out.println("                                     잘못된 입력입니다. 다시 입력해주세요.");
			}
			
		}while(districtNum != 50 && districtNum != 100 && districtNum != 150);
		
		if(districtNum == 50) 
		{
			// 출발 위도에서 반경 50km 계산
			// maxLat = startLat + 
			// minLat = startLat -
			// maxLong = startLong +
			// minLong = startLong +
			
		}
		else if(districtNum == 100) {}
		else if(districtNum == 150) {}
	}
	
	
	
	// 환경 선택
	public static int thema() {
		String answer;
		int optionEnv = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("                                     원하시는 환경을 골라주세요 :)");
		
		do {
			System.out.println("                              [   강 / 계곡 / 산 / 숲 / 바다 / 도심 / 호수  ]");
			System.out.print("                                     ▶   ");
			answer = input.nextLine();
			
			if (!answer.equals("강") && !answer.equals("계곡")
					&& !answer.equals("산") && !answer.equals("숲")
					&& !answer.equals("바다") && !answer.equals("도심")
					&& !answer.equals("호수")) {
				System.out.println("                                     잘못된 입력입니다. 다시 입력해주세요.");
			}
			
		}while(!answer.equals("강") && !answer.equals("계곡")
				&& !answer.equals("산") && !answer.equals("숲")
				&& !answer.equals("바다") && !answer.equals("도심")
				&& !answer.equals("호수"));
		
		if(answer.equals("강")) optionEnv = 1;
		else if(answer.equals("계곡")) optionEnv = 2;
		else if(answer.equals("산")) optionEnv = 3;
		else if(answer.equals("숲")) optionEnv = 4;
		else if(answer.equals("바다")) optionEnv = 5;
		else if(answer.equals("도심")) optionEnv = 6;
		else if(answer.equals("호수")) optionEnv = 7;
		
		return optionEnv;
		
	}
	
	
	
	
	
	// tag(물놀이, 놀이터, 전기, wifi)
	public static void tag() {
		
	
		System.out.println("                                     원하시는 캠핑장의 태그를 선택해주세요:)  ");
		
		CampRecommend myoption = new CampRecommend();
		int optionSwim = myoption.optionCheck("물놀이");
		int optionPlay = myoption.optionCheck("놀이터");
		int optionElec = myoption.optionCheck("전기");
		int optionWifi = myoption.optionCheck("wifi ");
		
		System.out.println(optionSwim + optionPlay + optionElec + optionWifi);
		System.out.println(optionSwim + optionPlay + optionElec + optionWifi);
		System.out.println();

		
	}
	
	
	
	
	// 옵션 선택 반복 로직 Y/N
	public int optionCheck(String option)
	{
		Scanner input = new Scanner(System.in);
		String answer;
		int choice = 0;
		
		do {
			System.out.print("                                     ▶  #Tag. " + String.format("%-4s",option) +  " (Y/N) : ");	
			answer = input.nextLine();
			
			if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
				System.out.println("                                     잘못된 입력입니다. Y 또는 N을 입력해주세요.");
			}
			
		}while(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
		
		if(answer.equalsIgnoreCase("y"))
		{
			choice = 1;
		}
		
		return choice;
	}
	
}
