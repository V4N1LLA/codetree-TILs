import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N 입력 받기
        int N = scanner.nextInt();
        
        // 행렬 입력 받기
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // dp 배열 생성 및 초기화
        int[][] dp = new int[N][N];
        dp[0][0] = matrix[0][0];

        // 첫 번째 행 초기화
        for (int j = 1; j < N; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // 첫 번째 열 초기화
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // 나머지 dp 테이블 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        // 결과 출력
        System.out.println(dp[N - 1][N - 1]);
    }
}