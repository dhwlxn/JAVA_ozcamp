package menu;

import com.dto.CampDTO;
import com.service.CampService;
import com.service.CampServiceImpl;

import java.util.Scanner;

public class Camp {
	
	static Scanner scan = new Scanner(System.in);
	int CID;
	
	public void printDetailByCID(int CID) {
		
		CampService service = new CampServiceImpl();
		CampDTO dto = service.printDetailByCID(CID);
		
		//출력문 UI 수정 필요!!!!!!!!!
		//출력문 UI 수정 필요!!!!!!!!!!!!!!
		System.out.println(dto);
		
	}
	
	
}
