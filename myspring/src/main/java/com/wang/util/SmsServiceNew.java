package com.wang.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class SmsServiceNew {
  private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
      'E', 'F' };
  private static final String account      = "800510";
  private static final String password     = "kfb49kg3";

  public static int send(String mobile, String message, String sign) {
    CloseableHttpResponse response = null;
    CloseableHttpClient httpClient = HttpClients.createDefault();
    try {
      message = "【"+sign+"】"+message;
      String url = "http://222.73.44.38:8080/mt?un=" + account + "&pw=" + password + "&da=" + mobile + "&sm="
          + encodeHexStr(message.getBytes("GBK")) + "&dc=15&rd=1";
      HttpGet httpGet = new HttpGet(url);
     
      response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      String resultStr = EntityUtils.toString(entity, "UTF-8");
      if(resultStr.startsWith("id=")){
        return 0;
      }else{
        return 1;
      }
    } catch (Exception e) {

    } finally {
      if (null != response) {
        try {
          response.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (null != httpClient) {
        try {
          httpClient.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return 1;
  }

  private static String encodeHexStr(byte[] data) {
    return encodeHexStr(data, DIGITS_UPPER);
  }

  private static String encodeHexStr(byte[] data, char[] toDigits) {
    return new String(encodeHex(data, toDigits));
  }

  private static char[] encodeHex(byte[] data, char[] toDigits) {
    int l = data.length;
    char[] out = new char[l << 1];
    // two characters form the hex value.
    for (int i = 0, j = 0; i < l; i++) {
      out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
      out[j++] = toDigits[0x0F & data[i]];
    }
    return out;
  }
  public static void main(String args[]){
    System.out.println(SmsServiceNew.send("18810475972", "惹我认为惹我1", "孕客"));
  }
}
