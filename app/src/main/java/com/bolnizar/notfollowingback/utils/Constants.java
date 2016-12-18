package com.bolnizar.notfollowingback.utils;

/**
 * Created by Musafir on 12/19/2016.
 */

public interface Constants {

    String REDIRECT_URL = "https://github.com/BoldijarPaul/not-following-back";
    String AUTH_URL = "https://api.instagram.com/oauth/authorize/?client_id=5bc0a0832ee14e368f1b6422e073ab36&redirect_uri=" + REDIRECT_URL + "&response_type=token&scope=follower_list";
}
