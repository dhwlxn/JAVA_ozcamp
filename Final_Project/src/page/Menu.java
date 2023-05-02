package page;
import search.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.*;

public class Menu {
	
	// 메인화면 로고
	public static void mainPrint() {
		
		System.out.println("                                                                               \r\n"
				+ "                                                                                        \r\n"
				+ "       ☾ ⋆*･ﾟ:⋆*･ﾟ:⠀ *⋆.*:･ﾟ .: ⋆*･ﾟ: .⋆☾ ⋆*･ﾟ:⋆*･ﾟ:⠀ *⋆.*:･ﾟ .: ⋆*･ﾟ: .⋆☾ ⋆*･ﾟ:⋆*･ﾟ:⠀ *⋆.*:･ﾟ .: ⋆*･ﾟ: .⋆  \r\n"
				+ "                                                                                        \r\n"
				+ "                     ██████╗ ███████╗     ██████╗ █████╗ ███╗   ███╗██████╗     ██╗     \r\n"
				+ "                    ██╔═══██╗╚══███╔╝    ██╔════╝██╔══██╗████╗ ████║██╔══██╗    ██║     \r\n"
				+ "                    ██║   ██║  ███╔╝     ██║     ███████║██╔████╔██║██████╔╝    ██║     \r\n"
				+ "                    ██║   ██║ ███╔╝      ██║     ██╔══██║██║╚██╔╝██║██╔═══╝     ╚═╝     \r\n"
				+ "                    ╚██████╔╝███████╗    ╚██████╗██║  ██║██║ ╚═╝ ██║██║         ██╗     \r\n"
				+ "                     ╚═════╝ ╚══════╝     ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝         ╚═╝     \r\n"
				+ "      ▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀ \r\n"						
				+ "     \r\n"			
				+ "                                                                                             \r\n"
				+ "                                              @@@@@@@@@%////@@                               \r\n"
				+ "                                         @@*******@@////////////@                            \r\n"
				+ "                                      @@*************@@///////////@&                         \r\n"
				+ "                                    @#*****************%@///////////@,                       \r\n"
				+ "                                  &@*********************@&///////////@                      \r\n"
				+ "                                 @*************************@///////////@                     \r\n"
				+ "                                @*********@@@@@&@@**********@///////////@                    \r\n"
				+ "                               @********@@@@@@&&&&&(*********@///////////@                   \r\n"
				+ "                              @********@@@@@&&&&&&&@**********@///////////@                  \r\n"
				+ "                             @*********@@&&&&&&&&&&&@**********@///////////@    @@@          \r\n"
				+ "                     @@@    @*********#@@@&&&&&&&&&&@***********@//////////@   @@@           \r\n"
				+ "                   # @@@, ,,@*********@&@&&&&&&&&&%&@***********@*/@@@@@/*,,, ,    #         \r\n"
				+ "                      @@,@/  ,,,,,**/////////////(/(((///////////@@@@@,,,,                   \r\n"
				+ "                                                                     #@@    					    ");
		}
	
	
	// 메뉴 타이틀 
	public static void menuTitle(String menuName) {
		System.out.println("                                                                                ");
		System.out.println("                                    ╭╼|════════════════════|╾╮                  ");
		System.out.println("                                              "+ menuName + "                           ");
		System.out.println("                                    ╰╼|════════════════════|╾╯                  ");
		System.out.println("                                                                                ");
	}
	
	
	
	// 게스트 로그인/회원가입 메뉴
	public static void guestMenu() {
		
		// 사용자 입력받기
		Scanner input = new Scanner(System.in);
		String menuInput;
		do {
			System.out.println("                                     sign in(0) | sign up(1)");
			System.out.print("                                     ▶          ");
			menuInput = input.nextLine();		
		}while(!menuInput.equals("0") && !menuInput.equals("1") );
		
		// 로그인/회원가입 분기처리
		if (menuInput.equals("0"))
		{
			// 로그인 페이지
			
		}
		else if(menuInput.equals("1"))
		{
			// 회원가입 페이지
		}
		
	}
	
	// 사용자 메뉴
	public static void userMenu() {
<<<<<<< HEAD
		
		menuTitle("# menu");
		System.out.println("                                          # 1. 캠핑장 검색");
		System.out.println("                                          # 2. 캠핑장 추천");
		System.out.println("                                          # 3. 마이 페이지");
		
=======

>>>>>>> a9b95bd31529ce8f872b4cfce5e7ee552fbe49e4
		// 사용자 입력받기
		Scanner input = new Scanner(System.in);
		String menuInput;
		do {
			System.out.println("                                          # 1. 캠핑장 검색");
			System.out.println("                                          # 2. 캠핑장 추천");
			System.out.println("                                          # 3. 마이페이지");
			System.out.print("                                     ▶          ");
			menuInput = input.nextLine();		
		}while(!menuInput.equals("1") && !menuInput.equals("2") && !menuInput.equals("3") );
				
		// 메뉴선택 분기처리
		switch (Integer.parseInt(menuInput))
		{
			case 1:
			{
				// 캠핑장 검색 페이지
				CampSearch.search();
			}
			case 2:
			{
				// 캠핑장 추천 페이지
				CampRecommend.tag();
			}
			case 3:
			{
				// 마이페이지
			}
		}
<<<<<<< HEAD

		
=======
	}
		
	
>>>>>>> a9b95bd31529ce8f872b4cfce5e7ee552fbe49e4
//	
//		CampRecommend.thema();
//	    
//	    
<<<<<<< HEAD
=======


	// 새로운 메뉴를 위한 공백
	public static void spaceForNew() {
	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

>>>>>>> a9b95bd31529ce8f872b4cfce5e7ee552fbe49e4
	}
	
}