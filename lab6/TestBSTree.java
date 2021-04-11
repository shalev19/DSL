package lab6;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestBSTree {

	public static void main(String[] args) throws IOException {

		BSTree tree = new BSTree();  //create new tree

		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);

		while(true) {
			if(tokens.nextToken() == StreamTokenizer.TT_WORD)

				switch (tokens.sval) {

				case "add":
					tokens.nextToken();
					tree.insert((int)tokens.nval);
					break;

				case "find":
					tokens.nextToken();
					tree.retrieve((int)tokens.nval);
					break;

				case "K":
					System.out.println(tree.Inorder());
					break;

				case "E":
					System.out.println(tree.isEmpty());
					break;

				case "F":
					System.out.println(tree.isFull());
					break;

				case "C":
					tree.clear();

					break;

				case "H":
					System.out.println(tree.heigth(tree.getRoot()));
					break;

				case "Q":
					System.exit(0);
					break;

				default:
					break;
				}
		}
	}
}


