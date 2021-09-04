/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author laptop
 */
public class Hash {
        
        /*retorna un Hash a partir de un tipo y un texto*/
        public static String getHash(String txt, String hashType){
            
            try {
                java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
                byte[]array = md.digest(txt.getBytes());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < array.length; i++) {
                    sb.append(Integer.toHexString((array[i] & 0xFF ) | 0x100).substring(1, 3));
                                
                }
                
                return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
                System.err.println(e.getMessage());
            }
            
            
            return null;


        }
        
            /*retorna un Hash md5 a partir de un texto*/
        public static String md5(String txt){
            return Hash.getHash(txt, "MD5");
            
        }
        
        /*retorna un Sha1 a partir de un texto*/
        public static String sha1(String txt){
            return Hash.getHash(txt, "SHA1");
            
        }
        
    
}
