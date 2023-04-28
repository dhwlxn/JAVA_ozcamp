import java.util.List;
import java.util.Scanner;

import com.service.campServiceImpl;
import com.service.userServiceImpl;

import com.dto.CampDTO;
import com.dto.UserDTO;
import com.service.campService;
import com.service.userService;
import com.Exception.DuplicatedCampnoException;
import com.Exception.DuplicatedUsernoException;
import com.Exception.RecordNotFoundException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. 회원가입");
			System.out.println("2. 부서저장");
			System.out.println("3. 부서수정");
			System.out.println("4. 부서삭제");
			System.out.println("0. 종료");
			System.out.println("----------------");

			String num = scan.next();
			
			if("1".equals(num)) {
				System.out.println("아이디를 입력하세오");	//저장 시 중복에 대한 예외처리
				String ID = scan.next();
				System.out.println("비밀번호를 입력하세오");	//저장 시 중복에 대한 예외처리
				String PW = scan.next();
				
				UserDTO dto = new UserDTO(Integer.parseInt(deptno), dname, loc);
				
				deptService service = new deptServiceImpli();
				int n=0;
				try {
					n = service.insert(dto);
				} catch (DuplicatedDeptnoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println(n + "회원가입을 완료하였습니다.");
				//System.out.println(deptno+"\t"+dname+"\t"+loc);
				
				
			}else if ("2".equals(num)) {
				com.service.userService service = new userServiceImpli();
				List<com.dto.UsertDTO> list = service.findAll();
				System.out.println("부서번호\t부서이름\t부서위치");
				System.out.println("----------------");
				for(DeptDTO dto : list) {
					System.out.println(dto);
				}		
				System.out.println();
				
				
			}else if ("3".equals(num)) {
				System.out.println("수정할 부서번호를 입력하시오");	//저장 시 중복에 대한 예외처리
				String deptno = scan.next();
				System.out.println("수정할 부서명를 입력하시오");	//저장 시 중복에 대한 예외처리
				String dname = scan.next();
				System.out.println("수정할 부서위치를 입력하시오");	//저장 시 중복에 대한 예외처리
				String loc = scan.next();
				
				DeptDTO dto = new DeptDTO(Integer.parseInt(deptno), dname, loc);
				
				deptService service = new deptServiceImpli();
				int n=0;
				try {
					n = service.update(dto);
				} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println(n + "개가 수정되었습니다.");
				
			}else if ("4".equals(num)) {
				int n=0;
				
				System.out.println("삭제할 부서번호를 입력하시오");	//저장 시 중복에 대한 예외처리
				int deptno = scan.nextInt();
							
				deptService service = new deptServiceImpli();
				//try {
				n = service.delete(deptno);
				//} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
				//	System.out.println(e.getMessage());
				//}
				System.out.println(n + "개가 삭제되었습니다.");
				
			}
			else{
				System.exit(0);
			}System.out.println("프로그램 종료");
		}
		}
}
