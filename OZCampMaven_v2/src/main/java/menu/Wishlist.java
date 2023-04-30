package menu;

import java.util.List;
import java.util.Scanner;

import com.dto.WishlistDTO;
import com.service.WishlistService;
import com.service.WishlistServiceImpl;

public class Wishlist extends Board {

	@Override
	public void insert(int CUID, int CID) {

		WishlistService service = new WishlistServiceImpl() ;
		WishlistDTO dto = new WishlistDTO(CUID, CID);
		int n = service.insert(dto);	
		System.out.println("내 위시리스트에 담겼습니다. :)");	
		
	} // insert end




	@Override
	public void delete(int CUID, int CID) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("위시리스트에서 삭제하시겠습니까? (y/n)");
		String answer = scan.next();
		if(answer.equalsIgnoreCase("Y")) {
			WishlistService service = new WishlistServiceImpl() ;
			WishlistDTO dto = new WishlistDTO(CUID, CID);
			int n = service.delete(dto);	
//			System.out.println(n+"개가 위시리스트에서 삭제되었습니다.");
		}
		
	} // delete end

	
	
	public void deleteAll(int CUID) {

		WishlistService service = new WishlistServiceImpl() ;
		int n = service.deleteAll(CUID);

		
		} // deleteAll end
	
	
	
	@Override
	public void findAll(int CUID) {

		WishlistService service = new WishlistServiceImpl() ;
		List<WishlistDTO> list = service.findAll(CUID);
		
		for (WishlistDTO wishlistDTO : list) {
			System.out.println(wishlistDTO);
		}
		
	} // findAll end

}
