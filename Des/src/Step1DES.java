
public class Step1DES {

	private String Key ;
	private String Left;
	private String Right;
	public String []ShiftedKeys = new String[17];
	public String []newShiftedKeys = new String[16];
	
	public int[] PC1 = { 57, 49, 41, 33, 25,
            17, 9, 1, 58, 50, 42, 34, 26,
            18, 10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36, 63,
            55, 47, 39, 31, 23, 15, 7, 62,
            54, 46, 38, 30, 22, 14, 6, 61,
            53, 45, 37, 29, 21, 13, 5, 28,
            20, 12, 4 };
	
	int[] PC2 = { 14, 17, 11, 24, 1, 5, 3,
            28, 15, 6, 21, 10, 23, 19, 12,
            4, 26, 8, 16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55, 30, 40,
            51, 45, 33, 48, 44, 49, 39, 56,
            34, 53, 46, 42, 50, 36, 29, 32 };
	
	public  int[] shiftBits = { 1, 1, 2, 2, 2, 2, 2, 2,
              1, 2, 2, 2, 2, 2, 2, 1 };
	
	public Step1DES(String Key) {
		this.Key=Key;
	}
	
public void GetPermutionKeys() {
		
		
		for(int i=0 ; i<newShiftedKeys.length ; i++) {
			String Kplus = "";
		for(int j=0 ; j<PC2.length ; j++) {
			
			Kplus+=ShiftedKeys[i+1].charAt(PC2[j]-1);
			
		}
		newShiftedKeys[i]=Kplus;
		}
		
	}
	
	public String GetKeyPlus() {
		
		String Kplus = "";
		
		for(int i=0 ; i<PC1.length ; i++) {
			
			Kplus+=Key.charAt(PC1[i]-1);
			
		}
		return Kplus;
	}
	public void SplitLeftRight(String KPlus) {
		String Left = "";
		String Right = "";
		for(int i=0 ; i<KPlus.length()/2 ; i++) {
			Left+=KPlus.charAt(i);
		}
		for(int i=KPlus.length()/2 ; i<KPlus.length() ; i++) {
			Right+=KPlus.charAt(i);
		}
		this.Left=Left;
		this.Right=Right;
		
	}
	
	public void GetShiftedKeys() {
		ShiftedKeys[0]=Left+Right;
		int in=1;
		for(int i=1 ; i<ShiftedKeys.length; i++){
			//System.out.println(i+"indexx \n");
			ShiftedKeys[i]=GetNextKey(i,ShiftedKeys[i-1]);
		}
	}
	public String GetNextKey(int index,String LastKey) {
		String L=GetLeft(LastKey);
		String R=GetRight(LastKey);
		//System.out.println(shiftBits[index]+"indexx \n");
		int Bit = shiftBits[index-1];
		
		L = Shifting(Bit,L);
		R = Shifting(Bit,R);
		
		return L+R;
	}
	
	public String GetLeft(String LastKey) {
		String Left="";
		//System.out.println(LastKey+"\n");
		for(int i=0 ; i<(LastKey.length()/2) ; i++) {
			Left+=LastKey.charAt(i);
			//System.out.println(Left+"\n");
		}
		return Left;
	}
	public String GetRight(String LastKey) {
		String Right="";
		for(int i=LastKey.length()/2 ; i<LastKey.length() ; i++) {
			Right+=LastKey.charAt(i);
		}
		return Right;
	}
	
	public String Shifting(int Bit , String Left) {
		String NewLeft="";
		
		while(Bit!=0) {
			NewLeft="";
		for(int i=0 ; i<Left.length() ; i++) {
			if(i==Left.length()-1) {
				NewLeft+=Left.charAt(0);
			}
			else {
			NewLeft+=Left.charAt(i+1);
			}
		}
		Bit--;
		Left=NewLeft;
		}
		
		return NewLeft;
	}
	
	public void PrintAllKeys() {
		for(int i=0 ; i<17 ; i++) {
			System.out.println(ShiftedKeys[i]+"\n");
		}
	}
	
	public void PrintAllNewKeys() {
		for(int i=0 ; i<16 ; i++) {
			System.out.println(newShiftedKeys[i]+"\n");
		}
	}
}
