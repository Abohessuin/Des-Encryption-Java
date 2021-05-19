
public class Main {

	public static void main(String[] args) {
		
		HandlingInput HI= new HandlingInput("133457799BBCDFF1","0123456789ABCDEF");
		HI.handleKey();
		HI.handlePlainText();
		Step1DES D = new Step1DES(HI.getnewKey());
		String Kplus = D.GetKeyPlus();
		D.SplitLeftRight(Kplus);
		D.GetShiftedKeys();
		//D.PrintAllKeys();
		String[] k=D.GetPermutionKeys();
		Step2DES f= new Step2DES(HI.getnewplaintext(),k);
        System.out.println(f.step2DES());
	}

}
