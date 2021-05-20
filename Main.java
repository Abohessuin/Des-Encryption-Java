import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter PlainText : ");
	    String Text = myObj.nextLine(); 
	    System.out.println("Enter Key : ");
	    String Key = myObj.nextLine(); 
		HandlingInput HI= new HandlingInput(Key,Text);
		HI.handleKey();
		HI.handlePlainText();
		Step1DES D = new Step1DES(HI.getnewKey());
		String Kplus = D.GetKeyPlus();
		D.SplitLeftRight(Kplus);
		D.GetShiftedKeys();
		//D.PrintAllKeys();
		String[] k=D.GetPermutionKeys();
		Step2DES f= new Step2DES(HI.getnewplaintext(),k);
		System.out.println("Encryption of PlainText is : ");
        System.out.println(f.step2DES());
	}

}
//0123456789ABCDEF
//133457799BBCDFF1
