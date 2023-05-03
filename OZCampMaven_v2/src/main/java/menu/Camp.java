package menu;

import com.dto.CampDTO;
import com.dto.CommentDTO;
import com.service.CampService;
import com.service.CampServiceImpl;

import page.Menu;

import java.util.List;
import java.util.Scanner;

public class Camp {

	static Scanner scan = new Scanner(System.in);
	int CID;
	int CUID = User.getCUID();
	public void printDetailByCID(int CID) {

		CampService service = new CampServiceImpl();
		CampDTO dto = service.printDetailByCID(CID);

		checkOption(dto);

		Comment comment = new Comment();
		comment.findByCamp(CID);
		Wishlist wishlist = new Wishlist();
		System.out.println("                             → '댓글'을 추가하시려면 '1'을 입력해주세요.");
		System.out.println("                             → '위시리스트'에 추가하시려면 '2'을 입력해주세요.");
		System.out.println("                             → '메인 메뉴'로 돌아가시려면 '0'을 입력해주세요!\n");
		Scanner scan = new Scanner(System.in);

		String searchNo;
		int searchNum;
		int searchDetail;

		while(true)
		{
			System.out.print("                                     ▶     ");
			searchNo = scan.nextLine();
			searchNum = Integer.parseInt(searchNo);
			if(searchNum == 0)
			{
//			   List<CampDTO> listdto = null;
				Menu.userMenu(null);
			}
			if(searchNum == 1) {
				comment.insert(CUID, CID);
				this.printDetailByCID(CID);
			}

			if(searchNum ==2)
			{
				wishlist.insert(CUID, CID);

			}
		}

	}

	public void checkOption(CampDTO dto) {

		String env = null;
		switch(dto.getEnvironment()) {
			case 1:
				env = "강";
				break;
			case 2:
				env = "계곡";
				break;
			case 3:
				env = "산";
				break;
			case 4:
				env = "숲";
				break;
			case 5:
				env = "바다";
				break;
			case 6:
				env = "도심";
				break;
			case 7:
				env = "호수";
				break;

		}

		Menu.menuTitle("상세 조회");
		System.out.println("                     "+dto.getName());
		System.out.println("                  ╭╼|════════════════════════════════════════════════════════|╾╮                  ");
//		System.out.println("                     기본 정보");
		System.out.println("                     # 주소 : "+dto.getAddress());
		System.out.println("                     # 캠핑장 키워드");
		System.out.println("                       ▶ 테마 : "+env);
		if(dto.getFeatures() !=null) {
			System.out.println("                       ▶ 편의 시설 : ");
			System.out.println("                          "+dto.getFeatures());
		}
		System.out.println("                     # 부대 시설");

		System.out.print("                        ");

		System.out.print("| ");
		if(dto.getCommon_site() == 1) {
			System.out.print("일반야영장 | ");
		}
		if(dto.getGlamping_site() == 1) {
			System.out.print("글램핑장 | ");
		}
		if(dto.getAuto_site() == 1) {
			System.out.print("자동차 캠핑 가능 | ");
		}
		if(dto.getCaravan_site() == 1) {
			System.out.print("카라반 보유 | ");
		}
		if(dto.getCommon_site()+dto.getAuto_site()+dto.getCaravan_site()+dto.getGlamping_site() == 0) {
			System.out.println("등록된 야영장 정보 없음 |");
		}

		System.out.println();
		System.out.print("                        ");
		System.out.print("| ");
		if(dto.getWifi() == 1) {
			System.out.print("인터넷 | ");
		}
		if(dto.getElectricity() == 1) {
			System.out.print("전기 | ");
		}
		if(dto.getPlayground() == 1) {
			System.out.print("놀이터 | ");
		}
		if(dto.getWater_pool() == 1) {
			System.out.print("물놀이장 | ");
		}
		if(dto.getWifi()+dto.getWater_pool()+dto.getElectricity()+dto.getPlayground() == 0) {
			System.out.println("등록된 부대시설 정보 없음 |");
		}
		System.out.println();
		System.out.println("                  ╰╼|════════════════════════════════════════════════════════|╾╯                  ");



	}

}
