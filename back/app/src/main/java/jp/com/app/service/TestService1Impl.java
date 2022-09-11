package jp.com.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.app.dto.TestRequestDto1;
import jp.com.app.dto.TestResponseDto1;
import jp.com.app.entity.TestRequestEntity1;
import jp.com.app.entity.TestResponseEntity1;
import jp.com.app.mapper.TestMapper1;

@Service
public class TestService1Impl implements TestService1{
    @Autowired
    TestMapper1 testMapper1;

    /**
     * ユーザデータ取得
     * @param requestDto 検索条件
     * @return 画面設定データ
     */
    @Override
    public List<TestResponseDto1> getUserData(TestRequestDto1 requestDto) {

        TestRequestEntity1 requestEntity = dtoTranseformToEntity(requestDto);

        List<TestResponseEntity1> responseEntityList = testMapper1.selectUsers(requestEntity);
        
        return entityTransformDto(responseEntityList);
    }

    /**
     * ユーザデータ追加
     * @param requestDto 追加ユーザ情報
     */
    @Override
    public void addUserData(TestRequestDto1 requestDto) {
        testMapper1.insertUsers(dtoTranseformToEntity(requestDto));
    }

    /**
     * ユーザデータ更新
     * @param requestDto 更新ユーザ情報
     */
    @Override
    public void updateUserData(TestRequestDto1 requestDto) {
        testMapper1.updatetUsers(dtoTranseformToEntity(requestDto));        
    }

    /**
     * ユーザデータ削除
     * @param requestDto 削除ユーザ情報
     */
    @Override
    public void deleteUserData(TestRequestDto1 requestDto) {
        testMapper1.deleteUsers(dtoTranseformToEntity(requestDto));
        
    }

    /**
     * dtoをentityへ変換
     * @param dto
     * @return entity
     */
    private TestRequestEntity1 dtoTranseformToEntity(TestRequestDto1 requestDto){
        TestRequestEntity1 requestEntity = new TestRequestEntity1();
        requestEntity.setId(Integer.parseInt(requestDto.getId()));
        requestEntity.setName(requestDto.getName());
        return requestEntity;
    }

    /**
     * entityをdtoへ変換
     * @param entity
     * @return dto
     */
    private List<TestResponseDto1> entityTransformDto(List<TestResponseEntity1> responseEntityList){
        List<TestResponseDto1> responseDtoList = new LinkedList<TestResponseDto1>();
        for(TestResponseEntity1 responseEntity :responseEntityList){
            TestResponseDto1 responseDto = new  TestResponseDto1();
            responseDto.setId(responseEntity.getId().toString());
            responseDto.setName(responseEntity.getName());
            responseDtoList.add(responseDto);
        }
        return responseDtoList;
    }
}
