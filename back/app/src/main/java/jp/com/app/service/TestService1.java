package jp.com.app.service;

import java.util.List;

import jp.com.app.dto.TestRequestDto1;
import jp.com.app.dto.TestResponseDto1;

public interface TestService1 {
    /**
     * ユーザデータ取得
     * @param requestDto 検索条件
     * @return 画面設定データ
     */
    public List<TestResponseDto1> getUserData(TestRequestDto1 requestDto);

    /**
     * ユーザデータ追加
     * @param requestDto 追加ユーザ情報
     */
    public void addUserData(TestRequestDto1 requestDto);

        /**
     * ユーザデータ更新
     * @param requestDto 更新ユーザ情報
     */
    public void updateUserData(TestRequestDto1 requestDto);

    /**
     * ユーザデータ削除
     * @param requestDto 削除ユーザ情報
     */
    public void deleteUserData(TestRequestDto1 requestDto);

    
}
