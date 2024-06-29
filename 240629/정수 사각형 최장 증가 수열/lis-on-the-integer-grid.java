import java.util.Scanner;

public class Main {
    // n: 행렬의 크기
    // grid: 주어진 n x n 행렬
    // dp: 각 위치에서 시작했을 때 방문할 수 있는 최대 칸 수를 저장하는 배열
    // dx, dy: 상하좌우로 이동하기 위한 방향 배열
    public static int n;
    public static int[][] grid;
    public static int[][] dp;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬 크기 입력 받기
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];

        // 행렬 값 입력 받기 및 dp 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                dp[i][j] = -1; // 방문하지 않은 상태를 -1로 초기화
            }
        }

        int maxPath = 0;
        // 모든 셀을 시작점으로 하여 최대 경로 길이를 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(i, j));
            }
        }

        // 결과 출력
        System.out.println(maxPath);
    }

    // dfs: 깊이 우선 탐색을 통해 (x, y)에서 시작하여 방문할 수 있는 최대 칸 수를 계산
    public static int dfs(int x, int y) {
        // 이미 방문한 셀은 메모이제이션된 값을 반환
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 1; // 현재 위치 포함해서 초기값 1로 설정

        // 상하좌우로 이동하면서 조건에 맞는 경우에만 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 이동할 위치가 격자 범위 내에 있고, 현재 위치보다 값이 큰 경우에만 이동
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] > grid[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(nx, ny));
            }
        }

        return dp[x][y]; // 최종 계산된 값을 반환
    }
}