import java.util.Arrays;

public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        @Deprecated
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        @Deprecated
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] Plants = new Planet[number];
        for (int i = 0; i < number; i++) {

            double xxPos = in.readDouble();
            double yyPos= in.readDouble();
            double xxVel= in.readDouble();
            double yyVel= in.readDouble();
            double mass= in.readDouble();
            String imgFileName = in.readString();
            Plants[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return Plants;
    }


}
