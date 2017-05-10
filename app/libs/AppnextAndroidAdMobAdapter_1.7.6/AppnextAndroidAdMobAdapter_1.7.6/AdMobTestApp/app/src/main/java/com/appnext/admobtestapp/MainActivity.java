//
//  MainActivity.java
//  AppnextAdMobTestApp
//
//  Created by Eran Mausner on 26/06/2016.
//  Copyright (c) 2016 Appnext. All rights reserved.
//

package com.appnext.admobtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.appnext.admobadapter.AppnextAdMobCustomEvent;
import com.appnext.admobadapter.AppnextAdMobCustomEventInterstitial;
import com.appnext.admobadapter.AppnextAdMobCustomEventFullScreenVideo;
import com.appnext.admobadapter.AppnextAdMobCustomEventRewardedVideo;
import com.appnext.ads.fullscreen.FullScreenVideo;
import com.appnext.ads.fullscreen.FullscreenConfig;
import com.appnext.ads.fullscreen.RewardedConfig;
//import com.appnext.ads.fullscreen.RewardedServerSidePostback;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.ads.interstitial.InterstitialConfig;
import com.appnext.core.Ad;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    // AdMob App ID: ca-app-pub-XXXXXXXXXXXXXXXX~XXXXXXXXXX

    private InterstitialAd mCustomEventInterstitial;
    private InterstitialAd mCustomisedCustomEventInterstitial;
    private InterstitialAd mCustomEventFullScreen;
    private InterstitialAd mCustomisedCustomEventFullScreen;
    private InterstitialAd mCustomEventRewarded;
    private InterstitialAd mCustomisedCustomEventRewarded;

    private Button mCustomEventInterstitialButton;
    private Button mCustomisedCustomEventInterstitialButton;
    private Button mCustomEventFullScreenButton;
    private Button mCustomisedCustomEventFullScreenButton;
    private Button mCustomEventRewardedButton;
    private Button mCustomisedCustomEventRewardedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom event interstitial button.
        mCustomEventInterstitialButton = (Button)findViewById(R.id.customeventinterstitial_button);
        mCustomEventInterstitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomEventInterstitial.isLoaded()) {
                    mCustomEventInterstitial.show();
                }
            }
        });

        // Customized custom event interstitial button.
        mCustomisedCustomEventInterstitialButton = (Button)findViewById(R.id.customizedcustomeventinterstitial_button);
        mCustomisedCustomEventInterstitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomisedCustomEventInterstitial.isLoaded()) {
                    mCustomisedCustomEventInterstitial.show();
                }
            }
        });

        // Custom event fullscreen button.
        mCustomEventFullScreenButton = (Button)findViewById(R.id.customeventfullscreen_button);
        mCustomEventFullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomEventFullScreen.isLoaded()) {
                    mCustomEventFullScreen.show();
                }
            }
        });

        // Customized custom event fullscreen button.
        mCustomisedCustomEventFullScreenButton = (Button)findViewById(R.id.customizedcustomeventfullscreen_button);
        mCustomisedCustomEventFullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomisedCustomEventFullScreen.isLoaded()) {
                    mCustomisedCustomEventFullScreen.show();
                }
            }
        });

        // Custom event rewarded button.
        mCustomEventRewardedButton = (Button)findViewById(R.id.customeventrewarded_button);
        mCustomEventRewardedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomEventRewarded.isLoaded()) {
                    mCustomEventRewarded.show();
                }
            }
        });

        // Customized custom event rewarded button.
        mCustomisedCustomEventRewardedButton = (Button)findViewById(R.id.customizedcustomeventrewarded_button);
        mCustomisedCustomEventRewardedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCustomisedCustomEventRewarded.isLoaded()) {
                    mCustomisedCustomEventRewarded.show();
                }
            }
        });

        createAndLoadInterstitial();
        createAndLoadCustomisedInterstitial();
        createAndLoadFullScreen();
        createAndLoadCustomisedFullScreen();
        createAndLoadRewarded();
        createAndLoadCustomisedRewarded();
    }

    private void createAndLoadInterstitial() {
        // Custom event interstitial.
        mCustomEventInterstitial = new InterstitialAd(this);
        mCustomEventInterstitial.setAdUnitId(getResources().getString(R.string.customevent_interstitial_ad_unit_id));
        mCustomEventInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading custom event interstitial, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mCustomEventInterstitialButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                mCustomEventInterstitialButton.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                mCustomEventInterstitialButton.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                mCustomEventInterstitial.loadAd(new AdRequest.Builder().build());
            }
        });

        mCustomEventInterstitial.loadAd(new AdRequest.Builder().build());
    }

    private void createAndLoadCustomisedInterstitial() {
        // Customised custom event interstitial.
        mCustomisedCustomEventInterstitial = new InterstitialAd(this);
        mCustomisedCustomEventInterstitial.setAdUnitId(getResources().getString(R.string.customizedcustomevent_interstitial_ad_unit_id));
        mCustomisedCustomEventInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading customized custom event interstitial, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mCustomisedCustomEventInterstitialButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                mCustomisedCustomEventInterstitialButton.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                mCustomisedCustomEventInterstitialButton.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                configAndLoadCustomisedInterstitial();
            }
        });
        configAndLoadCustomisedInterstitial();
    }

    private void configAndLoadCustomisedInterstitial() {
        InterstitialConfig config = new InterstitialConfig();
        config.setButtonColor("#ff0000");
        config.setButtonText("App Install");
        config.setPostback("Your_Postback_Params");
        config.setCategories("Categories");
        config.setOrientation(Ad.ORIENTATION_AUTO);
        config.setMute(false);
        config.setBackButtonCanClose(true);

        config.setSkipText("My Skip");
        config.setAutoPlay(true);
        config.setCreativeType(Interstitial.TYPE_MANAGED);
        Bundle customEventExtras = new Bundle();
        customEventExtras.putSerializable(AppnextAdMobCustomEvent.AppnextConfigurationExtraKey, config);
        AdRequest adRequest = new AdRequest.Builder().addCustomEventExtrasBundle(AppnextAdMobCustomEventInterstitial.class, customEventExtras).build();
        mCustomisedCustomEventInterstitial.loadAd(adRequest);
    }

    private void createAndLoadFullScreen() {
        // Custom event fullscreen.
        mCustomEventFullScreen = new InterstitialAd(this);
        mCustomEventFullScreen.setAdUnitId(getResources().getString(R.string.customevent_fullscreen_ad_unit_id));
        mCustomEventFullScreen.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading custom event fullscreen, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mCustomEventFullScreenButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                mCustomEventFullScreenButton.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                mCustomEventFullScreenButton.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                mCustomEventFullScreen.loadAd(new AdRequest.Builder().build());
            }
        });
        mCustomEventFullScreen.loadAd(new AdRequest.Builder().build());
    }

    private void createAndLoadCustomisedFullScreen() {
        // Customised custom event fullscreen.
        mCustomisedCustomEventFullScreen = new InterstitialAd(this);
        mCustomisedCustomEventFullScreen.setAdUnitId(getResources().getString(R.string.customizedcustomevent_fullscreen_ad_unit_id));
        mCustomisedCustomEventFullScreen.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading customized custom event fullscreen, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mCustomisedCustomEventFullScreenButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                mCustomisedCustomEventFullScreenButton.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                mCustomisedCustomEventFullScreenButton.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                configAndLoadCustomisedFullScreen();
            }
        });
        configAndLoadCustomisedFullScreen();
    }

    private void configAndLoadCustomisedFullScreen() {
        FullscreenConfig config = new FullscreenConfig();
        config.setButtonColor("#ff0000");
        config.setButtonText("App Install");
        config.setPostback("Your_Postback_Params");
        config.setCategories("Categories");
        config.setOrientation(Ad.ORIENTATION_AUTO);
        config.setMute(false);
        config.setBackButtonCanClose(true);

        config.setProgressType(FullScreenVideo.PROGRESS_CLOCK);
        config.setProgressColor("#ffffff");
        config.setVideoLength(FullScreenVideo.VIDEO_LENGTH_DEFAULT);
        config.setShowClose(false, 0);
        Bundle customEventExtras = new Bundle();
        customEventExtras.putSerializable(AppnextAdMobCustomEvent.AppnextConfigurationExtraKey, config);
        AdRequest adRequest = new AdRequest.Builder().addCustomEventExtrasBundle(AppnextAdMobCustomEventFullScreenVideo.class, customEventExtras).build();
        mCustomisedCustomEventFullScreen.loadAd(adRequest);
    }

    private void createAndLoadRewarded() {
        // Custom event rewarded.
        mCustomEventRewarded = new InterstitialAd(this);
        mCustomEventRewarded.setAdUnitId(getResources().getString(R.string.customevent_rewarded_ad_unit_id));
        mCustomEventRewarded.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading custom event rewarded, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mCustomEventRewardedButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                mCustomEventRewardedButton.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                mCustomEventRewardedButton.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                mCustomEventRewarded.loadAd(new AdRequest.Builder().build());
            }
        });
        mCustomEventRewarded.loadAd(new AdRequest.Builder().build());
    }

    private void createAndLoadCustomisedRewarded() {
        // Customised custom event rewarded.
        mCustomisedCustomEventRewarded = new InterstitialAd(this);
        mCustomisedCustomEventRewarded.setAdUnitId(getResources().getString(R.string.customizedcustomevent_rewarded_ad_unit_id));
        mCustomisedCustomEventRewarded.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(MainActivity.this,
                        "Error loading customized custom event rewarded, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mCustomisedCustomEventRewardedButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                mCustomisedCustomEventRewardedButton.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                mCustomisedCustomEventRewardedButton.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                configAndLoadCustomisedRewarded();
            }
        });
        configAndLoadCustomisedRewarded();
    }

    private void configAndLoadCustomisedRewarded() {
        RewardedConfig config = new RewardedConfig();
        config.setButtonColor("#ff0000");
        config.setButtonText("App Install");
        config.setPostback("Your_Postback_Params");
        config.setCategories("Categories");
        config.setOrientation(Ad.ORIENTATION_AUTO);
        config.setMute(false);
        config.setBackButtonCanClose(true);

        config.setProgressType(FullScreenVideo.PROGRESS_CLOCK);
        config.setProgressColor("#ffffff");
        config.setVideoLength(FullScreenVideo.VIDEO_LENGTH_DEFAULT);
        config.setShowClose(false, 0);

//        RewardedServerSidePostback postbackParams = new RewardedServerSidePostback();
//        postbackParams.setRewardsTransactionId("your_rewardsTransactionId");
//        postbackParams.setRewardsUserId("your_rewardsUserId");
//        postbackParams.setRewardsRewardTypeCurrency("your_rewardsRewardTypeCurrency");
//        postbackParams.setRewardsAmountRewarded("your_rewardsAmountRewarded");
//        postbackParams.setRewardsCustomParameter("your_rewardsCustomParameter");

        Bundle customEventExtras = new Bundle();
        customEventExtras.putSerializable(AppnextAdMobCustomEvent.AppnextConfigurationExtraKey, config);
//        customEventExtras.putSerializable(AppnextAdMobCustomEvent.AppnextRewardPostbackExtraKey, postbackParams);
        AdRequest adRequest = new AdRequest.Builder().addCustomEventExtrasBundle(AppnextAdMobCustomEventRewardedVideo.class, customEventExtras).build();
        mCustomisedCustomEventRewarded.loadAd(adRequest);
    }
}
