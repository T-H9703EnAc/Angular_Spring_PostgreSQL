import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonServiceService {

  constructor(private http: HttpClient) { }

  /**
   * 失敗したHttp操作を処理します。
   * アプリを持続させます。
   *
   * @param operation - 失敗した操作の名前
   * @param result - observableな結果として返す任意の値
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: リモート上のロギング基盤にエラーを送信する
      console.error(error); // かわりにconsoleに出力

      // 空の結果を返して、アプリを持続可能にする
      return of(result as T);
    };
  }
}