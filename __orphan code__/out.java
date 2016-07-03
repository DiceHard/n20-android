/* Dave, this is just some off-the cuff side-prototyping to inject 
 * into our Java file when it's ready. It's not working yet, 3/4 sudo code.
 * Check out the comments and see if I missed anything big in this 
 * architecture. Obviously a lot of these features are prep for the physics
 * engine and won't be needed yet. But before that, we can still have a 
 * working prototype with 'future ready' features.
 */

class Die /* implements someInterface */ {

    //from geometrical center to farthest point coordinate.
    //used to get dice size for spin & medium resistance
    private double radius;
    //random. Has slight variation from geoctr.
    private double[] gravctr = [] 
    class Geometry { //This class will allow us to declare a shape
		     //and then inject it into the die object 
	private int sides,
		//star superstructure: points connect to gravctr.
 	//3 point coordiates: lattitude, longitude, altitude
        private double[] geoCtr = {0,0,0}
        private double[] pointRA = {} //3d array of point coordinates
				      //grouped by tripod/4pod/etc
		//highest level maps to a sideRA index (1,2,3... 20)
	private int[] sideRA = {} //1d array that maps to pointRA
			  //this might be simpler if we use index as the map			      //or if we use a dictionary instead of an array.

	//constructor (So you now what this spaghetti is supposet to be :P)
	public Geometry(int sides, double[] pointRA, int[] sideRA) {
	    sides = sides;
	    pointRA = pointRA;
	    sideRA = sideRA;
	    geoCtr = {0,0,0}; //Is this necessary to declare?
	}
	// method declarations    
    }

    class Material { //This class will allow us to declare a material 
		     //and then inject it into the die object.
	private double density; //To calculate mass
	private double friction; //To calculate friction coeficient
	private double elasticity; //To calculate bounce

	//constructor (So you now what this spaghetti is supposet to be :P)
	public Material(double density, double friction, double elasticity) {
	    density = density;
	    friction = friction;
	    elasticity = elasticity;
	} 
	// method declarations

    }
    
    
    //constructor, -> instantiate with Radius, Geometry, and Material
					//gravctr randomly generated
    public Die(double radius, class Geometry, class Material) { //can you pass a class as an arg into a constructor?
	gravCtr = {0,0,0}//for now. 
			 //Eventually invoke random to make tiny flaws.
	radius = radius;
	Geometry = Geometry;
	Material = Material;
    }


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
