/*
- motivation의 속성(id, regDate, content, author)을 고려하여 클래스를 구현한다.
- 등록, 목록, 상세보기, 삭제, 수정의 기능을 구현한다
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new App(sc).run();

        sc.close();

    }
}