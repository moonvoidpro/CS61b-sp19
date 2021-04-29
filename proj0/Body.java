public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Body(double xP, double yP, double xV,
                double yV, double m, String img)
    {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Body(Body b)
    {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b)
    {
        double xDistance = this.xxPos - b.xxPos;
        double yDistance = this.yyPos - b.yyPos;
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
    public double calcForceExertedBy(Body b)
    {
        double constantG = 6.67E-11;
        return (constantG * this.mass * b.mass)/(this.calcDistance(b) * this.calcDistance(b));
    }
    public double calcForceExertedByX(Body b)
    {
        double xGap = b.xxPos - this.xxPos;
        return (this.calcForceExertedBy(b) * xGap)/this.calcDistance(b);
    }
    public double calcForceExertedByY(Body b)
    {
        double yGap = b.yyPos - this.yyPos;
        return (this.calcForceExertedBy(b) * yGap)/this.calcDistance(b);
    }
    public double calcNetForceExertedByX(Body[] allBodys)
    {
        double netForceX = 0;
        for (Body allBody : allBodys) {
            if (!allBody.equals(this)) {
                netForceX += this.calcForceExertedByX(allBody);
            }
        }
        return  netForceX;
    }
    public double calcNetForceExertedByY(Body[] allBodys)
    {
        double netForceY = 0;
        for (Body allBody : allBodys) {
            if (!allBody.equals(this)) {
                netForceY += this.calcForceExertedByY(allBody);
            }
        }
        return  netForceY;
    }
    public void update(double dt, double fX, double fY)
    {
        /* fX fY are the forces add on the Body */
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += aX * dt;
        this.yyVel += aY * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
}
