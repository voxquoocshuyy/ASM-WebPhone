/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginFB;

/**
 *
 * @author Quoc Huy
 */
public class Constants {
  public static String FACEBOOK_APP_ID = "182240006818212";
  public static String FACEBOOK_APP_SECRET = "95e0ca8bdf5eeb96ea7a1b8db9ed4176";
  public static String FACEBOOK_REDIRECT_URL = "http://localhost:8084/ASM-WebPhone/LoginFacebook";
  public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
