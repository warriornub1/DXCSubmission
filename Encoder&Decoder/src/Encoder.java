import java.util.HashMap;

public class Encoder implements CoderInterface {

	private static String REFERENCE_STRING;
	private HashMap<Character, Character> encoderHashMap;
	private HashMap<Character, Character> decoderHashMap;
	
	//Initialize encoder and decoder hashmap inside constructor 
	public Encoder(String word)
	{
		//Initialize REFERENCE_STRING
		REFERENCE_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
		
		//Create encoderHashMap and decoderHashMap
		encoderHashMap = new HashMap<Character, Character>();
		decoderHashMap = new HashMap<Character, Character>();
		
		int strIndex = REFERENCE_STRING.indexOf(word.charAt(0));
		//Initiate HashMap O(n)
		for(int index = 0; index < REFERENCE_STRING.length(); index++)
		{
			//find the index of the encoded character
			int new_index = (index + (44 - strIndex)) % 44;
			
			//put into Hashamp with key being the character and value being the new character
			encoderHashMap.put(REFERENCE_STRING.charAt(index), REFERENCE_STRING.charAt(new_index));
			//put into Hashamp with key being the new character and value being the character
			decoderHashMap.put(REFERENCE_STRING.charAt(new_index), REFERENCE_STRING.charAt(index));
		}
		encoderHashMap.put(' ', ' ');
		decoderHashMap.put(' ', ' ');
		
	}
	
	@Override
	public String encoder(String word) 
	{
		StringBuilder encodedText = new StringBuilder();

		if(word.length() == 0)
			return "Error ! String cannot be empty";
		else {
			for(int index = 0; index < word.length(); index++ )
			{
				encodedText.append(encoderHashMap.get(word.charAt(index)));
			}
		}
		return encodedText.toString();
	}

	@Override
	public String decoder(String word) {
		StringBuilder decodedText = new StringBuilder();

		if(word.length() == 0)
			return "Error ! String cannot be empty";
		else {
			for(int index = 0; index < word.length(); index++ )
			{
				decodedText.append(decoderHashMap.get(word.charAt(index)));
			}
		}
		return decodedText.toString();
	}


}
