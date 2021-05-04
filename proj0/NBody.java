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

    public static void main(String[] args)
    {
        /* collect all needed input */
        // get T & dt
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        //Store the 2nd command line argument as a String named filename.
        String filename = args[2];
        //Read in the bodies and the universe radius from the file
        double radius = readRadius(filename);
        Body[] planets = readBodies(filename);

        /* Drawing the Background */



    }
}
