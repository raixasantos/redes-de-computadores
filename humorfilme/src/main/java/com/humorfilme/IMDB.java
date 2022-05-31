package com.humorfilme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.IOException;
import java.util.logging.*;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.util.Arrays;
import com.google.gson.Gson;

public class IMDB {

    public String callingAPIService(String mood) {
        Dados dados = new Dados();
        Object filme = new Object();
        String[] str_arr = {""};
        try {
            String url = "https://imdb-api.com/en/API/Keyword/k_cdmc38z1/" + mood;

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }

            conn.disconnect();

            Gson gson = new Gson();
            Random rand = new Random();
            dados = gson.fromJson(new String(output.getBytes()), Dados.class);
            int randNum = rand.nextInt(dados.getItems().length);
            filme = dados.getItemByPosition(randNum);
            str_arr = filme.toString().split(",");
        } catch (IOException ex) {
            Logger.getLogger(IMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str_arr[1].substring(7);
    }
}