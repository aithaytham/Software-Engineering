package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
//import android.sup     port.v7.widget.RecyclerView;
import com.opencsv.CSVReader;

import android.content.res.Resources;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.os.Bundle;
import android.widget.TextView;


public class BandActivity extends AppCompatActivity {
    private TextView mText;
    List<BandClass> bandList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.textView);
        initialisation();



    }

    protected void initialisation (){
        try {
            Scanner scanner = new Scanner(new File("../../../../../res/raw/library.csv"));
            Scanner valueScanner = null;
            int index = 0;
            int albumid=0;
            while (scanner.hasNextLine()) {
                valueScanner = new Scanner(scanner.nextLine());
                valueScanner.useDelimiter(",");
                BandClass band = new BandClass();
                AlbumClass album = new AlbumClass();
                SongClass song = new SongClass();
                boolean token =true;
                boolean used =true;
                boolean tokensong =true;
                while (valueScanner.hasNext()) {
                    String data = valueScanner.next();
                    if (index == 0){
                        for(int y=0;y<bandList.size();y++){
                            if(bandList.get(y).getName()==data){
                                token= false;
                            }
                        }
                        if(token){
                            band.setName(data);
                            token=true;
                            bandList.add(band);
                        }
                    }
                    else if (index == 1){
                        if(token){
                            album.setName(data);
                            band.album.add(album);
                        }
                        else
                        {
                            for(int y=0;y<band.album.size();y++){
                                if(band.album.get(y).getName()==data){
                                    used= false;
                                    albumid=y;
                                }
                            }
                            if(used){
                                album.setName(data);
                                band.album.add(album);
                                albumid=(band.album.size())-1;
                            }

                        }

                    }
                    else if (index == 2){
                        if(token){
                            song.setName(data);
                            band.album.get(0).song.add(song);
                            albumid=0;
                        }
                        else
                        {
                            if(used){
                                song.setName(data);
                                band.album.get(albumid).song.add(song);
                                albumid=0;
                            }
                            else{
                                for(int y=0;y<band.album.get(albumid).song.size();y++){
                                    if(band.album.get(albumid).song.get(y).getName()==data){
                                        tokensong= false;
                                    }
                                }
                                if(tokensong){
                                    song.setName(data);
                                    band.album.get(albumid).song.add(song);
                                    albumid=0;
                                    used=true;
                                    token=true;
                                    tokensong=true;
                                }
                            }


                        }
                        index++;
                    }
                    index = 0;
                }

                scanner.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            mText.setText("notfound");

        }
    }
}
