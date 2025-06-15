

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {
            
            //implement logic here
            // 1. Read the request body and convert JSON to a Song object
            String jsonString = ctx.body();
            Song song = om.readValue(jsonString, Song.class);

            // 2. Return the same Song object as JSON
            ctx.json(song);
            });  

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            //implement logic here
            /// 1. Read and convert to a Song object
            String jsonString = ctx.body();
            Song song = om.readValue(jsonString, Song.class);

            // 2. Update the artist
            song.setArtistName("Beatles");

            // 3. Return the updated object as JSON
            ctx.json(song);
        });

        return app;
    }
}