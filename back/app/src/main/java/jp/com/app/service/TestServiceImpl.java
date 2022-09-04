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
public class TestServiceImpl implements TestService1{
    @Autowired
    TestMapper1 testMapper1;

    @Override
    public List<TestResponseDto1> getUserData(TestRequestDto1 requestDto) {

        TestRequestEntity1 requestEntity = dtoTranseformToEntity(requestDto);

        List<TestResponseEntity1> responseEntityList = testMapper1.selectUsers(requestEntity);
        
        return entityTransformDto(responseEntityList);
    }

    @Override
    public void addUserData(TestRequestDto1 requestDto) {
        testMapper1.insertUsers(dtoTranseformToEntity(requestDto));
    }

    @Override
    public void updateUserData(TestRequestDto1 requestDto) {
        testMapper1.updatetUsers(dtoTranseformToEntity(requestDto));        
    }

    @Override
    public void deleteUserData(TestRequestDto1 requestDto) {
        testMapper1.deleteUsers(dtoTranseformToEntity(requestDto));
        
    }

    private TestRequestEntity1 dtoTranseformToEntity(TestRequestDto1 requestDto){
        TestRequestEntity1 requestEntity = new TestRequestEntity1();
        requestEntity.setId(Integer.parseInt(requestDto.getId()));
        requestEntity.setName(requestDto.getName());
        return requestEntity;
    }

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
