package jp.com.app.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import jp.com.app.dto.TestRequestDto1;
import jp.com.app.dto.TestResponseDto1;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestService1Test {
    @Autowired
    TestService1 service;

    @Test
    public void 動作確認_検索()throws Exception{
        TestRequestDto1 requestDto = new TestRequestDto1();
        requestDto.setId("1");
        requestDto.setName("Tarou");
        service.addUserData(requestDto);
        List<TestResponseDto1> res = service.getUserData(requestDto);
        System.out.println(res);
    }

    @Test
    public void 動作確認_追加()throws Exception{
        TestRequestDto1 requestDto = new TestRequestDto1();
        requestDto.setId("2");
        requestDto.setName("Jirou");
        service.addUserData(requestDto);
        List<TestResponseDto1> res = service.getUserData(requestDto);
        System.out.println(res);
    }

    @Test
    public void 動作確認_更新()throws Exception{
        TestRequestDto1 requestDto = new TestRequestDto1();
        requestDto.setId("3");
        requestDto.setName("Sabu");
        service.addUserData(requestDto);
        requestDto.setName("Saburou");
        service.updateUserData(requestDto);
        List<TestResponseDto1> res = service.getUserData(requestDto);
        System.out.println(res);
    }

    @Test
    public void 動作確認_削除()throws Exception{
        TestRequestDto1 requestDto = new TestRequestDto1();
        requestDto.setId("4");
        requestDto.setName("Sirou");
        service.addUserData(requestDto);
        service.deleteUserData(requestDto);
        List<TestResponseDto1> res = service.getUserData(requestDto);
        System.out.println(res);
    }
}
