package tn.esprit.JWTConfiguration;

import java.util.HashMap;

public class ShoppingConfiguration {
  public static Boolean validationwithHashmap(String keys[],HashMap<String,String>request)throws Exception{

    Boolean status= false;
    try {
           for(int start=0;start<keys.length;start++){
             if(request.containsKey(keys[start ])){//mafamech
               if(request.get(keys[start]).equals(""))
               {
                 throw new Exception(keys[start]+"Should not be empty");
               }

             }else {
               throw new Exception(keys[start]+"is missing");
             }
           }
    }catch (Exception e){
      throw new Exception("Error is "+e.getMessage());
    }
    return status;
  }
}
