package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.UserDTO;
import com.service.UserService;
import com.service.UserServiceImpl;

public class User {
	static Scanner scan = new Scanner(System.in);
	int CUID;	
	
	
	public void register() {
        
        // 예외처리 추가 필요
        /*
         * 1. 아이디 중복 검사
         * 2. if possible, 비밀번호 암호화
         */
		System.out.print("아이디를 입력하세요. ");
        String ID = scan.next();
        System.out.print("비밀번호를 입력하세요. ");
        String PW = scan.next();
        System.out.print("비밀번호를 한 번 더 입력하세요. ");
        String confirmPW = scan.next();
        
        if (!PW.equals(confirmPW)) {
        	System.out.println("비밀번호가 일치하지 않습니다.");
            
            } else {
            	UserService service = new UserServiceImpl();
            	List<UserDTO> list = service.findAll();
            	CUID = list.size() + 1; 
            	
            	UserDTO dto = new UserDTO(CUID, ID, PW);
            	int n = 0;
				//try {
					n = service.register(dto);
					
				//
				System.out.println(n+"개 등록 완료");	
				//} catch (DuplicatedIDException e) {
				//	System.out.println(e.getMessage());
				//}
                System.out.println("회원가입이 완료되었습니다.");
            }
        } // register end
	
	
	public int login() {
		String PW = null;
		String DB_PW = null;
		CUID = 0;
		do {
			System.out.print("아이디를 입력하세요. ");
	        String ID = scan.next();
	        System.out.print("비밀번호를 입력하세요. ");
	        PW = scan.next();
	        UserService service = new UserServiceImpl();
	        UserDTO dto = new UserDTO(CUID, ID, PW);
	        DB_PW = service.logIn(dto);
	       
	        
	        if(PW.equals(DB_PW)) {
	        	
	        	CUID = service.getCUID(dto);
				break;
			}
			else {
				System.out.println("비밀번호가 일치하지 않습니다");
			}
		}while(!PW.equals(DB_PW));
		
		
		System.out.println("메뉴 진입");
		
		return CUID;
	} // login end
	

	
//	public void user_delete(int CUID) {
//
//		System.out.println("정말로 탈퇴하시겠습니까?ㅠㅠ (y/n)");
//		String answer = scan.next();
//		
//		if(answer.toUpperCase().equals("Y")) {
//			
//		}
//	}
	
	
 }
	
	

