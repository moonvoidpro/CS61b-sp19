import java.lang.management.PlatformLoggingMXBean;

public class NBody {
    public static double readRadius(String fileName)
    {
//        return a double corresponding to the radius
//        of the universe in that file
        In dataIn = new In(fileName);
        dataIn.readInt(); // skip the first number ( numbers of planets)
        return dataIn.readDouble();
    }

    public static Body[] readBodies(String fileName)
    {
        In dataIn = new In(fileName);
        int num = dataIn.readInt();
        dataIn.readDouble();
        Body[] bodyList = new Body[num];
        for (int i = 0; i < num; i++) {
            double xP = dataIn.readDouble();
            double yP = dataIn.readDouble();
            double xV = dataIn.readDouble();
            double yV = dataIn.readDouble();
            double mass  = dataIn.readDouble();
            String img = dataIn.readString();
            bodyList[i] = new Body(xP, yP, xV, yV, mass, img);
            // the ways to generate class Body are limited
        }
        return bodyList;
    }

    public static void main(String[] args) {
        /* collect all needed input */
        // get T & dt
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        // Store the 2nd command line argument as a String named filename.
        String filename = args[2];
        // Read in the bodies and the universe radius from the file
        double radius = NBody.readRadius(filename);
        Body[] planets = NBody.readBodies(filename);

        /* Drawing the Background */
        // set the scale so that it matches the radius of the universe
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Body planet : planets) {
            planet.draw();
        }
        StdDraw.show();
        StdDraw.pause(2000);

        /* animation**/
        // Create a variable that represents time. Set it to 0.
        // loop until this time variable reaches (and includes) the T from above.
        for (double t = 0; t <= T; t += dt) {
            // Create an xForces array and yForces array.
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            // call update on each of the Bodys.
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            // Draw the background image.
            StdDraw.picture(0, 0, "images/starfield.jpg");
            // Draw all of the Bodys.
            for (Body planet : planets) {
                planet.draw();
            }
            //Show the offscreen buffer (see the show method of StdDraw).
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",);
        }
    }
}
