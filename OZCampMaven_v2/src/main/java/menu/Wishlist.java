package menu;

import com.dto.CommentDTO;
import com.dto.WishlistDTO;
import com.service.WishlistService;
import com.service.WishlistServiceImpl;
import page.Menu;

import java.util.List;
import java.util.Scanner;

public class Wishlist extends Board {

	@Override
	public List findAll(int CUID) {

		WishlistService service = new WishlistServiceImpl() ;
		List<WishlistDTO> list = service.findAll(CUID);
    
		System.out.println();
		Menu.menuTitle("# 위시리스트");
		System.out.println("                  ╭╼|════════════════════════════════════════════════════════|╾╮                  ");
		int n = 0;
		for (WishlistDTO wishlistDTO : list) {
			n += 1;
			System.out.println("                      "+n+") "+wishlistDTO.getName());
			System.out.println("                          ┗ "+wishlistDTO.getAddress());
		}
		System.out.println("                  ╰╼|════════════════════════════════════════════════════════|╾╯                  ");
		return list;
	} // findAll end


	@Override
	public void insert(int CUID, int CID) {

		WishlistService service = new WishlistServiceImpl() ;
		WishlistDTO dto = new WishlistDTO(CUID, CID);
		boolean check = true;

		try{
			int n = service.insert(dto);
		} catch(org.apache.ibatis.exceptions.PersistenceException e){
			System.out.println();
			System.out.println("                                     이미 담긴 캠핑장입니다. :(");
			check = false;
		}

		if(check){
			System.out.println("                                     내 위시리스트에 담겼습니다. :)");}

	} // insert end


	@Override
	public void delete(int CUID) {

		int CID=0;
		int listindex;
		WishlistService service = new WishlistServiceImpl() ;
		List<WishlistDTO> list = service.findAll(CUID);

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("                                     삭제할 캠핑장 번호를 입력해주세요. :)");
			System.out.println("                                          # 돌아가기 (0)");
			System.out.print("                                     ▶          ");
			listindex = scan.nextInt();
			if(listindex == 0){
				Menu.myWishlist();
			}
			try{
				CID = (list.get(listindex-1)).getCAMP_CID();

			}catch(IndexOutOfBoundsException e){
				System.out.println("                                     해당 번호의 캠핑장이 존재하지 않습니다. :(\n");
			}
		}while(listindex>list.size());

		WishlistDTO dto = new WishlistDTO(CUID, CID);
		System.out.println("                                     정말 위시리스트에서 삭제하시겠습니까? (y/n)");
		System.out.print("                                     ▶          ");

		String answer = scan.next();
		if(answer.equalsIgnoreCase("Y")) {
			int n = service.delete(dto);
			System.out.println("                                     위시리스트에서 삭제되었습니다. :)");
			this.findAll(CUID);
		}

	} // delete end


	public void deleteAll(int CUID) {

		WishlistService service = new WishlistServiceImpl() ;
		int n = service.deleteAll(CUID);


	} // deleteAll end




}
