package page;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.dao.CommentDAO;
import com.dto.CommentDTO;
import com.service.CommentService;
import com.service.CommentServiceImpl;

class DeleteTest {
    static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "com/mybatis/Configuration.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void delete() {
        CommentService service = new CommentServiceImpl();
        int CUID = 1;
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

        assertEquals(1, n);

    }



}