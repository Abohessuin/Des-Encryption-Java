import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HandlingInput {
    private Map hexaBits;  
    private String key;
    private String plainText;
    private String leftKey;
    private String rightKey;
    private String leftPlainText;
    private String rightPlainText;
	public HandlingInput( String key, String plainText) {
		super();
		this.hexaBits = new HashMap();
		this.key = key;
		this.plainText = plainText;
		FillhexaBits();
	}
    
	public void FillhexaBits() {
		 hexaBits.put('0', "0000");
		 hexaBits.put('1', "0001");
		 hexaBits.put('2', "0010");
		 hexaBits.put('3', "0011");
		 hexaBits.put('4', "0100");
		 hexaBits.put('5', "0101");
		 hexaBits.put('6', "0110");
		 hexaBits.put('7', "0111");
		 hexaBits.put('8', "1000");
		 hexaBits.put('9', "1001");
		 hexaBits.put('A', "1010");
		 hexaBits.put('B', "1011");
		 hexaBits.put('C', "1100");
		 hexaBits.put('D', "1101");
		 hexaBits.put('E', "1110");
		 hexaBits.put('F', "1111");
		 
	}   
	
	public void handleKey() {
		 String newKey=""; 
		 for(int i=0;i<key.length();++i) {
			 newKey+=hexaBits.get(key.charAt(i));
		 }
		 this.leftKey="";
		 for(int i=0;i<32;++i) {
			 leftKey+=newKey.charAt(i);
		 }
		 this.rightKey="";
		 for(int i=32;i<64;++i) {
			 rightKey+=newKey.charAt(i);
		 }
		
		
		
	}
	
	public void handlePlainText() {
		String newPLainText=""; 
		 for(int i=0;i<plainText.length();++i) {
			 newPLainText+=hexaBits.get(plainText.charAt(i));
		 }
		 this.leftPlainText="";
		 int tbits=this.plainText.length()*4;
		 for(int i=0;i<tbits/2;++i) {
			 leftPlainText+=newPLainText.charAt(i);
		 }System.out.println(leftPlainText);
		 this.rightPlainText="";
		 for(int i=tbits/2;i<tbits;++i) {
			 rightPlainText+=newPLainText.charAt(i);
		 }
		 System.out.println(rightPlainText);
		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	public String getLeftKey() {
		return leftKey;
	}

	public String getRightKey() {
		return rightKey;
	}

	public String getLeftPlainText() {
		return leftPlainText;
	}

	public String getRightPlainText() {
		return rightPlainText;
	}
}
