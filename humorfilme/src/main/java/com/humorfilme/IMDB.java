package com.humorfilme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.*;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.util.Arrays;
import com.google.gson.Gson;

public class IMDB {

    public Dados callingAPIService() {
        Dados dados = new Dados();
        try {
            String url = "https://imdb-api.com/en/API/Search/k_cdmc38z1/inception%202010";

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
            dados = gson.fromJson(new String(output.getBytes()), Dados.class);

            // System.out.println("SEARCH TYPE: " + dados.getSearchType());
            // System.out.println("EXPRESSION: " + dados.getExpression());

        } catch (IOException ex) {
            Logger.getLogger(IMDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dados;
    }
}