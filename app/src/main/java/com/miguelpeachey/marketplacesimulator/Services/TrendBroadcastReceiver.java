package com.miguelpeachey.marketplacesimulator.Services;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

//import com.miguelpeachey.marketplacesimulator.Fragments.MarketplaceHome;
import com.miguelpeachey.marketplacesimulator.R;

import java.util.Random;

public class TrendBroadcastReceiver extends BroadcastReceiver {
    String adjRand, fashionPeopleRand, authorsRand, descRand, reviewersRand, electronicPeopleRand, partsRand, sportsItemsRand,
            sportsPeopleRand, vehiclesRand, vehiclesPeopleRand, homeDecorRand, homeDecorPeopleRand, furnitureRand,
            furniturePeopleRand;
    String[] adjectives = {"great", "amazing", "superb", "attractive", "great quality", "worth the value", "impressive", "well-made",
            "top notch", "admirable"};
    String[] fashionPeople = {"Versace", "Nike", "Adidas", "Lacoste", "Armani", "Tommy Hilfiger"};
    String[] electronicPeople = {"EVGA", "Corsair", "Microsoft", "Deepcool", "Samsung", "Hyper", "Intel", "AMD", "Nvidia", "Sony"};
    String[] sportsPeople = {"Under Amour", "Sky Sports", "Reebok", "Nike", "Adidas", "Puma", "Canterbury"};
    String[] vehiclesPeople = {"Audi", "Toyota", "Chevrolet", "Aston Martin", "Ford", "Dodge", "Cadillac", "Honda"};
    String[] homeDecorPeople = {"Apparatus Studio", "IKEA", "Dassie Artisans", "Fredericks and Mae", "Article"};
    String[] furniturePeople = {"Lexington", "Bernhardt", "IKEA", "Bassett", "Liberty Furniture", "Broyhill"};
    String[] authorNames = {"Dean W.", "Lucas B.", "Veronica S.", "Natasha E.", "Donald G.", "Elizabeth A.", "Grace L.", "Michael R.", "Joseph F.", "Caroline T.",
            "Harry E.", "David H.", "Julia C.", "Sarah T."};
    String[] desc = {"made a name for", "made some noise for", "created an outburst for", "promoted", "brought forth"};
    String[] reviewers = {"media", "the consumers", "people"};
    String[] pcParts = {"processor", "keyboard", "gaming peripherals", "phone", "headphones"};
    String[] sportsItems = {"shoes", "fitness guide", "gym membership discount", "sports cap", "running gear"};
    String[] vehicles = {"car", "motorbike", "vehicle toolkit", "safety helmet", "leather seat", "custom wheels"};
    String[] homeDecor = {"pot plants", "picture frames", "paint palettes", "artwork", "vases", "floating shelves"};
    String[] furniture = {"outdoor chairs", "bedside tables", "drawers", "bookshelves", "desks", "sofa"};
    String[] trendsList = {"Fashion", "Electronics", "Sports Equipment", "Vehicles", "Home Décor", "Furniture"};
    String randomStr = trendsList[new Random().nextInt(trendsList.length)];
    String channelID;

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, channelID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Marketplace Simulator")
                        .setContentText("New category trending: " + randomStr);


        Vibrator vibrator = (Vibrator) context
                .getSystemService(Context.VIBRATOR_SERVICE);
       // vibrator.vibrate(800);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

        adjRand = adjectives[new Random().nextInt(adjectives.length)];
        fashionPeopleRand = fashionPeople[new Random().nextInt(fashionPeople.length)];
        authorsRand = authorNames[new Random().nextInt(authorNames.length)];
        descRand = desc[new Random().nextInt(desc.length)];
        reviewersRand = reviewers[new Random().nextInt(reviewers.length)];
        electronicPeopleRand = electronicPeople[new Random().nextInt(electronicPeople.length)];
        partsRand = pcParts[new Random().nextInt(pcParts.length)];
        sportsItemsRand = sportsItems[new Random().nextInt(sportsItems.length)];
        sportsPeopleRand = sportsPeople[new Random().nextInt(sportsPeople.length)];
        vehiclesPeopleRand = vehiclesPeople[new Random().nextInt(vehiclesPeople.length)];
        vehiclesRand = vehicles[new Random().nextInt(vehicles.length)];
        homeDecorRand = homeDecor[new Random().nextInt(homeDecor.length)];
        homeDecorPeopleRand = homeDecorPeople[new Random().nextInt(homeDecorPeople.length)];
        furnitureRand = furniture[new Random().nextInt(furniture.length)];
        furniturePeopleRand = furniturePeople[new Random().nextInt(furniturePeople.length)];

        SharedPreferences.Editor editor = context.getSharedPreferences("countPrefs", context.MODE_PRIVATE).edit();
        editor.putInt("int", 5);
        editor.apply();

        trendingText();
    }

    public void trendingText() {

      /*  MarketplaceHome.tvDemandStatus.setText(randomStr);

        if (MarketplaceHome.tvDemandStatus.getText().toString().equals("Fashion")) {
            MarketplaceHome.tvTrendDesc.setText(fashionPeopleRand + " have recently " + descRand + " the industry with their products. According" +
                    " to the " + reviewersRand + ", the new designs are " + adjRand + " and turn the competition " +
                    "up a notch. \n \n" + "- " + authorsRand);
        } else if (MarketplaceHome.tvDemandStatus.getText().toString().equals("Electronics")) {
            MarketplaceHome.tvTrendDesc.setText("Lately, " + electronicPeopleRand + " have released their new " + partsRand + ". And, from " + reviewersRand +
                    " perspective, it's " + adjRand + ". So don't miss out, make sure to buy " + electronicPeopleRand + "'s new " +
                    partsRand + ". \n \n" + "- " + authorsRand);
        } else if (MarketplaceHome.tvDemandStatus.getText().toString().equals("Sports Equipment")) {
            MarketplaceHome.tvTrendDesc.setText("What a " + adjRand + " effort by " + sportsPeopleRand + " with their new " + sportsItemsRand + ". " +
                    "Trust me, it's really that " + adjRand + " so listen up everybody, we got " +
                    "some competition! \n \n" + "- " + authorsRand);
        } else if (MarketplaceHome.tvDemandStatus.getText().toString().equals("Vehicles")) {
            MarketplaceHome.tvTrendDesc.setText(vehiclesPeopleRand + " have " + descRand + " their new " + vehiclesRand + ". " +
                    "According to " + reviewersRand + ", the " + vehiclesRand + " is " + adjRand + ". " +
                    " If I were " + vehiclesPeopleRand + "'s rival, I'd be scared. \n \n" + "- " + authorsRand);
        } else if (MarketplaceHome.tvDemandStatus.getText().toString().equals("Home Décor")) {
            MarketplaceHome.tvTrendDesc.setText(homeDecorRand + ", we all need them. Which probably explains why " + homeDecorPeopleRand +
                    " have designed some really " + adjRand + " " + homeDecorRand + ". Be sure to check " +
                    "them out! \n \n" + "- " + authorsRand);
        } else if (MarketplaceHome.tvDemandStatus.getText().toString().equals("Furniture")) {
            MarketplaceHome.tvTrendDesc.setText(furniturePeopleRand + " have really boosted their reputation with their new " +
                    "release of " + furnitureRand + ". Honestly, it is quite " + adjRand + ". Go check " +
                    "it out! \n \n" + "- " + authorsRand);
        }


    */}
}
