/* Dave, this is just some off-the cuff side-prototyping to inject 
 * into our Java file when it's ready. It's not working yet, 3/4 sudo code.
 * Check out the comments and see if I missed anything big in this 
 * architecture. Obviously a lot of these features are prep for the physics
 * engine and won't be needed yet. But before that, we can still have a 
 * working prototype with 'future ready' features.
 */

class Die /* implements someInterface */ {
 
    double radius; //from geometrical center to farthest point coordinate.
		   //used to get dice size for spin & medium resistance
    double[] gravctr = [] //random. Has slight variation from geoctr.

    class geometry { //This class will allow us to declare a shape
		     //and then inject it into the die object 
	int sides,
		//star superstructure: points connect to gravctr.
        double[] geoctr = [0,0,0] //3 point coordiates: lat, lon, altitude
        double[] pointRA = [] //3d array of point coordinates
			      //grouped by tripod/4pod/etc
		//highest level maps to a sideRA index (1,2,3... 20)
	int[] sideRA = [] //1d array that maps to pointRA
			  //this might be simpler if we use index as the map

	//constructor, and 
	// method declarations    
    }

    class material { //This class will allow us to declare a material 
		     //and then inject it into the die object.
	double density; //To calculate mass
	double friction; //To calculate friction coeficient
	double elasticity; //To calculate bounce

	//constructor, and 
	// method declarations

    }
    
    
    //constructor, -> instantiate with Radius, Geometry, and Material
					//gravctr randomly generated


    // method declarations
    //phase 1 roll physics:
	//set facing method; -> scrolls point array indecies
	//roll method; -> randomly selects "side" from array, returns value.
	//Wheatonize method; Make the screen crazy/evil on "1" and "20"
    //Database push method -> save the sample for SCIENCE!
}

/* Special rolls: Roll Multiple,
 *		  Roll Additional,
 *		  Roll Mix,
 *		  Take Highest, Take Lowest,
 *		  Digitize
 * will be android activities that call die.roll procedurally.
 */


//initial procedural prototype
public class out {

    public static void main(String [] args) {
	int sides = 20;
	int roll = (int)Math.ceil(Math.random() * sides);
	System.out.println(roll);
    }
}
