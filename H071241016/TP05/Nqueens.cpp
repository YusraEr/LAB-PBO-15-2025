#include <iostream>
using namespace std;

const int N = 4;
int board[N][N];

bool isSafe(int row, int col) {
    // Cek kolom atas
    for (int i = 0; i < row; i++)
        if (board[i][col]) return false;

    // Cek diagonal kiri atas
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j]) return false;

    // Cek diagonal kanan atas
    for (int i = row, j = col; i >= 0 && j < N; i--, j++)
        if (board[i][j]) return false;

    return true;
}

bool solve(int row) {
    if (row == N) {
        // Cetak papan
        cout << "Solusi:\n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                cout << (board[i][j] ? "Q " : ". ");
            cout << endl;
        }
        return true;
    }

    for (int col = 0; col < N; col++) {
        if (isSafe(row, col)) {
            board[row][col] = 1; // Tempatkan ratu
            if (solve(row + 1)) return true; // lanjut
            board[row][col] = 0; // backtrack
        }
    }

    return false;
}

int main() {
    // Inisialisasi papan
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            board[i][j] = 0;

    if (!solve(0))
        cout << "Tidak ada solusi ditemukan.\n";

    return 0;
}
