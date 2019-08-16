import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrossWord {
public static void main(String args[]) {
Scanner scan = new Scanner(System.in);

char puzzle[][] = new char[6][7];
for (int i = 0; i < 6; i++) {
for (int j = 0; j < 7; j++) {
puzzle[i][j] = scan.next().charAt(0);
}
}
displayPuzzle(puzzle);
int[][] n = getNumbered(puzzle);

for (int i = 0; i < n.length; i++) {
for (int j = 0; j < n[i].length; j++) {

System.out.print(n[i][j] + " ");

}
System.out.println();
}
System.out.println("Across");
List<String> a = getWordsAcross(puzzle, getNumbered(puzzle));
for (String s : a) {
System.out.println(s);
}
System.out.println("Down");
getWordTopToDown(puzzle, getNumbered(puzzle));
List<String> b = getWordTopToDown(puzzle, getNumbered(puzzle));
for (String s1 : b) {
System.out.println(s1);
}

}

public static void displayPuzzle(char[][] puzzle) {

for (int i = 0; i < puzzle.length; i++) {
for (int j = 0; j < puzzle[i].length; j++) {
System.out.print(puzzle[i][j]);
}
System.out.println();

}

}

public static int[][] getNumbered(char[][] puzzle) {
int count = 0;
int[][] numCross = new int[6][7];

for (int i = 0; i < puzzle.length; i++) {
for (int j = 0; j < puzzle[i].length; j++) {
if (puzzle[i][j] != '*' && (i == 0 || j == 0)) {
numCross[i][j] = ++count;

} else if (i != 0 && j != 0 && puzzle[i][j] != '*'
&& (puzzle[i - 1][j] == '*' || puzzle[i][j - 1] == '*')) {
numCross[i][j] = ++count;
}

}
}
return numCross;
}

public static List<String> getWordsAcross(char[][] puzzle, int[][] getNumbered) {
List<String> across = new ArrayList<String>();
String s = "";
String str = "";
int count = 0;
for (int i = 0; i < puzzle.length; i++) {
for (int j = 0; j < puzzle[i].length; j++) {
if (getNumbered[i][j] != 0) {
count = getNumbered[i][j];
while (j < puzzle[i].length && puzzle[i][j] != '*') {
s = s + puzzle[i][j];
j++;
}
str = count + " " + s;
across.add(str);
s = "";
}
}
}
return across;
}

public static List<String> getWordTopToDown(char[][] puzzle, int[][] getNumbered) {

List<String> down = new ArrayList<String>();

String s = "";
String str = "";
int count = 0;
for (int i = 0; i < puzzle.length; i++) {
for (int j = 0; j < puzzle[i].length; j++) {
if (getNumbered[i][j] != 0) {
count = getNumbered[i][j];
int row = i;
while (row < puzzle.length && puzzle[row][j] != '*') {
s = s + puzzle[row][j];
getNumbered[row][j] = 0;
row++;
}
str = count + " " + s;
down.add(str);
s = "";
}
}
}
return down;

}

}