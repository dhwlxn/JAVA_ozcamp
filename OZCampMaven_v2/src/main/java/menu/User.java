package menu;

import com.dto.UserDTO;
import com.service.UserService;
import com.service.UserServiceImpl;
import page.Menu;

import java.util.Scanner;

public class User {
    static Scanner scan = new Scanner(System.in);
    static int CUID;


    public void register() {

        int IdCheck;
        String ID;
        String PW;
        String confirmPW;
        UserService service = new UserServiceImpl();

        Menu.menuTitle("# sign up");

        // ID 입력 받고 중복검사
        do {
            System.out.print("                                          ID : ");
            ID = scan.next();
            IdCheck = service.isIdDuplicated(ID);
            if (IdCheck == 1) {
                System.out.println("                                      이미 존재하는 ID입니다. :(");
            } else {
                break;
            }

        } while (IdCheck == 1);

        // PASSWORD 체크
        do {
            System.out.print("                                    PASSWORD : ");
            PW = scan.next();
            System.out.print("                              PASSWORD CHECK : ");
            confirmPW = scan.next();

            if (!PW.equals(confirmPW)) {
                System.out.println("                                        비밀번호가 일치하지 않습니다. :(");
            }
        } while (!PW.equals(confirmPW));


        int max;
        try {
            max = service.maxvalue();
        } catch (NullPointerException e) {
            max = 0;
        }
        CUID = max + 1;
        UserDTO dto = new UserDTO(getCUID(), ID, PW);
        int n = 0;
        n = service.register(dto);
        System.out.println();
        System.out.println("                                       회원가입이 완료되었습니다. :)");
        //} catch (DuplicatedIDException e) {
        //	System.out.println(e.getMessage());
        //}

    } // register end


    public int login() {
        String PW = null;
        String DB_PW = null;
        CUID = 0;
        boolean verify = false;
        Menu.menuTitle("# sign in");
        do {
            System.out.print("                                          ID : ");
            String ID = scan.next();
            System.out.print("                                    PASSWORD : ");
            PW = scan.next();
            UserService service = new UserServiceImpl();
            UserDTO dto = new UserDTO(getCUID(), ID, PW);
            DB_PW = service.logIn(dto);

            try {
                CUID = service.getCUID(dto); // 추가
            } catch (NullPointerException e) {
                System.out.println();
                System.out.println("                                    존재하지 않는 ID입니다.");
                continue;
            }


            if (PW.equals(DB_PW)) {
                verify =true;
            } else {
                System.out.println("                                    비밀번호가 일치하지 않습니다.");
            }


        } while (!verify);



        return getCUID();
    } // login end


    public void user_delete(int CUID) {

        Menu.menuTitle("# 탈퇴");
        String answer;
        do {
            System.out.println("                                      정말로 탈퇴하시겠습니까? (y/n)");
            System.out.print("                                     ▶          ");
            answer = scan.next();

            if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("                                 잘못된 입력입니다. Y 또는 N을 입력해주세요.");
                System.out.println();
            }
        }while(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));

        if(answer.equalsIgnoreCase("Y")) {

            Wishlist wl = new Wishlist();
            wl.deleteAll(CUID);

            UserService service = new UserServiceImpl();
            int n = service.delete(CUID);
        }
        else {
            Menu.myPage();
        }
        System.out.println();
        System.out.println("                                         탈퇴가 완료되었습니다.");
        System.out.println("                                      그동안 이용해주셔서 감사합니다.");
        System.exit(0);
    }

    public static int getCUID() {
        return CUID;
    }


}



