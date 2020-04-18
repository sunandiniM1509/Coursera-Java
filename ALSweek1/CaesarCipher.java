import edu.duke.FileResource;
    class CaesarCipher
    {
        //only upperCase
        String encrypt(String input ,int key)
        {
            StringBuilder encrypted = new StringBuilder(input);
            String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
            for(int i=0;i<encrypted.length();i++)
            {
                char currChar = encrypted.charAt(i);
                int idx = alphabet.indexOf(currChar);
                if(idx!=-1)
                {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            return encrypted.toString();
        }
        //both upperCase and lowerCase
        String modifiedEncrypt(String input ,int key)
        {
            StringBuilder encrypted = new StringBuilder(input);
            String lowalphabet ="abcdefghijklmnopqrstuvwxyz";
            String upalphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String shiftedlowAlphabet = lowalphabet.substring(key)+lowalphabet.substring(0,key);
            String shiftedupAlphabet = upalphabet.substring(key)+upalphabet.substring(0,key);
            for(int i=0;i<encrypted.length();i++)
            {
                char currChar = encrypted.charAt(i);
                if (Character.isUpperCase(input.charAt(i)))
                {
                    int idx = upalphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedupAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
                if (Character.isLowerCase(input.charAt(i)))
                {
                    int idx = lowalphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedlowAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            return encrypted.toString();
        }
        //encrypt with two keys (even , odd indices)
        String encryptTwoKeys(String input ,int key1,int key2)
        {
            StringBuilder encrypted = new StringBuilder(input);
            String lowalphabet ="abcdefghijklmnopqrstuvwxyz";
            String upalphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            for(int i=0;i<encrypted.length();i++)
            {
                char currChar = encrypted.charAt(i);
                int key = i%2==0 ? key1 :key2 ;
                if (Character.isUpperCase(input.charAt(i)))
                {
                    String shiftedupAlphabet = upalphabet.substring(key)+upalphabet.substring(0,key);
                    int idx = upalphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedupAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
                if (Character.isLowerCase(input.charAt(i)))
                {
                    String shiftedlowAlphabet = lowalphabet.substring(key)+lowalphabet.substring(0,key);
                    int idx = lowalphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedlowAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            return encrypted.toString();
        }

        void testCeaser()
        {
            int key =17;
            FileResource fr = new FileResource();
            String message = fr.asString();
            String encrypted = encrypt(message, key);
            System.out.println("key is " + key + "\n" + encrypted);
            String modifiedencrypted = modifiedEncrypt(message, key);
            System.out.println("key is " + key + "\n" + modifiedencrypted);
            String twokeys = encryptTwoKeys("First Legion",23,17);
            System.out.println(twokeys);
        }
    }
    public class AssignmentTwo
    {
        public static void main(String[] args) {
            CaesarCipher caesarCipher = new CaesarCipher();
            caesarCipher.testCeaser();
        }
    }
