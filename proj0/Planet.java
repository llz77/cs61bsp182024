public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67*Math.pow(10, -11);

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double deltaX = this.xxPos - p.xxPos;
        double deltaY = this.yyPos - p.yyPos;
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }

    public double calcForceExertedBy(Planet p) {
        return G*this.mass*p.mass/(calcDistance(p)*calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }


    public double calcNetForceExertedByX(Planet[] planets) {

        double sum = 0;
        for (Planet p: planets) {
            if (!this.equals(p)) {
                sum += this.calcForceExertedByX(p);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {

        double sum = 0;
        for (Planet p: planets) {
            if (!this.equals(p)) {
                sum += this.calcForceExertedByY(p);
            }
        }
        return sum;
    }

    public void update(double dt, double fX, double fY) {
        double fax = fX / this.mass;
        double fay = fY / this.mass;
        this.xxVel += dt * fax;
        this.yyVel += dt * fay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
        StdDraw.show();
    }
}
