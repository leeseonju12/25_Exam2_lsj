import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("==명언 앱 종료==");
                break;
            }
            else if (cmd.length() == 0) {
                System.out.println("명령어를 입력해주세요.");
                continue;
            }

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String body = sc.nextLine();
                System.out.print("작가 : ");
                String writer = sc.nextLine();

                // 현재 날짜/시간
                LocalDateTime now = LocalDateTime.now();
                // 포맷팅
                String formatedNow = now.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));

                Motivation motivation = new Motivation(lastId, body, writer, formatedNow);
                motivations.add(motivation);

                System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);
                lastId++;

            }

            else if (cmd.equals("목록")){
                System.out.println("========================================");
                System.out.println("번호     /     작가     /     명언");
                for (int i = motivations.size() - 1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);
                    System.out.printf("%d     /     %s     /     %s\n", motivation.getId(), motivation.getWriter(), motivation.getBody());
                }
            }

            else if (cmd.startsWith("수정")){
                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 2) {
                    System.out.println("수정할 목록 번호를 입력하세요.");
                    continue;
                }

                int id = Integer.parseInt(cmdBits[1]);
                Motivation found = findById(motivations, id);

                if (found == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다\n", id);
                    continue;
                }


                System.out.println("명언(기존) :" + found.getBody());
                System.out.println("작가(기존) :" + found.getWriter());

                System.out.print("명언 : ");
                String newbody = sc.nextLine();
                System.out.print("작가 : ");
                String newwriter = sc.nextLine();

                // 현재 날짜/시간
                LocalDateTime now = LocalDateTime.now();
                // 포맷팅
                String newformatedNow = now.format(DateTimeFormatter.ofPattern("수정시간: yy-MM-dd HH:mm:ss"));

                found.setFormatedNow(newformatedNow);
                found.setBody(newbody);
                found.setWriter(newwriter);

                System.out.printf("%d번 명언이 수정되었습니다.\n", id);

            }

            else if (cmd.startsWith("상세보기")){
                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 2) {
                    System.out.println("상세보기할 목록 번호를 입력하세요.");
                    continue;
                }
                int id = Integer.parseInt(cmdBits[1]);
                Motivation found = findById(motivations, id);

                if (found == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다\n", id);
                    continue;
                }

                System.out.println("번호 : " + id);
                System.out.println("날짜 : " + found.getFormatedNow());
                System.out.println("작가 : " + found.getWriter());
                System.out.println("내용 : " + found.getBody());

            }

            else if (cmd.startsWith("삭제")){
                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 2) {
                    System.out.println("삭제할 목록 번호를 입력하세요.");
                    continue;
                }

                int id = Integer.parseInt(cmdBits[1]);
                Motivation found = findById(motivations, id);

                if (found == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다\n", id);
                    continue;
                }

                motivations.remove(found);

                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

            }
        }
    }



    private Motivation findById(ArrayList<Motivation> motivations, int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }
}




class Motivation {
    private int id;
    private String body;
    private String writer;
    private  String formatedNow;

    public Motivation(int id, String body, String writer, String formatedNow) {
        this.id = id;
        this.body = body;
        this.writer = writer;
        this.formatedNow = formatedNow;
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

    public String getFormatedNow() {
        return formatedNow;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setFormatedNow(String formatedNow) {
        this.formatedNow = formatedNow;
    }
}

