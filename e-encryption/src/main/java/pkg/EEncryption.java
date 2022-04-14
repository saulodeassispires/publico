package pkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class EEncryption {

	public enum KEY_TYPE
	{
		KEY,
		PATH	    
	}
	
	private static SecretKeySpec secretKey;
    private static final int KEY_SIZE = 16;
    
	public static void main(String[] args) {

		//createFileKey("C:\\Users\\jpari\\OneDrive\\�rea de Trabalho\\Chave");
 /*   	
    	System.out.println(encrypt("Metadata_MySQL_AdditionalParams", KEY_TYPE.KEY, "|�%Ͷ(SuR^[�430�"));
    	System.out.println(encrypt("allowPublicKeyRetrieval=true & useSSL=false & serverTimezone=UTC", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("Metadata_MySQL_Database", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("produto", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("Metadata_MySQL_Login", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("root", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("Metadata_MySQL_Password", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("Produto@2021", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("Metadata_MySQL_Port", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("3306", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("Metadata_MySQL_Server", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	System.out.println(encrypt("localhost", KEY_TYPE.KEY, "�S�_�{��SCUi@po	"));
    	
    	System.out.println(decrypt("MPiLWiI5dMo7H+I2sKKQE5cobXef0X2wpYEut7Ax3Vk=", KEY_TYPE.KEY, "|�%Ͷ(SuR^[�430�"));
    
	
		System.out.println(decrypt("MUHhtCOc51+WCbTUT+KDRqDGA1Uxd7YoOTUo9yI3aBl0cCR/iDFGLh0+omH1UR4pmhF8s89gef/6EbOFs1vCNd2SSNcSV+/nu8Bc831ZhAQ=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
		System.out.println(decrypt("VItJ00M+4XToEfaTtHA79PuRcWWKJAbuG/luIKaXr3M=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
		System.out.println(decrypt("C5Jv1FGY3LxzrruJ+W99Gu2MsKN0DoYTS7kQLEK5YnI=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
		System.out.println(decrypt("ad+BKBquaRNhQDqx726rE1g++LUD8QuOsZh8Bi+xBqA=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
		System.out.println(decrypt("ad+BKBquaRNhQDqx726rE4qJL4s4tegdrXf1cJ5VjAI=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
		System.out.println(decrypt("1zeRYEs41YacuGZa2vmhRooanPoC/2/YMOq8xKRPx3g=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));

    	System.out.println(encrypt("robotmysql.mysql.database.azure.com", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	System.out.println(encrypt("3306", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	System.out.println(encrypt("robotdataintegration", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	System.out.println(encrypt("robot@robotmysql", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	System.out.println(encrypt("P@55W0r)P@55W0r)", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	
    	
 */   	

System.out.println(encrypt("saulo", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
System.out.println(decrypt("/g4CxNZUefG3cM9PHeXS0g==", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));


    	//System.out.println(decrypt("MUHhtCOc51+WCbTUT+KDRqDGA1Uxd7YoOTUo9yI3aBl0cCR/iDFGLh0+omH1UR4pmhF8s89gef/6EbOFs1vCNd2SSNcSV+/nu8Bc831ZhAQ=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	//System.out.println(decrypt("VItJ00M+4XToEfaTtHA79PuRcWWKJAbuG/luIKaXr3M=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	//System.out.println(decrypt("C5Jv1FGY3LxzrruJ+W99Gu2MsKN0DoYTS7kQLEK5YnI=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	//System.out.println(decrypt("ad+BKBquaRNhQDqx726rE1g++LUD8QuOsZh8Bi+xBqA=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	//System.out.println(decrypt("ad+BKBquaRNhQDqx726rE4qJL4s4tegdrXf1cJ5VjAI=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	//System.out.println(decrypt("1zeRYEs41YacuGZa2vmhRooanPoC/2/YMOq8xKRPx3g=", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));

    	
    	
    	//System.out.println(decrypt("qxKBsvwfORxIxe7g0376RQ==", KEY_TYPE.PATH, "C:\\ETL\\.mtdk"));
    	
    	//System.out.println(encrypt("Robot", KEY_TYPE.PATH, "C:\\Users\\jpari\\Google Drive\\ETL\\.rpk"));
    	
	}

public static void createFileKey(String fileName) throws Exception {
		
		// Define o gerador de chaves AES.
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		
		// Tamanho da chave. Nesse exemplo KEY_SIZE � igual 16, portanto a chave � de 128 bits.
		kg.init(KEY_SIZE * 8);
		
		// Gera uma nova chave.
		SecretKey chave = kg.generateKey();

		// Salva a chave em um arquivo.
		FileOutputStream fos = new FileOutputStream(fileName);
		fos.write(chave.getEncoded());
		fos.close();
		
	}

    public static String encrypt(String strToEncrypt, KEY_TYPE type, String key) 
    {
        try
        {
        	if (type == KEY_TYPE.PATH)
        		secretKey = readFileKey(key);
        	else if (type == KEY_TYPE.KEY)
        		secretKey = readEncodedKey(key);
        	
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    public static String decrypt(String strToDecrypt, KEY_TYPE type, String key) 
    {
        try
        {
        	if (type == KEY_TYPE.PATH)
        		secretKey = readFileKey(key);
        	else if (type == KEY_TYPE.KEY)
        		secretKey = readEncodedKey(key);
        	
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    private static SecretKeySpec readFileKey(String fileKeyPath) throws Exception {
		
    	FileInputStream fis = null;
    			
    	try {
    	
    		// L� o conte�do do arquivo e guarda no vetor de bytes.
    		byte bytesChave[] = new byte[KEY_SIZE];
    		fis = new FileInputStream(fileKeyPath);
    		fis.read(bytesChave);

    		// Cria uma chave AES com os bytes lidos.
    		return new SecretKeySpec(bytesChave, "AES");
    		
    	}finally {
    		
    		if (fis != null)
    			fis.close();
    		
    	}
		
	}

	private static SecretKeySpec readEncodedKey(String encodedKey) throws Exception {

		System.out.println("key: " + encodedKey);
		byte bytesChave[] = new byte[KEY_SIZE];
		bytesChave = encodedKey.getBytes();
		
		// Cria uma chave AES com os bytes lidos.
		return new SecretKeySpec(bytesChave, "AES");

	}
	
}
