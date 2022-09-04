package jp.com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.com.app.entity.TestRequestEntity1;
import jp.com.app.entity.TestResponseEntity1;

@Mapper
public interface TestMapper1 {
    public List<TestResponseEntity1> selectUsers(TestRequestEntity1 requestEntity);

    public void insertUsers(TestRequestEntity1 requestEntity);

    public void updatetUsers(TestRequestEntity1 requestEntity);

    public void deleteUsers(TestRequestEntity1 requestEntity);
}
