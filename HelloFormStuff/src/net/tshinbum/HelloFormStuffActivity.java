
package net.tshinbum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class HelloFormStuffActivity extends Activity {
    /** Called when the activity is first created. */
    //@Override
    public void onCreateO(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button button = (Button) findViewById(R.id.button);
        
        //button.setOnClickListener(new);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
                Toast.makeText(HelloFormStuffActivity.this, "Beep Bop", Toast.LENGTH_SHORT).show();
            }
        });
        
        final RatingBar rb1 = (RatingBar) findViewById(R.id.ratingBar1);
        rb1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Toast.makeText(HelloFormStuffActivity.this, "woohooo", Toast.LENGTH_SHORT).show();
        	}
        });
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
       super.onCreate(savedInstanceState);                      
  
       new Thread( new Runnable( ) 
       {
          public void run( )
          {        		
             final float frequency = 440;
             float increment = (float)(2*Math.PI) * frequency / 44100; // angular increment for each sample
             float angle = 0;
             AndroidAudioDevice device = new AndroidAudioDevice( );
             float samples[] = new float[1024];
             for( int i = 0; i < samples.length; i++ )
             {
                samples[i] = (float)Math.sin( angle );
                angle += increment;
             }
  
             while( true )
             {
                device.writeSamples( samples );
             }        	
          }
       } ).start();
    }
}