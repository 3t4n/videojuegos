package calculadora;

import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class BackgroundCalculadora extends SwingWorker< String, Object >
{
   private final String str;
   private final JLabel resultJLabel; 

   public BackgroundCalculadora( String str, JLabel label )
   {
      this.str = str;
      resultJLabel = label;
   } 

   public String doInBackground() throws Exception
   {
      String res = op(str);
      return res;
   } // end method doInBackground

   protected void done()
   {
      try
      {
         resultJLabel.setText( get() );
      } // end try
      catch ( InterruptedException ex ) 
      {
         resultJLabel.setText( "Interrupted while waiting for results." );
      } // end catch
      catch ( ExecutionException ex ) 
      {
         resultJLabel.setText( 
            "Error encountered while performing calculation." );
      } // end catch
   } // end method done

   public String op( String str ) throws Exception
   {	
	Object test = new ScriptEngineManager().getEngineByName("JavaScript").eval(str);
	return test.toString();
   } 
} 
