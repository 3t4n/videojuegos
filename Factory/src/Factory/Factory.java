package Factory;
import java.awt.*;
import java.awt.Color;
import java.util.*;

public interface Factory
{
	public ArrayList<Entity> bulkProduction();
	public void increseProduction();
	public void decreaseProduction();
	public void reset();
}

