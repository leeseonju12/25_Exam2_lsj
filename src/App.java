import java.util.Scanner;
import java.util.ArrayList;

public class App {

    private static Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("==명언 앱 실행==");

        int lastId = 1;

        ArrayList<Motivation> motivations = new ArrayList<>();

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("==명언 앱 종료==");
                break;
            }

            if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String body = sc.nextLine();
                System.out.print("작가: ");
                String writer = sc.nextLine();

                Motivation motivation = new Motivation(lastId, body, writer);
                motivations.add(motivation);


                System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);
                lastId++;

            }

            else if (cmd.equals("목록")){
                System.out.println("========================================");
                System.out.printf("번호     /     작가     /     명언\n");
                for (int i = motivations.size() - 1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);
                    System.out.printf("%d     /     %s     /     %s\n", motivation.getId(), motivation.getWriter(), motivation.getBody());
                }
            }

            else if (cmd.startsWith("수정")){
                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 2) {}

            }

            else if (cmd.startsWith("상세보기")){

            }

            else if (cmd.startsWith("삭제")){

            }
        }
    }
}

class Motivation {
    private int id;
    private String body;
    private String writer;

    public Motivation(int id, String body, String writer) {
        this.id = id;
        this.body = body;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getWriter() {
        return writer;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}

