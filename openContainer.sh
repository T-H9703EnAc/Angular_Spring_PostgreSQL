echo 'db --> 1 /back --> 2 / front --> 3'
echo -n 開きたいコンテナを選択してください:
read SELECTCONTAINER
if [ $SELECTCONTAINER -eq 1 ]; then
    echo [postgres]コンテナを開きます。
    echo PostgresSQLへの接続コマンドは以下のコマンドを実行してください
    echo psql -U test -d test
    sudo docker exec -it db /bin/bash
elif [ $SELECTCONTAINER -eq 2 ]; then
    echo [back]コンテナを開きます。
    echo JavaとGradleのVersion確認コマンドは以下を実行してください
    echo java --version
    echo gradle -v
    sudo docker exec -it back /bin/bash
elif [ $SELECTCONTAINER -eq 3 ]; then
    echo [front]コンテナを開きます。
    echo Node.jsのVersion確認コマンドは以下を実行してください。
    echo node -v
    sudo docker exec -it front /bin/bash
else
    echo 範囲外値が入力されました。
    echo 再度シェルを実行してください。
fi
