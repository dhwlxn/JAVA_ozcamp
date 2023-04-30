package menu;

import java.util.Scanner;

import com.dto.WishlistDTO;
import com.service.WishlistService;
import com.service.WishlistServiceImpl;

public class Comment extends Board {

	@Override
	public void insert(int CUID, int CID) {
		// TODO Auto-generated method stub
		
	} // insert end

	@Override
	public void delete(int CUID, int CID) {
		Scanner scan = new Scanner(System.in);
		System.out.println("댓글을 삭제하시겠습니까? (y/n)");
		String answer = scan.next();
		if(answer.toUpperCase().equals("Y")) {
			WishlistService service = new WishlistServiceImpl() ;
			WishlistDTO dto = new WishlistDTO(CUID, CID);
			int n = service.delete(dto);	
//			System.out.println(n+"개가 위시리스트에서 삭제되었습니다.");
		}
		
	} // delete end


	@Override
	public void findAll(int CUID) {
		// TODO Auto-generated method stub
		
	} // findAll end
	
	
	public void findByCamp(int CID) {
		
	} // findMine end
	

}
