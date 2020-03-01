import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SudokuMain {
	public static void main(String[] args) throws InterruptedException {
		int[][] a = new int[9][9];
		int[][] a1 = new int[9][9];
		int[][] a2 = new int[9][9];
		int si = 0;
		int sj = 0;
		int changes = 0;
		boolean whileflag = true;
		boolean completeflag = false;
		List<int[][]> currentInput = new ArrayList<int[][]>();
		List<Integer> tobeChange = new ArrayList<Integer>();
		List<Integer> pos = new ArrayList<Integer>();

		int assume = 0;
		boolean flag = false;
		long loop = 0;
		int sum1 = 0;
		int sum2 = 0;
		boolean val = false;

		System.out.println("Enter the 9x9 matrix ");
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				a[i][j] = in.nextInt();
		
		long startTime = System.nanoTime();

		do {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					for (assume = 1; assume <= 9; assume++) {
						flag = false;
						if (a[i][j] == 0) {
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;

							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a1[i][j] = Integer.parseInt(a1[i][j] + ""
										+ assume);
						}
					}
				}
			}
			// for (int i = 0; i < 9; i++) {
			// for (int j = 0; j < 9; j++)
			// System.out.print(a1[i][j] + "\t");
			// System.out.println();
			// }
			// System.out.println("next loop");
			changes = 0;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++) {
					if ((a1[i][j] > 0) && (a1[i][j] < 10)) {
						a[i][j] = a1[i][j];
						changes += a1[i][j];
					}
					a2[i][j] = a1[i][j];
					a1[i][j] = 0;
				}
			int sum = 0;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					sum += a2[i][j];
			whileflag = false;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					if (a[i][j] == 0) {
						whileflag = true;
						break;
					}
			loop++;
			if (loop % 10000000 == 0)
				System.out.println("No of loops taken in crore : " + loop/10000000);
			completeflag = true;
			if (changes == 0) {
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++) {
						if (a2[i][j] < 100 && a2[i][j] > 10) {
							flag = false;
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;
							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a[i][j] = a2[i][j] / 10;
							int[][] b = new int[9][9];
							for (int x = 0; x < 9; x++)
								for (int y = 0; y < 9; y++)
									b[x][y] = a[x][y];
							currentInput.add(b);
							tobeChange.add(a2[i][j] % 10);
							pos.add((i * 10) + j);
						} else if (a2[i][j] < 1000 && a2[i][j] > 100) {
							flag = false;
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;

							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a[i][j] = a2[i][j] / 100;
							int[][] b = new int[9][9];
							for (int x = 0; x < 9; x++)
								for (int y = 0; y < 9; y++)
									b[x][y] = a[x][y];
							currentInput.add(b);
							currentInput.add(b);
							tobeChange.add(a2[i][j] % 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100) / 10);
							pos.add((i * 10) + j);
						} else if (a2[i][j] < 10000 && a2[i][j] > 1000) {
							flag = false;
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;

							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a[i][j] = a2[i][j] / 1000;
							int[][] b = new int[9][9];
							for (int x = 0; x < 9; x++)
								for (int y = 0; y < 9; y++)
									b[x][y] = a[x][y];
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							tobeChange.add(a2[i][j] % 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100) / 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 1000) / 100);
							pos.add((i * 10) + j);
						} else if (a2[i][j] < 100000 && a2[i][j] > 10000) {
							flag = false;
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;

							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a[i][j] = a2[i][j] / 10000;
							int[][] b = new int[9][9];
							for (int x = 0; x < 9; x++)
								for (int y = 0; y < 9; y++)
									b[x][y] = a[x][y];
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							tobeChange.add(a2[i][j] % 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100) / 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 1000) / 100);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 10000) / 1000);
							pos.add((i * 10) + j);
						} else if (a2[i][j] < 1000000 && a2[i][j] > 100000) {
							flag = false;
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;

							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a[i][j] = a2[i][j] / 100000;
							int[][] b = new int[9][9];
							for (int x = 0; x < 9; x++)
								for (int y = 0; y < 9; y++)
									b[x][y] = a[x][y];
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							tobeChange.add(a2[i][j] % 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100) / 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 1000) / 100);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 10000) / 1000);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100000) / 1000);
							pos.add((i * 10) + j);
						} else if (a2[i][j] < 10000000 && a2[i][j] > 1000000) {
							flag = false;
							if (i < 3)
								si = 0;
							else if (i < 6)
								si = 3;
							else
								si = 6;
							if (j < 3)
								sj = 0;
							else if (j < 6)
								sj = 3;
							else
								sj = 6;

							for (int k = 0; k < 9; k++) {
								if (a[i][k] == assume) {
									flag = true;
									break;
								}
								if (a[k][j] == assume) {
									flag = true;
									break;
								}
							}

							for (int v = si; v < si + 3; v++)
								for (int u = sj; u < sj + 3; u++)
									if (a[v][u] == assume) {
										flag = true;
										break;
									}

							if (!flag)
								a[i][j] = a2[i][j] / 1000000;
							int[][] b = new int[9][9];
							for (int x = 0; x < 9; x++)
								for (int y = 0; y < 9; y++)
									b[x][y] = a[x][y];
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							currentInput.add(b);
							tobeChange.add(a2[i][j] % 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100) / 10);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 1000) / 100);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 10000) / 1000);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 100000) / 1000);
							pos.add((i * 10) + j);
							tobeChange.add((a2[i][j] % 1000000) / 10000);
							pos.add((i * 10) + j);
						}
						a2[i][j] = 0;
					}

			}
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					a2[i][j] = 0;
			
			// validate check --start
			val = true;
			if (!whileflag || sum == 0) {
				for (int i = 0; i < 9; i++) {
					sum1 = 0;
					sum2 = 0;
					for (int j = 0; j < 9; j++) {
						sum1 += a[i][j];
						sum2 += a[j][i];
					}
					// System.out.println(sum1 + " " + sum2);
					if (sum1 != 45 && sum2 != 45) {
						// System.out.println("Failed validation");
						val = false;
						break;
					}
				}
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						sum1 = 0;
						for (int i = (x * 3); i < (x * 3) + 3; i++) {
							for (int j = (y * 3); j < (y * 3) + 3; j++) {
								sum1 += a[i][j];
							}
						}
						// System.out.println(sum1);
						if (sum1 != 45) {
							// System.out.println("Failed Validation");
							val = false;
							break;
						}
					}
				}
			}

			int ai = 0;
			int aj = 0;
			if (!val) {
				whileflag = true;
				// System.out.println("\t------------>" + currentInput.size()
				// + " " + pos.size() + " " + tobeChange.size());
				if (currentInput.size() == 0)
					System.out.println("Stoped here");
				int[][] c = new int[9][9];
				c = currentInput.get(currentInput.size() - 1);
				for (int m = 0; m < 9; m++)
					for (int n = 0; n < 9; n++)
						a[m][n] = c[m][n];
				
				ai = pos.get(pos.size() - 1) / 10;
				aj = pos.get(pos.size() - 1) % 10;
				a[ai][aj] = tobeChange.get(tobeChange.size() - 1);
				if (currentInput.size() > 0)
					currentInput.remove(currentInput.size() - 1);
				if (tobeChange.size() > 0)
					tobeChange.remove(tobeChange.size() - 1);
				if (pos.size() > 0)
					pos.remove(pos.size() - 1);
			}
			// validation check --stop
			
			//print current state
			if (loop % 10000000 == 0)
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++)
						System.out.print(a[i][j] + "\t");
					System.out.println();
				}
			
		} while (whileflag && completeflag);

		long stopTime = System.nanoTime();
		long Time = stopTime - startTime;
		System.out.println("\n\nOUPTPUT:\n");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((j) % 3 == 0)
					System.out.print("  ");
				System.out.print(a[i][j] + " ");
			}
			if ((i + 1) % 3 == 0)
				System.out.println();
			System.out.println();
		}
		/*
		 * for (int i = 0; i < 9; i++) { for (int j = 0; j < 9; j++){
		 * System.out.print(a[i][j] + " "); } System.out.println(); }
		 */
		System.out.println("\nTime taken for execution : " + Time / 1000000000
				+ "." + Time / 1000000 + " Seconds");
		System.out.println("No of loops taken : " + loop);


	}
}
/*

output sample for every loop:

INPUT: EASY - 10
0 1 0 0 0 0 3 0 4
8 0 7 0 5 0 0 0 1
0 5 4 0 0 0 6 8 0
5 6 8 4 0 0 0 2 3
0 0 1 0 9 0 0 4 0
0 0 0 3 0 8 5 1 6
0 0 2 0 4 0 0 0 9
0 8 5 0 0 0 0 0 2
1 0 0 7 0 0 4 0 0

OUPTPUT:

  2 1 6   8 7 9   3 5 4 
  8 3 7   6 5 4   2 9 1 
  9 5 4   2 3 1   6 8 7 

  5 6 8   4 1 7   9 2 3 
  3 2 1   5 9 6   7 4 8 
  7 4 9   3 2 8   5 1 6 

  6 7 2   1 4 5   8 3 9 
  4 8 5   9 6 3   1 7 2 
  1 9 3   7 8 2   4 6 5 


Time taken for execution : 0.5 Seconds
No of loops taken : 10


INPUT: MEDIUM
9 2 0 6 1 0 0 0 0
4 6 0 0 0 3 0 0 0
0 1 0 7 0 0 9 0 6
0 5 0 0 7 8 2 0 0
6 7 2 0 0 0 5 8 0
0 0 0 2 0 6 0 0 3
0 9 6 3 2 0 0 1 4
7 0 0 0 0 0 6 0 0
0 0 1 0 6 4 0 9 0

OUPTPUT:

  9 2 7   6 1 5   3 4 8 
  4 6 5   9 8 3   1 2 7 
  8 1 3   7 4 2   9 5 6 

  3 5 4   1 7 8   2 6 9 
  6 7 2   4 3 9   5 8 1 
  1 8 9   2 5 6   4 7 3 

  5 9 6   3 2 7   8 1 4 
  7 4 8   5 9 1   6 3 2 
  2 3 1   8 6 4   7 9 5 


Time taken for execution : 0.112 Seconds
No of loops taken : 810


INPUT: HARD 
0 0 7 0 8 0 0 0 0
4 0 0 0 0 0 0 2 0
0 0 6 0 0 9 0 1 0
0 0 0 0 0 6 0 0 9
5 7 0 0 0 0 0 0 8
0 9 0 0 5 3 0 0 0
0 0 0 5 0 0 2 0 0
2 0 0 9 0 0 0 7 0
0 0 9 2 0 7 6 8 0

OUPTPUT:

  9 2 7   6 8 1   5 3 4 
  4 1 8   3 7 5   9 2 6 
  3 5 6   4 2 9   8 1 7 

  8 3 2   7 4 6   1 5 9 
  5 7 4   1 9 2   3 6 8 
  6 9 1   8 5 3   7 4 2 

  7 8 3   5 6 4   2 9 1 
  2 6 5   9 1 8   4 7 3 
  1 4 9   2 3 7   6 8 5 


Time taken for execution : 13.13410 Seconds
No of loops taken : 1227256

INPUT: HARD 
0 6 5 0 0 4 0 9 0
1 0 0 0 0 0 0 0 4
8 0 0 0 0 1 0 0 0
0 0 0 2 0 3 0 0 9
0 0 0 1 0 6 3 0 7
0 5 3 4 0 9 0 0 0
0 9 7 6 0 0 0 0 0
0 0 6 5 0 0 0 7 8
3 0 8 9 0 0 4 0 5

OUPTPUT:

  7 6 5   8 2 4   1 9 3 
  1 3 2   7 9 5   6 8 4 
  8 4 9   3 6 1   7 5 2 

  6 7 1   2 8 3   5 4 9 
  9 8 4   1 5 6   3 2 7 
  2 5 3   4 7 9   8 1 6 

  5 9 7   6 4 8   2 3 1 
  4 1 6   5 3 2   9 7 8 
  3 2 8   9 1 7   4 6 5 


Time taken for execution : 0.72 Seconds
No of loops taken : 900

INPUT: HARD --851
0 0 0 0 0 0 5 0 0
3 0 8 0 0 0 1 0 7
5 9 0 0 0 0 6 8 4
0 0 1 8 4 0 0 0 3
6 0 0 0 0 5 0 0 8
4 0 0 0 3 0 0 1 0
0 4 0 0 0 0 7 0 1
0 0 0 0 0 0 0 6 9
0 0 0 7 2 9 0 4 0

OUPTPUT:

  7 1 4   6 9 8   5 3 2 
  3 6 8   4 5 2   1 9 7 
  5 9 2   3 7 1   6 8 4 

  9 7 1   8 4 6   2 5 3 
  6 2 3   9 1 5   4 7 8 
  4 8 5   2 3 7   9 1 6 

  8 4 9   5 6 3   7 2 1 
  2 5 7   1 8 4   3 6 9 
  1 3 6   7 2 9   8 4 5 


Time taken for execution : 0.86 Seconds
No of loops taken : 851

INPUT: Extreme
0 5 0 0 0 4 0 0 0
0 0 0 0 0 3 0 0 8
7 0 0 0 0 0 9 0 0
0 3 0 0 9 1 0 0 0
0 0 0 7 0 0 0 3 6
0 0 2 0 0 0 8 0 0
6 0 8 0 0 0 4 0 3
0 0 0 0 2 0 0 6 0
0 0 0 0 6 7 0 0 0

OUPTPUT:

  8 5 9   6 1 4   3 2 7 
  2 1 4   9 7 3   6 5 8 
  7 6 3   2 8 5   9 1 4 

  5 3 6   8 9 1   7 4 2 
  9 8 1   7 4 2   5 3 6 
  4 7 2   5 3 6   8 9 1 

  6 2 8   1 5 9   4 7 3 
  3 9 7   4 2 8   1 6 5 
  1 4 5   3 6 7   2 8 9 


Time taken for execution : 313.313533 Seconds
No of loops taken : 33085068


INPUT: WORLDEST TOUGHTEST PUZZLE (from google)
8 0 0 0 0 0 0 0 0
0 0 3 6 0 0 0 0 0
0 7 0 0 9 0 2 0 0
0 5 0 0 0 7 0 0 0
0 0 0 0 4 5 7 0 0
0 0 0 1 0 0 0 3 0
0 0 1 0 0 0 0 6 8
0 0 8 5 0 0 0 1 0
0 9 0 0 0 0 4 0 0

OUPTPUT:

  8 1 2   7 5 3   6 4 9 
  9 4 3   6 8 2   1 7 5 
  6 7 5   4 9 1   2 8 3 

  1 5 4   2 3 7   8 9 6 
  3 6 9   8 4 5   7 2 1 
  2 8 7   1 6 9   5 3 4 

  5 2 1   9 7 4   3 6 8 
  4 3 8   5 2 6   9 1 7 
  7 9 6   3 1 8   4 5 2 


Time taken for execution : 123.123193 Seconds
No of loops taken : 18021288
*/