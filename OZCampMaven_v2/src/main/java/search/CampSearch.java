package search;

import java.util.ArrayList;


import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import com.dto.CampDTO;
import com.service.CampService;
import com.service.CampServiceImpl;


import page.*;

public class CampSearch {
	
   public static void search(List<CampDTO> resultList) {
	  CampService service = new CampServiceImpl();
	  
	  // 사용자 입력값 받아 조회
      Scanner input = new Scanner(System.in);
      String searchName;
      boolean find = false;

      Menu.spaceForNew();
      Menu.menuTitle("캠핑장 조회");
      System.out.println("                                     찾으시는 캠핑장 이름을 입력하세요. :)");
      while(true)
      {
    	  System.out.print("                                     ▶     ");
    	  searchName = input.nextLine();
    	  resultList = service.findByName(searchName);
    	  if (resultList.size() > 0)
    	  {
    		 find = true;    		  
    	  }
    	  
    	  // 조회한 캠핑장 출력
    	  if(find)
    	  {  
    		  System.out.println();
    		  System.out.println("                                  =================================");
    		  System.out.printf("                                        \"%s\" 을 포함하는 캠핑장\n", searchName);
    		  System.out.println("                                  =================================\n");

    		  int i=1;
	    	  for(CampDTO campground : resultList)
	    	  {
	    		  System.out.println("                                    " + i + ") "+campground.getName() + "\n"
	    		  +"                                       ▶ " + campground.getAddress() +"\n");
	    		  i++;
	    	  }
	    	  break;
    	  }
    	  else
    	  {
    		  // 일치하는 캠핑장이 하나도 없을 때 예외처리
    		  System.out.println("                                  일치하는 캠핑장이 없습니다. 다시 입력해주세요:) ");
    	  }
      }
      searchDetail(resultList);
    	   
   }
   
   
   
   // 조회 번호로 상세페이지 이동
   public static void searchDetail(List<CampDTO> resultList) {
		   
	   System.out.println("                                  =================================");
	   System.out.println("                                     원하시는 캠핑장 번호을 입력하세요. :)");
	   System.out.println("                                  =================================\n");
	   
	   Scanner input = new Scanner(System.in);
	   String searchNo;
	   int searchNum;
	   int searchDetail;
	   
	   while(true)
	   {
		   System.out.print("                                     ▶     ");
		   searchNo = input.nextLine();
		   searchNum = Integer.parseInt(searchNo);
		   if (searchNum > 0 && searchNum <= resultList.size())
		   {
			   // 상세 페이지로 이동
			   searchDetail = resultList.get(searchNum-1).getCID();
			   // cid 로 디테일 페이지 이동 로직
			   
			   
			   
			   
			   
			   
			   //
			   // test 용
			   System.out.println("디테일 페이지");
			   //
			   break;
		   }        	  
		   else
		   {
			   // 일치하는 번호가 없을 때 예외처리
			   System.out.println("                                  일치하는 번호가 없습니다. 다시 입력해주세요:) ");
		   }
		   
	   }
   }
   
}
