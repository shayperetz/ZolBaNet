package org.es.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;



public class Password {
    private byte[] encryptedPassword;
    private String password;
    public Password(){

    }
    public Password(String pass){
        encryptedPassword = encrypt(pass);
    }


    public static byte[] encrypt(String pass){
        byte[] source = pass.getBytes();
        ArrayList<Byte> res = new ArrayList<Byte>();
        int y=0x0000000F ;
        int x=0x000000F0 ;
        for(int i=0;i<source.length;i++) {
            int p = (int)source[i] & y;
            int q = (int)source[i] & x;
            p<<=4;
            q>>=4;
            int w = q|p;
            if ((int)source[i]<256&&(int)source[i]>0){
                res.add((byte)0);
            }
            res.add((byte)w) ;

        }
        byte[] result = new byte[res.size()];
        for(int i=0;i<result.length;i++){
            result[i]=res.get(i);
        }
        return result;
    }

    public static String encryptedPasswordMaker(String pass){
        byte[] a = encrypt(pass);
        StringBuilder s = new StringBuilder();
        for(int i=0;i<a.length;i++){
            s.append(a[i]);
            if((i)%(6)==0) {
                s.append(",");
            }
            else if ((i)%(5)==1){
                s.append("#");
            }
            else{
                s.append("%");
            }
        }
        return s.toString();
    }

    public static String decrypt(byte[] pass){
        int y=0x0000000F ;
        int x=0x000000F0 ;
        byte[] bytes = new byte[pass.length];
        for(int i=0,j=0;i<pass.length;i++,j++){
            int p = pass[i] & y;
            int q = pass[i] & x;
            p <<= 4;
            q >>= 4;
            int w = q|p;
            if(w!=0) {
                bytes[j] = (byte) w;
            }
           else{
                j--;
            }
        }
        String s = new String(bytes, Charset.forName("UTF-8"));
        return s.trim();
    }
    //only works for strings that came by encryptedPasswordMaker
    public static String decrypt (String encPass){
        String[] res=encPass.split(",|#|%");
        byte[] a = new byte[res.length];
        for (int i=0;i<res.length;i++){
            int n=Integer.parseInt(res[i]);
            a[i]=(byte)n;
        }
        return decrypt(a);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        encryptedPassword=encrypt(password);
    }

    public String toString(){
        return Arrays.toString(encryptedPassword);
    }

    public static void main(String[] args) {
        if(args.length==1){
            System.out.println(encryptedPasswordMaker(args[0]));
        }
        else{
            System.out.println("missing parameter \nUSAGE: encrypting-tool <password>");
        }
    }
}
