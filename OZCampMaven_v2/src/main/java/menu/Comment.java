package menu;

import com.dto.CommentDTO;
import com.service.CommentService;
import com.service.CommentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Comment extends Board {

	Scanner scan = new Scanner(System.in);
	
	@Override
	public void insert(int CUID, int CID) {

		System.out.println("                                     댓글 내용을 입력해주세요 :)");
        
		// 댓글 글자 수 제한?
		String reply = scan.next();
		CommentService service = new CommentServiceImpl();
		int RID = service.maxvalue()+1;
		
		CommentDTO dto = new CommentDTO(CUID, CID, RID, reply);
		int n = service.insert(dto);
		System.out.println("                                     댓글 등록이 완료되었습니다 :)");
		
//		this.findfindByCamp(CID);
		
	} // insert end
	@Override
	public List findAll(int CUID) {
		CommentService service = new CommentServiceImpl();
		List<CommentDTO> list = service.findAll(CUID);
		//출력문 UI 수정 필요
		System.out.println("                               ╭╼|══════════════════════════════|╾╮                  ");
		int n = 0;
		for (CommentDTO commentDTO : list) {
			n += 1;
			System.out.println("                                     "+n+") "+commentDTO.getName());
			System.out.println("                                         ┗ "+commentDTO.getReply());
		}
		System.out.println("                               ╰╼|══════════════════════════════|╾╯                  ");
		
		return list;
	} // findAll end

	public void findByCamp(int CID) {
		CommentService service = new CommentServiceImpl();
		List<CommentDTO> list = service.findByCamp(CID);
		//출력문 UI 수정 필요
		for (CommentDTO commentDTO : list) {
			System.out.println(commentDTO);
		}
	} // findByCamp end
	
	@Override
	public void delete(int CUID) {
		CommentService service = new CommentServiceImpl();
		List<CommentDTO> list = service.findAll(CUID);
		int CID=0;
		int RID=0;
		int answer;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("                                     삭제할 댓글 번호를 입력해주세요 :)");
		System.out.print("                                     ▶          ");
		answer = scan.nextInt();
		try{
		CID = (list.get(answer-1)).getCAMP_CID();
		RID = (list.get(answer-1)).getRID();
		
		}catch(IndexOutOfBoundsException e){
			System.out.println("                                     해당 번호의 댓글이 존재하지 않습니다 :(\n");
		}
		}while(answer>list.size());
		
		CommentDTO dto = new CommentDTO(CUID, CID, RID);
		int n = service.delete(dto);	
		System.out.println("                                     댓글 삭제가 완료되었습니다 :)");
		this.findAll(CUID);
	}// delete end
	
	public void update(int CUID) {
		CommentService service = new CommentServiceImpl();
		List<CommentDTO> list = service.findAll(CUID);
		int CID=0;
		int RID=0;
		int answer;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("                                     수정할 댓글 번호를 입력해주세요 :)");
		System.out.print("                                     ▶          ");
		answer = scan.nextInt();
		try {
		
			CID = (list.get(answer-1)).getCAMP_CID();
			RID = (list.get(answer-1)).getRID();
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("                                     해당 번호의 댓글이 존재하지 않습니다 :(\n");
		}
		}while(answer>list.size());
		System.out.println("                                     댓글 내용을 입력해주세요 :)");
		System.out.print("                                     ▶          ");
		String reply = scan.next();
		
		CommentDTO dto = new CommentDTO(CUID, CID, RID, reply);
		int n = service.update(dto);	
		System.out.println("                                     댓글 수정이 완료되었습니다 :)");
		
		this.findAll(CUID);
		
	}// delete end
	
	
	
	
	
}
